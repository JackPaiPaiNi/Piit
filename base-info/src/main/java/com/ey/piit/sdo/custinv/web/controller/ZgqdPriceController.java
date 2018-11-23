package com.ey.piit.sdo.custinv.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.custinv.service.ZgqdPriceService;
import com.ey.piit.sdo.custinv.vo.ZgqdPriceVo;

/**
 * 以装柜清单为基础-调价表Controller
 * @author 魏诚
 * @version 1.0
 */
@Controller
@RequestMapping(value = "custinv/zgqdPrice")
public class ZgqdPriceController extends BaseController {

	@Autowired
	private ZgqdPriceService service;
	

	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/custinv/zgqdPriceList";
	}

    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ZgqdPriceVo vo, PageJqGrid page) {
		return service.callQueryByPage(vo, page);
    }
    
	@RequestMapping(value = "zgqdAdjust1")
	@ResponseBody
	public Object zgqdAdjust1(ZgqdPriceVo vo) {
		return service.zgqdAdjust1(vo);
	}
	
	@RequestMapping(value = "zgqdAdjust2")
	@ResponseBody
	public Object zgqdAdjust2(ZgqdPriceVo vo) {
		return service.zgqdAdjust2(vo);
	}
    
	@RequestMapping(value = "jhdAdjust")
	@ResponseBody
	public Object jhdAdjust(ZgqdPriceVo vo) {
    	return service.jhdAdjust(vo);
	}
    
}