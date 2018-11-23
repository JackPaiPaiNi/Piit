package com.ey.piit.sdo.deliver.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.ey.piit.sdo.deliver.entity.DeliverDb;
import com.ey.piit.sdo.deliver.service.DeliverService;
import com.ey.piit.sdo.deliver.vo.DeliverItemVo;
import com.ey.piit.sdo.deliver.vo.DeliverSAPVo;
import com.ey.piit.sdo.deliver.vo.DeliverVo;
import com.ey.piit.sdo.pso.vo.PsoOtherVo;

/**
 * 出货通知书管理Controller
 * 
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "deliver/deliver")
public class DeliverController extends BaseController {

	@Autowired
	private DeliverService deliverService;

	// 待办页面
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = { "dbList", "" })
	public String dbList() {
		return "sdo/deliver/deliverDbList";
	}

	// 选预走货页面
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = { "yzhList", "" })
	public String yzhList() {
		return "sdo/deliver/deliverYzhList";
	}

	// 箱单明细页面
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = { "sapDeliverList" })
	public String sapDeliverList() {
		return "sdo/deliver/deliverSAPList";
	}

	// 待办查询
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "dbSearch")
	@ResponseBody
	public Object dbSearch(DeliverDb vo, PageJqGrid page) {
		return deliverService.callDbQueryByPage(vo, page);
	}

	// 待办查询
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "YzhSearch")
	@ResponseBody
	public Object YzhSearch(DeliverDb vo, PageJqGrid page) {
		return deliverService.callYzhQueryByPage(vo, page);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = { "list" })
	public String list() {
		return "sdo/deliver/deliverList";
	}

	/**
	 * 多元化屏出货通知书查询页面
	 * 
	 * @return
	 */
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = { "screenList" })
	public String screenList() {
		return "sdo/deliver/deliverScreenList";
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(DeliverVo vo, PageJqGrid page, @RequestParam(value = "ddh") String ddh,
			@RequestParam(value = "yzhdh") String yzhdh) {
		return deliverService.callQueryByPage(vo, page, ddh, yzhdh);
	}

	/**
	 * 多元化屏出货通知书查询
	 * 
	 * @param vo
	 * @param page
	 * @param ddh
	 * @param yzhdh
	 * @return
	 */
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "screenSearch")
	@ResponseBody
	public Object screenSearch(DeliverVo vo, PageJqGrid page, @RequestParam(value = "ddh") String ddh,
			@RequestParam(value = "yzhdh") String yzhdh) {
		return deliverService.callQueryScreenByPage(vo, page, ddh, yzhdh);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	@Token(create = true)
	public String editPage() {
		return "sdo/deliver/deliverEdit";
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "/findYzh", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findYzh(@RequestParam(value = "yzhdhs") String yzhdhs) {
		return deliverService.callYzhQuery(yzhdhs);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object findById(String id) {
		return deliverService.callQueryById(id);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "/changeById", method = RequestMethod.POST)
	@ResponseBody
	@Token(verify = false)
	public Object changeById(String id, String sjc) {
		return deliverService.callChangeById(id, sjc);
	}

	@RequiresPermissions("deliver:deliver:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	@Token(verify = true)
	public Object edit(DeliverVo vo, @RequestParam(value = "mxList") String mxList,
			@RequestParam(value = "mxOtherList") String mxOtherList) {
		JSONArray array = JSONArray.fromObject(mxList);
		@SuppressWarnings("unchecked")
		List<DeliverItemVo> list = (List<DeliverItemVo>) JSONArray.toCollection(array, DeliverItemVo.class);
		vo.setDeliverItemList(list);

		JSONArray otherArray = JSONArray.fromObject(mxOtherList);
		@SuppressWarnings("unchecked")
		List<PsoOtherVo> otherList = (List<PsoOtherVo>) JSONArray.toCollection(otherArray, PsoOtherVo.class);
		vo.setDeliverOtherList(otherList);

		return deliverService.edit(vo);
	}

	@RequiresPermissions("deliver:deliver:edit")
	@RequestMapping(value = "submit")
	@ResponseBody
	@Token(verify = true)
	public void submit(DeliverVo vo, @RequestParam(value = "mxList") String mxList,
			@RequestParam(value = "mxOtherList") String mxOtherList) {
		JSONArray array = JSONArray.fromObject(mxList);
		@SuppressWarnings("unchecked")
		List<DeliverItemVo> list = (List<DeliverItemVo>) JSONArray.toCollection(array, DeliverItemVo.class);
		vo.setDeliverItemList(list);

		JSONArray otherArray = JSONArray.fromObject(mxOtherList);
		@SuppressWarnings("unchecked")
		List<PsoOtherVo> otherList = (List<PsoOtherVo>) JSONArray.toCollection(otherArray, PsoOtherVo.class);
		vo.setDeliverOtherList(otherList);
		deliverService.submit(vo);
	}

	@RequiresPermissions("deliver:deliver:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public void delete(String id, String sjc) {
		deliverService.delete(id, sjc);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/deliver/deliverView");
		view.addObject("deliver", deliverService.callQueryById(id));
		return view;
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "printPage", method = RequestMethod.GET)
	public ModelAndView printPage(String id, String sfGys) {
		ModelAndView view = null;
		if (!"bgPrint".equals(sfGys)) {
			view = new ModelAndView("sdo/deliver/deliverPrint");
		} else {
			view = new ModelAndView("sdo/deliver/deliverPrint");
		}
		view.addObject("deliver", deliverService.callQueryById(id));
		view.addObject("sfGys", sfGys);
		return view;
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "printBgPage", method = RequestMethod.GET)
	public ModelAndView printBgPage(String id) {
		ModelAndView view = new ModelAndView("sdo/deliver/deliverBgPrint");
		view.addObject("deliver", deliverService.callQueryByPrintBg(id));
		return view;
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, DeliverVo vo) {
		deliverService.export(response, params, vo);
	}

	/**
	 * 多元化屏出货通知书导出
	 * 
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "screenExport")
	public void screenExport(HttpServletResponse response, @RequestParam Map<String, Object> params, DeliverVo vo) {
		deliverService.screenExport(response, params, vo);
	}

	/**
	 * 推送SAP
	 * 
	 * @param vo
	 */
	@RequiresPermissions("deliver:deliver:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public void pushSAP(DeliverVo vo) {
		deliverService.tsSapAndWriteLog(vo);
	}

	/**
	 * 发送邮件
	 * 
	 * @param vo
	 */
	@RequiresPermissions("deliver:deliver:edit")
	@RequestMapping(value = "sendEmail")
	@ResponseBody
	public void sendEmail(String id, String gsbm) {
		deliverService.sendEmail(id, gsbm);
	}

	/**
	 * 出货通知书取消
	 * 
	 * @param vo
	 */
	@RequiresPermissions("deliver:deliver:edit")
	@RequestMapping(value = "cancel")
	@ResponseBody
	public void cancel(DeliverVo vo) {
		deliverService.cancel(vo);
	}

	// SAP箱单明细查询
	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "SAPDeliverSearch")
	@ResponseBody
	public Object SAPDeliverSearch(DeliverSAPVo vo, PageJqGrid page) {
		return deliverService.callSAPDeliverQueryByPage(vo, page);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "SAPDeliverexport")
	public void SAPDeliverexport(HttpServletResponse response, @RequestParam Map<String, Object> params,
			DeliverSAPVo vo) {
		deliverService.SAPDeliverexport(response, params, vo);
	}

	@RequiresPermissions("deliver:deliver:view")
	@RequestMapping(value = "searchChxx")
	@ResponseBody
	public Object searchYzhxx(DeliverVo vo, PageJqGrid page) {
		return deliverService.callQueryChxxByPage(vo, page);
	}
}