package com.ey.piit.sdo.booking.web.controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.booking.service.BookingService;
import com.ey.piit.sdo.booking.vo.BookingItemVo;
import com.ey.piit.sdo.booking.vo.BookingVo;
import com.ey.piit.sdo.order.vo.OrderProductVo;

/**
 * 订舱通知书管理Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "booking/booking")
public class BookingController extends BaseController {

	@Autowired
	private BookingService bookingService;
    
	@RequiresPermissions("booking:booking:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/booking/bookingList";
	}
	
	@RequiresPermissions("booking:booking:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(BookingVo vo, PageJqGrid page) {
		return bookingService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("booking:booking:view")
	@RequestMapping(value = {"editPage"})
	@Token(create = true)
	public String editPage() {
		return "sdo/booking/bookingEdit";
	}
	
	@RequiresPermissions("booking:booking:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return bookingService.callQueryById(id);
    }
	
    @RequiresPermissions("booking:booking:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public Object edit(BookingVo vo, @RequestParam(value = "bookingList")String bookingList) {
    	JSONArray array = JSONArray.fromObject(bookingList);
		@SuppressWarnings("unchecked")
		List<BookingItemVo> list = (List<BookingItemVo>) JSONArray.toCollection(array, BookingItemVo.class);
    	vo.setBookingItemList(list);
    	return bookingService.edit(vo);
    }
    
    @RequiresPermissions("booking:bookingDb:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public Object submit(BookingVo vo, @RequestParam(value = "bookingList")String bookingList) {
    	JSONArray array = JSONArray.fromObject(bookingList);
		@SuppressWarnings("unchecked")
		List<BookingItemVo> list = (List<BookingItemVo>) JSONArray.toCollection(array, BookingItemVo.class);
    	vo.setBookingItemList(list);
    	return bookingService.submit(vo);
    }
    
    @RequiresPermissions("booking:booking:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	bookingService.delete(id,sjc,zt,processId);
    }
    
	@RequiresPermissions("booking:booking:view")
    @RequestMapping(value = "viewPageList", method = RequestMethod.GET)
    public ModelAndView viewPageList(String id){
		ModelAndView view = new ModelAndView("sdo/booking/bookingView");
    	view.addObject("booking",bookingService.callQueryById(id)); 
    	return view;
    }
	
	@RequestMapping(value = "approvePage", method = RequestMethod.GET)
	@Token(create = true)
	public ModelAndView viewApprove(String id) {
		ModelAndView view = new ModelAndView("sdo/booking/bookingApprove");
		view.addObject("BookingVo", bookingService.callQueryById(id));
		return view;
	}
	
	@RequestMapping(value = "approve")
    @ResponseBody
	@Token(verify = true)
    public void approve(BookingVo vo) {
		bookingService.approve(vo);
    }
	
	/**
	 * 订舱取消
	 * @param vo
	 */
	@RequiresPermissions("booking:booking:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(BookingVo vo) {
		bookingService.cancel(vo);
    }
	
	@RequiresPermissions("booking:booking:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(BookingVo vo) {
		bookingService.getback(vo);
    }
}