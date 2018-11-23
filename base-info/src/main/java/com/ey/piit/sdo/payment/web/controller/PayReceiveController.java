package com.ey.piit.sdo.payment.web.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.utils.Identities;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.payment.service.PayReceiveService;
import com.ey.piit.sdo.payment.vo.PayReceiveVo;

/**
 * 收款信息登记Controller
 * @author 邓海
 */
@Controller
@RequestMapping(value = "payment/payReceive")
public class PayReceiveController extends BaseController {

	@Autowired
	private PayReceiveService payReceiveService;
	@Autowired
	private ExcelImporter excelImporter;
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("payment:payReceive:view")
    @RequestMapping(value = {"search","approveSearch"})
    @ResponseBody
    public Object search(PayReceiveVo vo, PageJqGrid page) {
        List<PayReceiveVo> list = (List<PayReceiveVo>) payReceiveService.callQueryByPage(vo, page);
        return list;
    }
	
	@RequiresPermissions("payment:payReceive:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token (verify = false)
    public Object findById(String id){
    	return payReceiveService.callQueryById(id);
    }
    
	@RequiresPermissions("payment:payReceive:view")
    @RequestMapping(value = "/changeById", method = RequestMethod.POST)
    @ResponseBody
    @Token (verify = false)
    public Object changeById(String id, String sjc){
    	return payReceiveService.callChangeById(id, sjc);
    }
	
	@RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public Object edit(PayReceiveVo vo) {
		return payReceiveService.edit(vo);
    }
	
    @RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public void submit(PayReceiveVo vo) {
    	payReceiveService.submit(vo);
    }
    
    @RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(PayReceiveVo vo) {
    	payReceiveService.delete(vo);
    }
    
    @RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PayReceiveVo vo) {
    	payReceiveService.cancel(vo);
    }
    
    @RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public void approve(PayReceiveVo vo) {
    	payReceiveService.approve(vo);
    }
    
    /**
	 * 进入查询页面
	 * @return
	 */
	@RequiresPermissions("payment:payReceive:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/payment/payReceiveList";
	}
	
	/**
	 * 进入审核页面
	 * @return
	 */
	@RequiresPermissions("payment:payReceive:view")
	@RequestMapping(value = "approvePage")
	@Token (create = true)
	public String approvePage() {
		return "sdo/payment/payReceiveApprove";
	}
	
	 /**
	 * 进入编辑页面
	 * @return
	 */
	@RequiresPermissions("payment:payReceive:view")
	@RequestMapping(value = "editPage")
	@Token (create = true)
	public String editPage() {
		return "sdo/payment/payReceiveEdit";
	}
	
	@RequiresPermissions("payment:payReceive:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PayReceiveVo vo) {
		payReceiveService.export(response, params, vo);
	}
	
	/**
	 * 收款登记导入 保存
	 * 修改人：赵桃军 2016-9-13
	 * @param file
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceive:edit")
	@RequestMapping(value = "saveList")
	@ResponseBody
	@Token(verify = true)
	public Object saveList(PayReceiveVo vo, @RequestParam(value = "list") String list) {
		JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<PayReceiveVo> voList = (List<PayReceiveVo>) JSONArray.toCollection(array,PayReceiveVo.class);
		vo.setItemList(voList);
		payReceiveService.saveList(vo);
		return vo;
	}
	
	/**
	 * 收款登记导入 提交
	 * 修改人：tianrng 2016-12-7
	 * @param file
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceive:edit")
	@RequestMapping(value = "submitList")
	@ResponseBody
	@Token(verify = true)
	public void submitList(PayReceiveVo vo, @RequestParam(value = "list") String list) {
		JSONArray array = JSONArray.fromObject(list);
		@SuppressWarnings("unchecked")
		List<PayReceiveVo> voList = (List<PayReceiveVo>) JSONArray.toCollection(array,PayReceiveVo.class);
		vo.setItemList(voList);
		payReceiveService.submitList(vo);
	}
	/**
	 * 收款登记导入 得到List填充界面
	 * 修改人：赵桃军 2016-9-13
	 * @param file
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceive:edit")
	@RequestMapping(value = "getList")
	@ResponseBody
	public List<PayReceiveVo>  getImportList(MultipartFile file, PayReceiveVo vo) {
		 List<PayReceiveVo> list =   excelImporter.importFileReturn(PayReceiveVo.class, file, null);
		 for(PayReceiveVo payReceiveVo:list){
			 payReceiveVo.setId(Identities.uuid());
		 }
		 return list ;
	}
	@RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "frozen")
    @ResponseBody
    public void frozen(PayReceiveVo vo) {
		payReceiveService.frozen(vo);
    }
	
	/**
	 * 推送SAP
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceive:edit")
	@RequestMapping(value = "pushSAP")
	@ResponseBody
	public void pushSAP(PayReceiveVo vo) {
		payReceiveService.tsSapAndWriteLog(vo,1);
	}
	
	/**
	 * 调整备注信息
	 * @param vo
	 */
	@RequiresPermissions("payment:payReceive:edit")
    @RequestMapping(value = "modifyBzxx")
    @ResponseBody
    public void modifyBzxx(PayReceiveVo vo) {
		payReceiveService.modifyBzxx(vo);
    }

}