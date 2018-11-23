package com.ey.piit.basesys.data.repository;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ey.piit.core.dao.jdbc.BaseJdbcDao;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.utils.ExceptionUtils;
import com.ey.piit.core.utils.StringUtils;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
public class BatchJdbcDao extends BaseJdbcDao {
	
	public static final String SUFFIX_VO = "Vo";
	public static final String SUFFIX_DTO = "Dto";
	public static final String PERFIX_T = "T_";
	public static final char UNDERLINE = '_';
	
	public static Map<Class<?>, BatchBean> batchMap = new HashMap<Class<?>, BatchBean>();
	
	public void batchSave(final List<?> list) {
		batchSave(list,null);
	}
	
	public void batchSave(final List<?> list,String tableName) {
		batchSave(list,null,null);
	}
	
	public void batchSave(final List<?> list,String tableName,final Map<String,Object> extColumn) {
		if (list == null || list.size() == 0) {
			return;
		}
		Object object = list.get(0);
		Class<?> clz = object.getClass();
		
		BatchBean batchBean = getBatchBean(clz);
		final Field[] fields = batchBean.fields;
		
		String insertSql = batchBean.insertSql;
		final List<Object> extList = new ArrayList<Object>();
		
		if (tableName != null) {
			insertSql = insertSql.replace(batchBean.tableName, tableName);
		}
		
		if (extColumn != null) {
			StringBuilder inColumnSB = new StringBuilder();
			StringBuilder inValueSB = new StringBuilder();
			Iterator<String> iterator = extColumn.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				Object val = extColumn.get(key);
				extList.add(val);
				inColumnSB.append(", ");
				inColumnSB.append(key);
				inValueSB.append(", ?");
			}
			inColumnSB.append(") values (");
			inValueSB.append(")");
			insertSql = insertSql.replace(") values (", inColumnSB.toString());
			insertSql = insertSql.substring(0, insertSql.length() - 1) + inValueSB.toString();
		}
		
		JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
				jdbcTemplate.getDataSource());
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			jdbcTemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter(){
				
				public int getBatchSize() {
					return list.size();
				}
				
				public void setValues(PreparedStatement ps, int index)
						throws SQLException {
					Object obj = list.get(index);
					System.out.println(index);
					
					try {
						for (int i = 0; i < fields.length; i++) {
							Field field = fields[i];
							field.setAccessible(true);
							Class<?> type = field.getType();
							Object val = field.get(obj);
							setValue(ps,i+1,type,val);
						}
						for (int j = 0; j < extList.size(); j++) {
							Object val = extList.get(j);
							setValue(ps,fields.length+j+1,val.getClass(),val);
						}
					} catch (Exception e) {
						throw new ServiceException(e);
					}
				}
				
			});
			transactionManager.commit(status);
		} catch (Exception ex) {
			transactionManager.rollback(status);
			throw new ServiceException(ExceptionUtils.getRootCauseMessage(ex));
		}
        
	}
	
	public void batchUpdate(final List<?> list,final List<String> whereColumn) {
		batchUpdate(list,null,whereColumn);
	}
	
	public void batchUpdate(final List<?> list,String tableName,final List<String> whereColumn) {
		if (list == null || list.size() == 0) {
			return;
		}
		if (whereColumn == null || whereColumn.size() == 0) {
			throw new ServiceException("不能没有where条件");
		}
		Object object = list.get(0);
		Class<?> clz = object.getClass();
		
		BatchBean batchBean = getBatchBean(clz);
		final Field[] fields = batchBean.updFields;
		String sql = batchBean.updateSql;
		
		if (clz.getSimpleName().lastIndexOf(SUFFIX_VO) != -1 || clz.getSimpleName().lastIndexOf(SUFFIX_DTO) != -1) {
			clz = clz.getSuperclass();
		}
		
		if (tableName != null) {
			sql = sql.replace(batchBean.tableName, tableName);
		}
		
		StringBuilder whereSB = new StringBuilder();
		final Field[] whereFields = new Field[whereColumn.size()];
		
		for (int j = 0; j < whereColumn.size(); j++) {
			String where = whereColumn.get(j);
			String whereCamel = camelToUnderline(where);
			
			if (j != 0) {
				whereSB.append(", ");
			}
			whereSB.append(whereCamel);
			whereSB.append("=?");
			
			try {
				whereFields[j] = clz.getDeclaredField(where);
			} catch (Exception e) {
				throw new ServiceException(e);
			}
		}
		
		sql += whereSB;
		
		JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
				jdbcTemplate.getDataSource());
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){
	
				public int getBatchSize() {
					return list.size();
				}
	
				public void setValues(PreparedStatement ps, int index)
						throws SQLException {
					Object obj = list.get(index);
					
					try {
						int fieldIndex = 0;
						for (int i = 0; i < fields.length; i++) {
							Field field = fields[i];
							if (field == null) {
								continue;
							}
							field.setAccessible(true);
							Class<?> type = field.getType();
							Object val = field.get(obj);
							setValue(ps,fieldIndex+1,type,val);
							fieldIndex++;
						}
						
						for (int j = 0; j < whereFields.length; j++) {
							Field field = whereFields[j];
							field.setAccessible(true);
							Class<?> type = field.getType();
							Object val = field.get(obj);
							setValue(ps,j+1+fieldIndex,type,val);
						}
					} catch (Exception e) {
						throw new ServiceException(e);
					}
				}
				
			});
			transactionManager.commit(status);
		} catch (Exception ex) {
			transactionManager.rollback(status);
			throw new ServiceException(ExceptionUtils.getRootCauseMessage(ex));
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
	
	private void setValue(PreparedStatement ps,int i,Class<?> type,Object val) throws Exception{
		if (type == String.class) {
			if (val == null) {
				ps.setNull(i, Types.VARCHAR);
			} else {
				ps.setString(i, (String)val);
			}
		} else if (type == Date.class) {
			if (val == null) {
				ps.setNull(i, Types.DATE);
			} else {
				ps.setTimestamp(i, new Timestamp(((Date)val).getTime()));
			}
		} else if (type == Integer.class) {
			if (val == null) {
				ps.setNull(i, Types.INTEGER);
			} else {
				ps.setInt(i, (Integer)val);
			}
		}  else if (type == Long.class) {
			if (val == null) {
				ps.setNull(i, Types.BIGINT);
			} else {
				ps.setLong(i, (Long)val);
			}
		} else if (type == BigDecimal.class) {
			if (val == null) {
				ps.setNull(i, Types.NUMERIC);
			} else {
				ps.setBigDecimal(i, (BigDecimal)val);
			}
		} else if (type == Double.class) {
			if (val == null) {
				ps.setNull(i, Types.DOUBLE);
			} else {
				ps.setDouble(i, (Double)val);
			}
		}
	}

	@Override
	protected Map<String, String> getColMap() {
		return null;
	}
	
	private BatchBean getBatchBean(Class<?> clz){
		BatchBean batchBean = batchMap.get(clz);
		if (batchBean != null) {
			return batchBean;
		}
		
		Class<?> oldClz = clz;
		String simpleName = clz.getSimpleName();
		
		//解决使用Vo或Dto对象保存找不到表和字段问题
		if (simpleName.lastIndexOf(SUFFIX_VO) != -1 || simpleName.lastIndexOf(SUFFIX_DTO) != -1) {
			clz = clz.getSuperclass();
			simpleName = clz.getSimpleName();
		}
		
		String tableName = PERFIX_T + camelToUnderline(simpleName);
		
		final Field[] fields = clz.getDeclaredFields();
		
		StringBuilder inColumnSB = new StringBuilder();
		StringBuilder inValueSB = new StringBuilder();
		StringBuilder upColumnSB = new StringBuilder();
		int updIndex = 0;
		Field[] updFields = new Field[fields.length];
		
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			
			String columnCamel = camelToUnderline(fieldName);
			
			if (i != 0) {
				inColumnSB.append(", ");
				inValueSB.append(", ");
			}
			
			inColumnSB.append(columnCamel);
			inValueSB.append("?");
			
			if (!"id".equals(fieldName) && !"creator".equals(fieldName) && !"createTime".equals(fieldName)) {
				if (updIndex != 0) {
					upColumnSB.append(", ");
				}
				upColumnSB.append(columnCamel);
				upColumnSB.append("=?");
				updIndex++;
				updFields[updIndex] = field;
			}
		}
		
		batchBean = new BatchBean();
		batchBean.insertSql = "INSERT INTO "+tableName+" ("+inColumnSB+") values ("+inValueSB+")";
		batchBean.updateSql = "UPDATE "+tableName+" SET "+upColumnSB+" WHERE ";
		batchBean.fields = fields;
		batchBean.updFields = updFields;
		batchBean.tableName = tableName;
		
		batchMap.put(oldClz, batchBean);
		return batchBean;
	}
	
	class BatchBean {
		String insertSql;
		String updateSql;
		Field[] fields;
		Field[] updFields;
		String tableName;
	}
}
