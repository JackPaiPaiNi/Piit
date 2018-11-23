package com.ey.piit.sdo.booking.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.booking.service.BookingService;
import com.ey.piit.sdo.pso.vo.PsoVo;

/**
 * 订舱通知书待办Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "booking/bookingDb")
public class BookingDbController extends BaseController {

	@Autowired
	private BookingService bookingService;

	@RequiresPermissions("booking:bookingDb:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/booking/bookingDbList";
	}
	
	@RequiresPermissions("booking:bookingDb:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PsoVo vo, PageJqGrid page) {
		return bookingService.callQueryDbByPage(vo, page);
    }

	@RequiresPermissions("booking:bookingDb:view")
	@RequestMapping(value = "/findKtyzh", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findKtyzh(String yzhdh) {
		return bookingService.callQueryKtyzh(yzhdh);
	}
	
	@RequiresPermissions("booking:bookingDb:view")
	@RequestMapping(value = {"editPage"})
	@Token(create = true)
	public String editPage() {
		return "sdo/booking/bookingEdit";
	}
	
	@RequiresPermissions("booking:bookingDb:view")
    @RequestMapping(value = "/findByYzhdhs", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findByYzhdhs(String ids){
    	return bookingService.callQueryByYzhdhs(ids);
    }

}