package com.ey.piit.sdo.pub.repository;

import com.ey.piit.core.repository.IBaseDao;
import com.ey.piit.core.repository.base.BatisRepository;
import com.ey.piit.sdo.pub.vo.EmailVo;

/**
 * 表名：T_EMAIL_LOG
 * 表描述：邮件发送日志
 * 
 * @author 赵明
 * @version 1.0 2016-12-1
 */
@BatisRepository
public interface EmailDao extends IBaseDao<EmailVo>{
}