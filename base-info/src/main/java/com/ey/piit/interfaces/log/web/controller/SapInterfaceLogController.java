package com.ey.piit.interfaces.log.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.interfaces.log.service.SapInterfaceLogService;

/**
 * SAP接口日志Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "log/sapInterfaceLog")
public class SapInterfaceLogController extends BaseController {

	@Autowired
	private SapInterfaceLogService sapInterfaceLogService;
	
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(String id,String fplx) {
    	return sapInterfaceLogService.callQueryLog(id,fplx);
    }

}