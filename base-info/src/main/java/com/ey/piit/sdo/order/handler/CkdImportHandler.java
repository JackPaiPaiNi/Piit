package com.ey.piit.sdo.order.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.order.repository.OrderProductCkdDao;
import com.ey.piit.sdo.order.service.OrderProductService;
import com.ey.piit.sdo.order.vo.OrderProductCkdVo;

/**
 * ckd物料明细导入
 * 
 * @author 赵桃军
 *
 */
public class CkdImportHandler extends OrderProductService implements ImportDataHandler<OrderProductCkdVo> {

	private OrderProductCkdDao orderProductCkdDao = SpringUtils.getBean(OrderProductCkdDao.class);

	@Override
	public void handleDatas(List<OrderProductCkdVo> list, Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		List<OrderProductCkdVo> saveList = new ArrayList<OrderProductCkdVo>();
		for (int i = 0; i < list.size(); i++) {
			OrderProductCkdVo record = list.get(i);
			try {
				validate(record);
				Date now = new Date();
				record.setId(UUID.randomUUID().toString());
				record.setCreateTime(now);
				record.setLastUpdateTime(now);
				saveList.add(record);
			} catch (Exception e) {
				String message = e.getMessage();
				sb.append(i + 2);
				sb.append("行：");
				sb.append(message);
				sb.append("\n");
			}
		}

		if (sb.length() > 0) {
			throw new ValidateException(sb.toString());
		}

		for (OrderProductCkdVo orderProductCkdVo : saveList) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vo", orderProductCkdVo);
			orderProductCkdDao.callInsert(param);
			if (!"SDO-000000".equals(param.get("resultCode").toString())) {
				throw new ServiceException(param.get("resultMsg").toString());
			}
		}
	}

	private void validate(OrderProductCkdVo vo) {
		if (StringUtils.isNotBlank(vo.getDdid()) && "".equals(vo.getDdid().trim())) {
			throw new ServiceException("订单ID不能为空");
		}
		if (StringUtils.isNotBlank(vo.getBbh().toString()) && "".equals(vo.getBbh().toString())) {
			throw new ServiceException("版本号不能为空");
		}
		if (StringUtils.isNotBlank(vo.getPid()) && "".equals(vo.getPid())) {
			throw new ServiceException("PID不能为空");
		}
		if (StringUtils.isNotBlank(vo.getWlbm()) && "".equals(vo.getWlbm().trim())) {
			throw new ServiceException("物料编码不能为空");
		}
		if (StringUtils.isNotBlank(vo.getMs()) && "".equals(vo.getMs().trim())) {
			throw new ServiceException("描述不能为空");
		}
	}
}
