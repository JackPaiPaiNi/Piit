package com.ey.piit.sdo.payment.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import com.ey.piit.sdo.payment.service.PayReceiveClaimService;
import com.ey.piit.sdo.payment.service.PayReceiveService;
import com.ey.piit.sdo.payment.vo.InvoiceVo;
import com.ey.piit.sdo.payment.vo.PayReceiveClaimVo;
import com.ey.piit.sdo.payment.vo.PayReceiveVo;

import net.sf.json.JSONArray;

/**
 * 收款认领Controller
 * 
 * @author 邓海
 */
@Controller
@RequestMapping(value = "payment/payReceiveClaim")
public class PayReceiveClaimController extends BaseController {

	@Autowired
	private PayReceiveClaimService payReceiveClaimService;
	
	@Autowired
	private PayReceiveService payReceiveService;

	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/payment/payReceiveClaimList";
	}
	
	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = {"search","approveSearch"})
	@ResponseBody
	public Object search(PayReceiveClaimVo vo, PageJqGrid page) {
		return payReceiveClaimService.callQueryByPage(vo, page);
	}
	
	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = {"searchDbd"})
	@ResponseBody
	public Object searchDbd(PayReceiveClaimVo vo, PageJqGrid page) {
		return payReceiveClaimService.callQueryDbd(vo, page);
	}
	
	/**
	 * 进入待办页面
	 * @return
	 */
	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = "todoPage")
	public String todoPage() {
		return "sdo/payment/payReceiveClaimTodo";
	}
	
	/**
	 * 查询待认领收款单
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = {"searchDB"})
	@ResponseBody
	public Object searchDB(PayReceiveVo vo, PageJqGrid page) {
		return payReceiveService.callQueryDrl(vo, page);
	}
	
	/**
	 * 进入编辑页面
	 * 
	 * @return
	 */
	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = "editPage")
	@Token (create = true)
	public ModelAndView editPage(String skdh) {
		ModelAndView view = new ModelAndView("sdo/payment/payReceiveClaimEdit");
		PayReceiveVo vo = (PayReceiveVo) payReceiveService.callQueryByDh(skdh);
		view.addObject("skd", vo);
    	return view;
	}
	
	@RequiresPermissions("payment:payReceiveClaim:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return payReceiveClaimService.callQueryById(id);
    }
	
	@RequiresPermissions("payment:payReceiveClaim:view")
    @RequestMapping(value = "/changeById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object changeById(String id, String sjc){
    	return payReceiveClaimService.callChangeById(id, sjc);
    }
	
	@RequiresPermissions("payment:payReceiveClaim:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	@Token(verify = true)
	public Object edit(PayReceiveClaimVo vo, @RequestParam(value = "list")String list) {
    	JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<PayReceiveClaimVo> voList = (List<PayReceiveClaimVo>) JSONArray.toCollection(array, PayReceiveClaimVo.class);
		vo.setList(voList);
		return payReceiveClaimService.edit(vo);
	}
	
	@RequiresPermissions("payment:payReceiveClaim:edit")
	@RequestMapping(value = "submit")
	@ResponseBody
	@Token(verify = true)
	public void submit(PayReceiveClaimVo vo, @RequestParam(value = "list")String list) {
    	JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<PayReceiveClaimVo> voList = (List<PayReceiveClaimVo>) JSONArray.toCollection(array, PayReceiveClaimVo.class);
		vo.setList(voList);
		payReceiveClaimService.submit(vo);
	}
	
	@RequiresPermissions("payment:payReceiveClaim:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public Object delete(PayReceiveClaimVo vo) {
		return payReceiveClaimService.delete(vo);
	}
	
    @RequiresPermissions("payment:payReceiveClaim:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PayReceiveClaimVo vo) {
    	payReceiveClaimService.cancel(vo);
    }
	
	/**
	 * 进入审核页面
	 * @return
	 */
	@RequiresPermissions("payment:payReceiveClaim:view")
	@RequestMapping(value = "approvePage")
	@Token (create = true)
	public String approvePage() {
		return "sdo/payment/payReceiveClaimApprove";
	}

    @RequiresPermissions("payment:payReceiveClaim:edit")
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public void approve(PayReceiveClaimVo vo) {
    	payReceiveClaimService.approve(vo);
    }
	
	@RequiresPermissions("payment:payReceiveClaim:view")
    @RequestMapping(value ={"export","approveExport"} )
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PayReceiveClaimVo vo) {
		payReceiveClaimService.export(response, params, vo);
	}
	
	/**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceiveClaim:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public void pushSAP(PayReceiveClaimVo vo) {
		payReceiveClaimService.tsSapAndWriteLog(vo);
	}
	
	/**
	 * 预收款转回款
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceiveClaim:edit")
	@RequestMapping(value = "yskzhk")
	@ResponseBody
	public void yskToHk(PayReceiveClaimVo vo) {
		payReceiveClaimService.yskToHk(vo);
	}
	
	/**
	 * 预收款冻结和解冻
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceiveClaim:djAndJd")
	@RequestMapping(value = "yskdjjd")
	@ResponseBody
	public void yskDjAndJd(PayReceiveClaimVo vo) {
		payReceiveClaimService.yskDjAndJd(vo);
	}
	
	
	
	@RequiresPermissions("payment:payReceiveClaim:view")
    @RequestMapping(value = "searchInvoice")
    @ResponseBody
    public Object searchInvoice(InvoiceVo vo, PageJqGrid page) {
        return payReceiveClaimService.callQueryInvoice(vo, page);
    }
}