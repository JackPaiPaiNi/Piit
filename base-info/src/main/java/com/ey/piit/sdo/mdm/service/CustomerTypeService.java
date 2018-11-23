package com.ey.piit.sdo.mdm.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ey.piit.baseinfo.utils.DictUtils;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.mdm.repository.CustomerTypeDao;
import com.ey.piit.sdo.mdm.vo.CustomerTypeVo;

/**
 * 客户分类管理Service
 * @author 魏诚
 */
@Service
public class CustomerTypeService extends BaseService<CustomerTypeDao, CustomerTypeVo> {
	
	@Override
	protected void saveBefore(CustomerTypeVo entity) {
		User user = UserUtils.getUser();
		String khflmc = DictUtils.findDictName(entity.getKhfl(), "KHFL", "");
		entity.setZdrid(user.getLoginAcct());
		entity.setZdrmc(user.getUserName());
		entity.setZdsj(new Date());
		entity.setKhflmc(khflmc);
	}
	
	@Override
	protected void updateBefore(CustomerTypeVo entity) {
		User user = UserUtils.getUser();
		String khflmc = DictUtils.findDictName(entity.getKhfl(), "KHFL", "");
		entity.setZdrid(user.getLoginAcct());
		entity.setZdrmc(user.getUserName());
		entity.setZdsj(new Date());
		entity.setKhflmc(khflmc);
	}
	
}