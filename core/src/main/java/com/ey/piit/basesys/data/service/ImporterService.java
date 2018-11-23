package com.ey.piit.basesys.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basesys.data.convert.JsonDateValueProcessor;
import com.ey.piit.basesys.data.entity.FilePersistence;
import com.ey.piit.basesys.data.entity.ImportData;
import com.ey.piit.basesys.data.entity.ImportInfo;
import com.ey.piit.basesys.data.excel.setting.ExcelSetting;
import com.ey.piit.basesys.data.repository.FilePersistenceDao;
import com.ey.piit.basesys.data.repository.ImportDataJdbcDao;
import com.ey.piit.basesys.data.repository.ImportInfoDao;
import com.ey.piit.basesys.data.vo.ImportDataVo;
import com.ey.piit.basesys.data.vo.ImportInfoVo;
import com.ey.piit.core.dao.entity.QueryPage;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.Order;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

@Service
public class ImporterService extends CoreService{
	
	@Autowired
	private ImportDataJdbcDao importDataJdbcDao;
	
	@Autowired
	private ImportInfoDao importInfoDao;
	
	@Autowired
	private FilePersistenceDao filePersistenceDao;

	public String saveImportData(FilePersistence filePersistence,
			ImportInfo importInfo, List<ImportData> datas) {
		String fileId = UUID.randomUUID().toString();
		
		filePersistence.setId(fileId);
		filePersistenceDao.insert(filePersistence);
		
		String importId = UUID.randomUUID().toString();
		importInfo.setId(importId);
		importInfo.setFileId(fileId);
		importInfoDao.insert(importInfo);
		
		if (datas != null && datas.size() > 0) {
			for (ImportData data : datas) {
				data.setImportId(importId);
			}
			importDataJdbcDao.batchSaveImportData(datas);
		}
		
		return importId;
	}

	public List<ImportDataVo> queryImportDataByPage(Map<String, String> params, PageBounds page) {
		QueryPage queryPage = new QueryPage(page.getLimit(),page.getPage() - 1);
		queryPage.setCalCount(true);
		List<Order> orders = page.getOrders();
		if (orders != null && orders.size() > 0) {
			Order order = orders.get(0);
			queryPage.setSort(order.getProperty(), order.getDirection().toString());
		}
		return importDataJdbcDao.findImportDataByPage(queryPage, params);
	}

	public ImportInfoVo findImportInfoByImportId(String importId) {
		return importInfoDao.selectById(importId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findImportDataList(String importId,
			ExcelSetting excelSetting) {
		try {
			Class<?> clz = null;

			clz = Class.forName(excelSetting.getClassName());

			List<ImportDataVo> datas = importDataJdbcDao.findImportDataList(importId);
			List list = new ArrayList(datas.size());

//			JsonConfig jsonConfig = new JsonConfig();
//			jsonConfig.setIgnoreDefaultExcludes(false);
//			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//			jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new JsonDateValueProcessor());
//			jsonConfig.setRootClass(clz);
			JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {JsonDateValueProcessor.DEFAULT_DATE_PATTERN})); 
			
			for (ImportDataVo data : datas) {
				
				JSONObject json = JSONObject.fromObject(data.getExcelData());
				Object bean = JSONObject.toBean(json, clz);
				
				list.add(bean);
			}

			return list;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	public boolean haveImportErrData(String importId){
		return importDataJdbcDao.haveImportErrData(importId);
	}

	@Override
	protected ICoreDao getDao() {
		return null;
	}

	public ImportDataJdbcDao getImportDataJdbcDao() {
		return importDataJdbcDao;
	}

	public void setImportDataJdbcDao(ImportDataJdbcDao importDataJdbcDao) {
		this.importDataJdbcDao = importDataJdbcDao;
	}

	public ImportInfoDao getImportInfoDao() {
		return importInfoDao;
	}

	public void setImportInfoDao(ImportInfoDao importInfoDao) {
		this.importInfoDao = importInfoDao;
	}

	public FilePersistenceDao getFilePersistenceDao() {
		return filePersistenceDao;
	}

	public void setFilePersistenceDao(FilePersistenceDao filePersistenceDao) {
		this.filePersistenceDao = filePersistenceDao;
	}
}
