package com.ey.piit.sdo.payment.service;

import org.springframework.stereotype.Service;

import com.ey.piit.core.service.BaseService;
import com.ey.piit.sdo.payment.repository.PayTermDao;
import com.ey.piit.sdo.payment.vo.PayTermVo;

/**
 * 付款条件设置（付款方式）Service
 * @author 田荣
 */
@Service
public class PayTermService extends BaseService<PayTermDao, PayTermVo> {
}