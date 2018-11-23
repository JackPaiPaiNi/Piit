package com.ey.piit.sdo.mdm.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.mdm.repository.ExchangeRateDao;
import com.ey.piit.sdo.mdm.vo.ExchangeRateVo;

public class ExchangeRateImportHandler implements ImportDataHandler<ExchangeRateVo> {
	private ExchangeRateDao exchangeRateDao = SpringUtils.getBean(ExchangeRateDao.class);
	@Override
	public void handleDatas(List<ExchangeRateVo> list, Map<String, String> params) {
		for(int i=0; i<list.size(); i++){
			ExchangeRateVo vo = list.get(i);
			vo.preInsert();
			this.validate(vo);
			exchangeRateDao.insert(vo);
		}

	};
	
	
	private void validate(ExchangeRateVo vo) {
		if (!StringUtils.isNotBlank(vo.getCbz())) {
			throw new ServiceException("从币种不能为空");
		}
		if (!StringUtils.isNotBlank(vo.getDbz())) {
			throw new ServiceException("到币种不能为空");
		}
	}
}
