package com.ey.piit.sdo.custinv.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.sdo.custinv.service.CustInvService;
import com.ey.piit.sdo.custinv.vo.CustInvItemVo;
import com.ey.piit.sdo.custinv.vo.CustInvPackingVo;
import com.ey.piit.sdo.custinv.vo.CustInvVo;
import com.ey.piit.sdo.custinv.vo.LoadMaterialVo;

import net.sf.json.JSONArray;

/**
 * @author: junc
 * @date: 2018年7月5日 上午10:18:35
 * @Description:
 */
@Controller
@RequestMapping(value = "custinv/custinv")
public class CustInvController {

	@Autowired
	private CustInvService service;

	/**
	 * @return =>页面路劲
	 * @Description: 打开主页
	 */
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = { "list", "" })
	public String indexPage() {
		return "sdo/custinv/invoice/invoiceNewList";
	}

	/**
	 * @return String =>页面路劲
	 * @Description: 新增、修改页面加载
	 */
	@RequiresPermissions("custinv:custinv:edit")
	@RequestMapping(value = { "editPage" })
	public String editPage() {
		return "sdo/custinv/invoice/invoiceNewEdit";
	}

	/**
	 * @return String =>页面路劲
	 * @Description: 数据抓取页面加载
	 */
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = { "loadingCabinetList" })
	public String loadingCabinetListPage() {
		return "sdo/custinv/invoice/loadingCabinetList";
	}

	/**
	 * @return String =>页面路劲
	 * @Description: 查看页面加载
	 */
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = { "viewPage" })
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/custinv/invoice/invoiceNewView");
		view.addObject("invoice", service.findById(id,0));
		return view;

	}

	/**
	 * @return Object =>查询结果集
	 * @Description:主页数据查询
	 */
	@RequiresPermissions("custinv:custinv:view")
	@ResponseBody
	@RequestMapping(value = { "search" })
	public Object search(CustInvVo vo, PageJqGrid page) {
		return service.search(vo, page);
	}

	/**
	 * @param vo
	 *            =>发票主信息
	 * @param itemListStr
	 *            =>发票详细信息
	 * @param packingListStr
	 *            =>装箱单信息
	 * @return Object=>执行保存结果
	 * @Description: 保存
	 */
	@RequiresPermissions("custinv:custinv:edit")
	@SuppressWarnings({ "unchecked", "static-access" })
	@RequestMapping(value = "save")
	@ResponseBody
	public Object save(CustInvVo vo, String itemListStr, String packingListStr) {
		JSONArray itemArray = JSONArray.fromObject(itemListStr);
		List<CustInvItemVo> itemList = (List<CustInvItemVo>) itemArray.toCollection(itemArray, CustInvItemVo.class);
		JSONArray packingArray = JSONArray.fromObject(packingListStr);
		List<CustInvPackingVo> packingList = (List<CustInvPackingVo>) itemArray.toCollection(packingArray,
				CustInvPackingVo.class);
		vo.setCustInvItems(itemList);
		vo.setCustInvPackings(packingList);
		return service.save(vo);
	}

	/**
	 * @param id
	 *            =>发票箱单ID
	 * @param sjc
	 *            =>发票箱单时间戳
	 * @return Object =>执行删除结果
	 * @Description: 删除发票箱单信息
	 */
	@RequiresPermissions("custinv:custinv:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public Object delete(String id, String sjc) {
		return service.delete(id, sjc);
	}

	/**
	 * @param id
	 *            =>发票箱单Id
	 * @param sjc
	 *            =>发票箱单时间戳
	 * @return Object =>执行取消结果
	 * @Description: 取消已生效的发票箱单
	 */
	@RequiresPermissions("custinv:custinv:edit")
	@RequestMapping(value = "cancel")
	@ResponseBody
	public Object cancel(String id, String sjc) {
		return service.cancel(id, sjc);
	}

	/**
	 * @param id
	 *            =>发票箱单ID
	 * @param sjc
	 *            =>发票箱单时间戳
	 * @return Object =>执行提交结果
	 * @Description: 提交发票箱单
	 */
	@RequiresPermissions("custinv:custinv:edit")
	@RequestMapping(value = "submit")
	@ResponseBody
	public Object submit(String id, String sjc) {
		return service.submit(id, sjc);
	}

	/**
	 * @param id
	 *            =>发票箱单ID
	 * @return Object =>查询结果集
	 * @Description: 根据ID查询发票箱单信息
	 */
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = { "findById" })
	@ResponseBody
	public Object findById(String id) {
		return service.findById(id,1);
	}

	@RequiresPermissions("custinv:custinv:view")
	@ResponseBody
	@RequestMapping(value = { "searchCabinet" })
	public Object searchCabinet(LoadMaterialVo vo, PageJqGrid page) {
		return service.callLoadMaterial(vo, page);
	}

	/**
	 * @param p_chdh
	 *            =>出货单号
	 * @param p_ddid
	 *            =>订单编号
	 * @return Custinv =>发票箱单主信息
	 * @Description: 选取物料信息后加载发票箱单主信息
	 */
	@ResponseBody
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = { "searchCustinv" })
	public Object searchCustinv(String p_chdh, String p_ddid, String p_chxx) {
		return service.callLoadCUSTINV(p_chdh, p_ddid, p_chxx);
	}

	/**
	 * 
	 * @param id
	 *            =>打印的发票箱单数据ID
	 * @param packingType
	 *            => 箱单模板 1:SKD PACKING LIST 
	 *               2:巴西PACKING LIST 
	 *               3:CBU PACKING LIST
	 *            	 4：阿根廷PACKING LIST
	 * @return
	 * @Description: Info
	 */
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = "printPacking")
	public ModelAndView printPacking(String id, String packingType) {
		if (StringUtils.isEmpty(packingType)) {
			return null;
		}
		String url = "";
		switch (packingType) {
		case "1":
			url = "sdo/custinv/invoice/invoicePrintSKDPacking";
			break;
		case "2":
			url = "sdo/custinv/invoice/invoicePrintBrazilPacking";
			break;
		case "3":
			url = "sdo/custinv/invoice/invoicePrintCBUPacking";
			break;
		case "4":
			url = "sdo/custinv/invoice/invoicePrintArgentinaPacking";
			break;
		default:
			break;
		}
		ModelAndView view = new ModelAndView(url);
		view.addObject("invoice", service.findById(id,0));
		return view;
	}

	/**
	 * @param id
	 *            =>打印发票箱单数据的ID
	 * @param fpmb
	 *            => 发票模板 1:欧洲模板 2:巴西模板 3:阿根廷模板
	 * @return
	 * @Description: 发票打印页面
	 */
	@RequiresPermissions("custinv:custinv:view")
	@RequestMapping(value = { "printPage" })
	public ModelAndView printPage(String id, String fpmb) {
		if (StringUtils.isEmpty(fpmb)) {
			return null;
		}
		String url = "";
		switch (fpmb) {
		case "1":
			url = "sdo/custinv/invoice/invoicePrintEurope";
			break;
		case "2":
			url = "sdo/custinv/invoice/invoicePrintBrazil";
			break;
		case "3":
			url = "sdo/custinv/invoice/invoicePrintArgentina";
			break;
		default:
			break;
		}
		ModelAndView view = new ModelAndView(url);
		view.addObject("invoice", service.findById(id,0));
		return view;

	}
	
	/**
	 * 发票信息导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequestMapping(value = "exportInvoice")
	public void exportInvoice(HttpServletResponse response, String id, @RequestParam Map<String, Object> params) {
		service.export(id,params,response);
	}

}
