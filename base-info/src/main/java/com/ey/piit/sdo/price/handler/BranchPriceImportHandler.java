package com.ey.piit.sdo.price.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.price.service.BranchPriceService;
import com.ey.piit.sdo.price.vo.BranchPriceVo;

public class BranchPriceImportHandler implements ImportDataHandler<BranchPriceVo> {
	private BranchPriceService branchPriceService = SpringUtils.getBean(BranchPriceService.class);
	@Override
	public void handleDatas(List<BranchPriceVo> list, Map<String, String> params) {
		for(int i=0;i<list.size();i++){
			BranchPriceVo vo=list.get(i);
			vo.setId("");
			vo.setOper(Oper.add);
			this.validate(vo);
			branchPriceService.edit(vo);
		}

	};
	
	
	private void validate(BranchPriceVo vo) {
		if (!StringUtils.isNotBlank(vo.getXsymc())) {
			throw new ServiceException("销售员不能为空");
		}
		if (!StringUtils.isNotBlank(vo.getKhbm())) {
			throw new ServiceException("客户编码不能为空");
		}
	    if (!StringUtils.isNotBlank(vo.getKhmc())) {
			throw new ServiceException("客户名称不能为空");
		}
		if (!StringUtils.isNotBlank(vo.getJixing())) {
			throw new ServiceException("机型不能为空");
		}
		if (!StringUtils.isNotBlank(vo.getJixin())) {
			throw new ServiceException("机芯不能为空");
		}
		/*if (!StringUtils.isNotBlank(vo.getKs())) {
			throw new ServiceException("款式不能为空");
		}*/
		/*if (!StringUtils.isNotBlank(vo.getPid())) {
			throw new ServiceException("PID不能为空");
		}*/
		if (vo.getYxqks()==null) {
			throw new ServiceException("有效期开始不能为空");
		}
		if (vo.getYxqjs()==null) {
			throw new ServiceException("有效期结束不能为空");
		}
	
	}
}
