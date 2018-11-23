package com.ey.piit.sdo.price.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.price.service.SkdPriceService;
import com.ey.piit.sdo.price.vo.SkdPriceVo;

public class SkdPriceImportHandler implements ImportDataHandler<SkdPriceVo> {
	private SkdPriceService skdPriceService = SpringUtils.getBean(SkdPriceService.class);
	@Override
	public void handleDatas(List<SkdPriceVo> list, Map<String, String> params) {
		for(int i=0;i<list.size();i++){
			SkdPriceVo vo=list.get(i);
			vo.setId("");
			vo.setOper(Oper.add);
			this.validate(vo);
			skdPriceService.edit(vo);
		}

	};
	
	
	private void validate(SkdPriceVo vo) {
		if (!StringUtils.isNotBlank(vo.getWlbh())) {
			throw new ServiceException("物料编号不能为空");
		}
	    if (!StringUtils.isNotBlank(vo.getBz())) {
			throw new ServiceException("币种不能为空");
		}
		if (vo.getYxqks()==null) {
			throw new ServiceException("有效期开始不能为空");
		}
		if (vo.getYxqjs()==null) {
			throw new ServiceException("有效期结束不能为空");
		}
	
	}
}
