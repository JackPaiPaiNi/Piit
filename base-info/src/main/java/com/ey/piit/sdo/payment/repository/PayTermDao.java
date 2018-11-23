package com.ey.piit.sdo.payment.repository;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.payment.vo.PayTermVo;

/**
 * 付款条件设置（付款方式）DAO接口
 * @author 田荣
 */
@BatisRepository
public interface PayTermDao extends IBaseDao<PayTermVo> {
}