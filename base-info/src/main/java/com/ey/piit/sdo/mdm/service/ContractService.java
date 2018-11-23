package com.ey.piit.sdo.mdm.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.mdm.repository.ContractDao;
import com.ey.piit.sdo.mdm.vo.ContractVo;

/**
 * 合同信息维护Service
 * @author 高文浩
 */
@Service
public class ContractService extends BaseService<ContractDao, ContractVo> {
	
	@Transactional
	protected int save(ContractVo contractVo) {
		//contractVo.setHtbh((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
		int result = super.save(contractVo);
		return result;
	}
	
	@Transactional
	public int delete(ContractVo contractVo) {
		int result = super.delete(contractVo);
		return result;
	}
}