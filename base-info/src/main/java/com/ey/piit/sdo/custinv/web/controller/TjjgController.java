package com.ey.piit.sdo.custinv.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.custinv.service.TjjgService;
import com.ey.piit.sdo.custinv.vo.TjjgVo;


/**
 * 以调价结果表为基础-调价结果表Controller
 * @author 张钧俊
 * @version 1.0
 */
@Controller
@RequestMapping(value="custinv/tjjg")
public class TjjgController extends BaseController {
	@Autowired
	private TjjgService service;
	
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/custinv/tjjgList";
	}
	
	@RequestMapping(value = "search")
    @ResponseBody
    public Object search(TjjgVo vo, PageJqGrid page) {
		return service.callQueryByPage(vo, page);
    }
}
