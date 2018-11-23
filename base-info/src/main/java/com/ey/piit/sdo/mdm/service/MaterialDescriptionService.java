package com.ey.piit.sdo.mdm.service;

import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.mdm.repository.MaterialDescriptionDao;
import com.ey.piit.sdo.mdm.vo.MaterialDescriptionVo;

/**
 * 物料其他语言描述Service
 * @author 高文浩
 */
@Service
public class MaterialDescriptionService extends BaseService<MaterialDescriptionDao, MaterialDescriptionVo> {

	public int  edit(MaterialDescriptionVo vo) {
		
		int result = 0 ;
		if(vo.getOper().equals(Oper.del)){
			result = super.edit(vo);
		}else{
			//判断物料编号和语言的组合是否和已有数据重复
			 result = dao.count(vo) ;
			 if(result == 0){
				result = super.edit(vo);
			 }else{
				throw new ServiceException("添加或更新后的物料编号和语言的组合与已经存在的数据重复!");
			 }
		}
		return  result ;
	}
}