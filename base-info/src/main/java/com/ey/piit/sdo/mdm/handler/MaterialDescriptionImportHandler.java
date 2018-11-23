package com.ey.piit.sdo.mdm.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.mdm.repository.MaterialDescriptionDao;
import com.ey.piit.sdo.mdm.service.MaterialDescriptionService;
import com.ey.piit.sdo.mdm.vo.MaterialDescriptionVo;

public class MaterialDescriptionImportHandler implements ImportDataHandler<MaterialDescriptionVo> {
	private MaterialDescriptionService materialDescriptionService = SpringUtils.getBean(MaterialDescriptionService.class);
	private MaterialDescriptionDao materialDescriptionDao = SpringUtils.getBean(MaterialDescriptionDao.class);
	@Override
	public void handleDatas(List<MaterialDescriptionVo> list, Map<String, String> params) {
		for(int i=0;i<list.size();i++){
			MaterialDescriptionVo vo=list.get(i);
			int count  = materialDescriptionDao.count(vo);
			if(count > 0){
				materialDescriptionDao.updateByWlbhYy(vo);
			}else{
				vo.setId("");
				vo.setOper(Oper.add);
			}
			this.validate(vo);
			materialDescriptionService.edit(vo);
		}

	};
	
	
	private void validate(MaterialDescriptionVo vo) {
		if (!StringUtils.isNotBlank(vo.getWlbh())) {
			throw new ServiceException("物料编号不能为空");
		}
		if (!StringUtils.isNotBlank(vo.getYy())) {
			throw new ServiceException("语言不能为空");
		}
	    if (!StringUtils.isNotBlank(vo.getMs())) {
			throw new ServiceException("描述不能为空");
		}
	}
}
