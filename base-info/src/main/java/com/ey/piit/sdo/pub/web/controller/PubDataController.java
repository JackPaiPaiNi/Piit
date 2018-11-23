package com.ey.piit.sdo.pub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.sdo.order.vo.OrderProductVo;
import com.ey.piit.sdo.pub.service.PubDataService;

@Controller
@RequestMapping(value = "pub/data")
public class PubDataController {
	@Autowired
	private PubDataService  pubDataService ;
	
	@RequestMapping(value = "searchDhdd")
	@ResponseBody
	private Object  qryDhdd(OrderProductVo vo,PageJqGrid page){
		return   pubDataService.qryDhdd(vo, page) ;
	}
	
	
	
	
	

}
