package com.ey.piit.sdo.fcst.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ey.piit.sdo.fcst.repository.FcstNoticeDao;
import com.ey.piit.sdo.fcst.vo.FcstNoticeVo;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.service.BaseService;
import com.ey.piit.core.utils.UserUtils;

/**
 * fcstService
 * @author 赵桃军
 */
@Service
public class FcstNoticeService extends BaseService<FcstNoticeDao, FcstNoticeVo> {
	protected void saveBefore(FcstNoticeVo vo) {
		commBefore(vo);
		
	}
	protected void deleteBefore(FcstNoticeVo vo) {
		commBefore(vo);
	}
	protected void updateBefore(FcstNoticeVo vo) {
		commBefore(vo);
	}
	public void commBefore(FcstNoticeVo vo){
		User user = UserUtils.getUser();
		vo.setZdrid(user.getLoginAcct());
		vo.setZdrmc(user.getUserName());
		vo.setZdsj(new Date());
	}
}