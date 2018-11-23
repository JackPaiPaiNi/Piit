package com.ey.piit.sdo.report.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.report.repository.ReportSkdOrderStatusDao;
import com.ey.piit.sdo.report.vo.ReportSkdOrderStatusVo;

public class SkdOrderStatusImportHandler implements ImportDataHandler<ReportSkdOrderStatusVo> {
	private ReportSkdOrderStatusDao reportSkdOrderStatusDao = SpringUtils.getBean(ReportSkdOrderStatusDao.class);
	@Override
	public void handleDatas(List<ReportSkdOrderStatusVo> list, Map<String, String> params) {
		for(int i=0; i<list.size(); i++){
			ReportSkdOrderStatusVo vo = list.get(i);
			vo.preInsert();
			this.validate(vo);
			reportSkdOrderStatusDao.insert(vo);
		}

	};
	
	
	private void validate(ReportSkdOrderStatusVo vo) {
		if (!StringUtils.isNotBlank(vo.getDdid())) {
			throw new ServiceException("从订单号不能为空");
		}
		if (!StringUtils.isNotBlank(vo.getChdh())) {
			throw new ServiceException("出货单号不能为空");
		}
	}
}
