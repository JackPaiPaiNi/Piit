package com.ey.piit.basesys.history.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basesys.history.entity.History;
import com.ey.piit.basesys.history.repository.HistoryDao;
import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.BaseEntity;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.utils.StringUtils;

/**
 * 流程历史服务，线程不安全的
 * @author Kevin-Y.Xu
 *
 */
@Service
public class ProcessHistoryService {
	public static final char UNDERLINE = '_';
	public static final String PERFIX_T = "T_";
	public static final String SUFFIX_HIST = "_HIST";
	public static final String SUFFIX_TEMP = "_TEMP";
	public static final String SUFFIX_VO = "Vo";
	public static final String TABLE_NAME = "tableName";
	public static final String TABLE_COLUMN = "tableColumn";
	public static final String COLUMN_VALUE = "columnValue";
	public static final String HIST_VERSION = "histVersion";
	public static final String HIST_TYPE = "histType";
	public static final String HIST_STATUS = "histStatus";
	public static final String ID = "id";
	public static final String HIST_TYPE_A = "A";
	public static final String HIST_TYPE_U = "U";
	public static final String HIST_TYPE_D = "D";
	public static final String HIST_TYPE_P = "P";
	public static final String HIST_TYPE_R = "R";
	
	@Autowired
	private HistoryDao historyDao;
	
	private static Map<Class<?>,History> histMap = new HashMap<Class<?>,History>();

	public void save(Object obj) {
		try {
			int version = 0;
			String type = null;
			String status = null;
			
			BaseEntity record = (BaseEntity)obj;
			String id = record.getId();
			if (StringUtils.isBlank(id)) {
				throw new ServiceException("ID不能为空");
			}
			if (record.getOper() == null) {
				throw new ServiceException("非法操作");
			}
			
			History history = getHistory(obj);
			History cloneBean = (History)BeanUtils.cloneBean(history);
			cloneBean.setId(id);
			Map<String, Object> tempMap = historyDao.selectTempById(cloneBean);
			
			if (Oper.add.equals(record.getOper())) {//如果是新增
				
				//如果是新增操作但是临时表中有记录
				if (tempMap != null && tempMap.size() != 0) {
					throw new ServiceException("操作错误");
				}
				type = HIST_TYPE_A;
			} else {
				status = tempMap.get(HIST_STATUS).toString();
				if (Constants.STATUS_ENABLED.equals(status)) {//在流程中
					type = tempMap.get(HIST_TYPE).toString();
				} else {//新发起的流程
					if (Oper.edit.equals(record.getOper())) {
						type = HIST_TYPE_U;
					} else if (Oper.del.equals(record.getOper())) {
						type = HIST_TYPE_D;
					}
				}
				version = Integer.parseInt(tempMap.get(HIST_VERSION).toString());
				
				//删除旧的临时记录
				historyDao.deleteTempById(cloneBean);
			}
			version++;
			
			@SuppressWarnings("unchecked")
			Map<String, Object> recordMap = PropertyUtils.describe(obj);
			
			recordMap.put(TABLE_NAME, history.getTableNameTemp());
			recordMap.put(TABLE_COLUMN, history.getTableColumn());
			recordMap.put(COLUMN_VALUE, history.getColumnValue());
			recordMap.put(HIST_VERSION, version);
			recordMap.put(HIST_TYPE, type);
			recordMap.put(HIST_STATUS, Constants.STATUS_ENABLED);
			historyDao.insert(recordMap);
			
			recordMap.put(TABLE_NAME, history.getTableNameHist());
			historyDao.insert(recordMap);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * 根据ID获得临时表的数据，如果未找到或数据失效返回null
	 * @param t
	 * @return
	 */
	public <T> T findTempById(T t){
		try {
			BaseEntity record = (BaseEntity)t;
			String id = record.getId();
			if (StringUtils.isBlank(id)) {
				throw new ServiceException("ID不能为空");
			}
			
			History history = getHistory(t);
			History cloneBean = (History)BeanUtils.cloneBean(history);
			cloneBean.setId(id);
			Map<String, Object> map = historyDao.selectTempById(cloneBean);
			
			if (map == null || map.size() == 0) {
				return null;
			}
			
			String status = map.get(HIST_STATUS).toString();
			if (!Constants.STATUS_ENABLED.equals(status)) {
				return null;
			}
			
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return t;
	}
	
	public void commit(Object obj){
		try {
			BaseEntity record = (BaseEntity)obj;
			String id = record.getId();
			if (StringUtils.isBlank(id)) {
				throw new ServiceException("ID不能为空");
			}
			
			History history = getHistory(obj);
			History cloneBean = (History)BeanUtils.cloneBean(history);
			cloneBean.setId(id);
			Map<String, Object> tempMap = historyDao.selectTempById(cloneBean);
			
			int version = 0;
			String type = null;
			
			if (tempMap != null && tempMap.size() > 0) {
				
				//删除临时记录
				historyDao.deleteTempById(cloneBean);
				
				version = Integer.parseInt(tempMap.get(HIST_VERSION).toString());
				type = tempMap.get(HIST_TYPE).toString();
			} else {
				if (Oper.add.equals(record.getOper())) {
					type = HIST_TYPE_A;
				} else if (Oper.edit.equals(record.getOper())) {
					type = HIST_TYPE_U;
				} else if (Oper.del.equals(record.getOper())) {
					type = HIST_TYPE_D;
				}
			}
			
			@SuppressWarnings("unchecked")
			Map<String, Object> recordMap = PropertyUtils.describe(obj);
			
			version++;
			
			recordMap.put(TABLE_NAME, history.getTableNameTemp());
			recordMap.put(TABLE_COLUMN, history.getTableColumn());
			recordMap.put(COLUMN_VALUE, history.getColumnValue());
			recordMap.put(HIST_VERSION, version);
			recordMap.put(HIST_TYPE, HIST_TYPE_P);
			recordMap.put(HIST_STATUS, Constants.STATUS_DISABLED);
			
			if (!Oper.del.equals(type)) {
				historyDao.insert(recordMap);
			}
			
			recordMap.put(TABLE_NAME, history.getTableNameHist());
			historyDao.insert(recordMap);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	public void rollBack(Object obj){
		try {
			BaseEntity record = (BaseEntity)obj;
			String id = record.getId();
			if (StringUtils.isBlank(id)) {
				throw new ServiceException("ID不能为空");
			}
			
			History history = getHistory(obj);
			History cloneBean = (History)BeanUtils.cloneBean(history);
			cloneBean.setId(id);
			Map<String, Object> tempMap = historyDao.selectTempById(history);
			
			if (tempMap == null || tempMap.size() == 0) {
				throw new ServiceException("没有临时记录");
			}
			
			String status = tempMap.get(HIST_STATUS).toString();
			if (!Constants.STATUS_ENABLED.equals(status)) {
				throw new ServiceException("失效的临时记录");
			}
			
			//删除临时记录
			historyDao.deleteTempById(cloneBean);
			
			@SuppressWarnings("unchecked")
			Map<String, Object> recordMap = PropertyUtils.describe(obj);
			
			int version = Integer.parseInt(tempMap.get(HIST_VERSION).toString());
			version++;
			
			recordMap.put(TABLE_NAME, history.getTableNameTemp());
			recordMap.put(TABLE_COLUMN, history.getTableColumn());
			recordMap.put(COLUMN_VALUE, history.getColumnValue());
			recordMap.put(HIST_VERSION, version);
			recordMap.put(HIST_TYPE, HIST_TYPE_R);
			recordMap.put(HIST_STATUS, Constants.STATUS_DISABLED);
			
			String type = tempMap.get(HIST_TYPE).toString();
			if (!Oper.add.equals(type)) {
				historyDao.insert(recordMap);
			}
			
			recordMap.put(TABLE_NAME, history.getTableNameHist());
			historyDao.insert(recordMap);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	private History getHistory(Object obj) {
		Class<?> clazz = obj.getClass();
		History history = histMap.get(clazz);
		if (history != null) {
			return history;
		}
		try {
			Class<?> oldClazz = clazz;
			String simpleName = clazz.getSimpleName();
			
			//解决使用Vo对象保存找不到表和字段问题
			if (simpleName.lastIndexOf(SUFFIX_VO) != -1) {
				clazz = clazz.getSuperclass();
				simpleName = clazz.getSimpleName();
			}
			
			String tableName = PERFIX_T+camelToUnderline(simpleName);
			history = new History();
			history.setTableName(tableName);
			history.setTableNameTemp(tableName+SUFFIX_TEMP);
			history.setTableNameHist(tableName+SUFFIX_HIST);
			Field[] fields = clazz.getDeclaredFields();
			
			StringBuilder columnSB = new StringBuilder();
			StringBuilder columnCamelSB = new StringBuilder();
			StringBuilder valueSB = new StringBuilder();
			
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				
				String columnCamel = camelToUnderline(field.getName());
				
				if (i != 0) {
					columnSB.append(", ");
					columnCamelSB.append(", ");
					valueSB.append(", ");
				}
				columnSB.append(columnCamel);
				
				columnCamelSB.append(columnCamel);
				columnCamelSB.append(" \"");
				columnCamelSB.append(field.getName());
				columnCamelSB.append("\"");
				
				valueSB.append("#{");
				valueSB.append(field.getName());
				valueSB.append("}");
			}
			
			columnSB.append(", HIST_VERSION, HIST_TYPE, HIST_STATUS");
			columnCamelSB.append(", HIST_VERSION \"histVersion\", HIST_TYPE \"histType\", HIST_STATUS \"histStatus\"");
			valueSB.append(", #{histVersion}, #{histType}, #{histStatus}");
			
			history.setTableColumn(columnSB.toString());
			history.setTableColumnCamel(columnCamelSB.toString());
			history.setColumnValue(valueSB.toString());
			
			histMap.put(oldClazz, history);
			return history;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	private String camelToUnderline(String param) {
		if (StringUtils.isBlank(param)) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				if (i != 0) {
					sb.append(UNDERLINE);
				}
				sb.append(c);
			} else {
				sb.append(Character.toUpperCase(c));
			}
		}
		return sb.toString();
	}

}
