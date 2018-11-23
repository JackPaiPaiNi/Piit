package com.ey.piit.sdo.price.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.exception.ValidateException;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.sdo.price.service.OrderBomPriceService;
import com.ey.piit.sdo.price.vo.JhdPriceVo;
import com.ey.piit.sdo.price.vo.OrderBomPriceVo;

/**
 * 交货单价格导入
 * 
 * @author 邓海
 *
 */
public class JhdPriceImportHandler implements ImportDataHandler<JhdPriceVo> {

	private OrderBomPriceService orderBomPriceService = SpringUtils.getBean(OrderBomPriceService.class);

	@Override
	public void handleDatas(List<JhdPriceVo> list,Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		List<JhdPriceVo> saveList = new ArrayList<JhdPriceVo>();
		for (int i = 0; i < list.size(); i++) {
			JhdPriceVo record = list.get(i);
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

		orderBomPriceService.saveJhd(saveList);
	}

	private void validate(JhdPriceVo vo) {
		if (StringUtils.isNotBlank(vo.getJhdh()) && "".equals(vo.getJhdh())) {
			throw new ServiceException("交货单号不能为空");
		}

		if (StringUtils.isNotBlank(vo.getDj().toString())
				&& "".equals(vo.getDj().toString().trim())) {
			throw new ServiceException("单价不能为空");
		}
	
	}
}
