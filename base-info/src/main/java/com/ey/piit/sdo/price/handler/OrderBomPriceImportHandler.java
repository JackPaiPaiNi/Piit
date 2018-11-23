package com.ey.piit.sdo.price.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.price.service.OrderBomPriceService;
import com.ey.piit.sdo.price.vo.OrderBomPriceVo;

/**
 * 销单BOM价格导入
 * 
 * @author 邓海
 *
 */
public class OrderBomPriceImportHandler implements ImportDataHandler<OrderBomPriceVo> {

	private OrderBomPriceService orderBomPriceService = SpringUtils.getBean(OrderBomPriceService.class);

	@Override
	public void handleDatas(List<OrderBomPriceVo> list,Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		List<OrderBomPriceVo> saveList = new ArrayList<OrderBomPriceVo>();
		for (int i = 0; i < list.size(); i++) {
			OrderBomPriceVo record = list.get(i);
			try {
				validate(record);
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

	    //验证订单总金额是否小于等于CKD明细金额
		orderBomPriceService.saveCkdSkd(saveList, params.get("drlx"));
	}

	private void validate(OrderBomPriceVo vo) {
		if (StringUtils.isNotBlank(vo.getDdid())
				&& "".equals(vo.getDdid().trim())) {
			throw new ServiceException("订单ID不能为空");
		}
		/*if (StringUtils.isNotBlank(vo.getBbh().toString())
				&& "".equals(vo.getBbh().toString())) {
			throw new ServiceException("版本号不能为空");
		}*/
		if (StringUtils.isNotBlank(vo.getWlbm()) && "".equals(vo.getWlbm())) {
			throw new ServiceException("物料编码不能为空");
		}
		if (StringUtils.isNotBlank(vo.getDj().toString())
				&& "".equals(vo.getDj().toString().trim())) {
			throw new ServiceException("单价不能为空");
		}
		if (StringUtils.isNotBlank(vo.getBz()) && "".equals(vo.getBz().trim())) {
			throw new ServiceException("币种不能为空");
		}
	}
}
