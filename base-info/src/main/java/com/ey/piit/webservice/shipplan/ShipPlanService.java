package com.ey.piit.webservice.shipplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.sdo.shipmentplan.repository.ShipmentPlanDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 走货计划查询接口Service
 * 
 * @author 魏诚
 */
@Service("shipPlanService")
public class ShipPlanService {
	
	private ShipmentPlanDao shipmentPlanDao = SpringUtils.getBean(ShipmentPlanDao.class);;

	public Object queryShipPlan(String sjc) throws JsonProcessingException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sjc", sjc);
		shipmentPlanDao.callInterfaceSelect(param);
		@SuppressWarnings("unchecked")
		List<ShipPlanPojo> list = (List<ShipPlanPojo>) param.get("list");
		
		ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
	}

}