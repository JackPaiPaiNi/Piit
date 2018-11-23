package com.ey.piit.baseinfo.area.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ey.piit.baseinfo.area.vo.AreaVo;
import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.basesys.data.repository.BatchJdbcDao;
import com.ey.piit.core.entity.CoreEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;

/**
 * 地区导入
 * @author Kevin-Y.Xu
 *
 */
public class AreaImportHandler extends BaseService implements ImportDataHandler<AreaVo> {
	
	private BatchJdbcDao batchJdbcDao = SpringUtils.getBean(BatchJdbcDao.class);

	@Override
	public void handleDatas(List<AreaVo> list, Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		String empCode = findCurUser().getEmpCode();
		List<AreaVo> saveList = new ArrayList<AreaVo>();
		
		for (int i = 0; i < list.size(); i++) {
			AreaVo record = list.get(i);
			try {
				validate(record);
				
				Date now = new Date();
				record.setId(UUID.randomUUID().toString());
				record.setCreator(empCode);
				record.setCreateTime(now);
				record.setLastUpdater(empCode);
				record.setLastUpdateTime(now);
				record.setOper(Oper.add);
					
				saveList.add(record);
			} catch (Exception e) {
				String message = e.getMessage();
				sb.append(i+2);
				sb.append("行：");
				sb.append(message);
				sb.append("\n");
			}
		}
		
		if (sb.length() > 0) {
			throw new ValidateException(sb.toString());
		}
		
		batchJdbcDao.batchSave(saveList);
	}

	private void validate(AreaVo area) {
		String code = area.getCode();
		if (StringUtils.isNotBlank(code) && code.equals(area.getParentCode())) {
			throw new ServiceException("上级节点不能是本节点");
		}
		if (StringUtils.isBlank(area.getCode())) {
			throw new ServiceException("编码不能为空");
		}
		if (StringUtils.isBlank(area.getCnName())) {
			throw new ServiceException("中文名称不能为空");
		}
		if (StringUtils.isBlank(area.getStatus())) {
			throw new ServiceException("状态不能为空");
		}
	}

}
