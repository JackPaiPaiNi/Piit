package com.ey.piit.sdo.mdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.mdm.repository.AmspryDao;
import com.ey.piit.sdo.mdm.vo.AmspryVo;

/**
 * 澳门审批人员维护Service
 * @author 赵明
 */
@Service
@Transactional
public class AmspryService extends BaseService<AmspryDao, AmspryVo>{
	
	@Autowired
	AmspryDao dao;
	
	@Transactional
	protected int update(AmspryVo amspryVo) {
		//contractVo.setHtbh((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
		int result = super.update(amspryVo);
		result = dao.updateEmploeeName(amspryVo);
		result = dao.updateUserName(amspryVo);
		return result;
	}

}