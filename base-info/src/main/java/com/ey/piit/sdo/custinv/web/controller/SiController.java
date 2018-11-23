package com.ey.piit.sdo.custinv.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.custinv.service.SiService;
import com.ey.piit.sdo.custinv.vo.ShippingNoticeVo;
import com.ey.piit.sdo.custinv.vo.SiItemVo;
import com.ey.piit.sdo.custinv.vo.SiVo;

import net.sf.json.JSONArray;

/**
 * @author: junc
 * @date: 2018年6月29日 上午10:21:08
 * @Description: SI Controller类
 */
@Controller
@RequestMapping(value = "custinv/si")
public class SiController extends BaseController {

	@Autowired
	private SiService siService;

	/**
	 * @return: String => 页面路劲
	 * @Description: 初始化加载页面
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/custinv/si/siList";
	}

	/**
	 * @param vo
	 *            =>查询条件
	 * @param page
	 *            =>分页信息
	 * @return: Object 查询结果集
	 * @Description: 主页查询SI单据信息
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(SiVo vo, PageJqGrid page) {
		return siService.findSiList(vo, page);
	}

	/**
	 * @return Object => 查询结果集
	 * @Description: 根据SI编号，查询该SI单信息
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = "findById")
	@ResponseBody
	public Object findById(String id) {
		return siService.findById(id);
	}

	/**
	 * @return Object =>查询结果集
	 * @Description: 根据SI单号，查询SI详情明细
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = "searchSiItem")
	@ResponseBody
	public Object searchSiItem(String siNo) {
		return siService.searchSiItem(siNo);

	}
	
	/**
	 * @return: String => 页面路劲
	 * @Description: 加载编辑页面：新增、修改
	 */
	@RequiresPermissions("custinv:si:edit")
	@RequestMapping(value = "editPage")
	public String editPage() {
		return "sdo/custinv/si/siEdit";
	}

	/**
	 * @return: String =>页面路劲
	 * @Description: 加载出货通知单选取页面
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = { "searhListPage" })
	public String siShippingNoticeSearhList() {
		return "sdo/custinv/si/siShippingNoticeSearhList";
	}

	/**
	 * @return String =>页面路劲
	 * @Description: 加载查看SI单据页面
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = { "viewPage" })
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/custinv/si/siView");
    	view.addObject("si",siService.findById(id)); 
		return view;
	}

	/**
	 * @return Object => 查询出货通知单结果集
	 * @Description: SI拉取 出货通知单信息查询结果集
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = { "searhList" })
	@ResponseBody
	public Object searhList(ShippingNoticeVo vo, PageJqGrid page) {
		return siService.searhList(vo, page);
	}

	/**
	 * @return =>Si单 主详信息
	 * @Description: 根据选择的出货单号，查询SI单所需要的主详信息
	 */
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value = { "searhShippingInfo" })
	@ResponseBody
	public Object searhShippingInfo(String chdNo) {
		return siService.searhShippingInfo(chdNo);
	}
	/**
	 * @RequestParam(value = "qtList")
	 * @return Object =>保存状态
	 * @Description: 保存SI信息到数据库
	 */
	@RequiresPermissions("custinv:si:edit")
	@SuppressWarnings({ "unchecked", "static-access" })
	@RequestMapping(value = "save")
	@ResponseBody
	public Object saveSi(SiVo vo, String mxList) {
		JSONArray array = JSONArray.fromObject(mxList);
		List<SiItemVo> itemList = (List<SiItemVo>) array.toCollection(array, SiItemVo.class);
		vo.setSiItemList(itemList);
		return siService.save(vo);
	}
	@RequiresPermissions("custinv:si:view")
	@RequestMapping(value={"print"})
	public ModelAndView printPage(String id){
		ModelAndView view = new ModelAndView("sdo/custinv/si/siPrint");
    	view.addObject("si",siService.findById(id)); 
    	
		return view;
	}
	/**
	 * @param id =>SI  id
	 * @return 删除结果
	 * @Description:
	 * 		删除SI信息
	 */
	@RequiresPermissions("custinv:si:edit")
	@RequestMapping(value="delete")
	@ResponseBody
	public Object delete(String id,String sjc){
		return siService.delete(id,sjc);
	}
	@RequiresPermissions("custinv:si:edit")
	@RequestMapping(value="submit")
	@ResponseBody
	public Object submit(String id,String sjc){
		return siService.submit(id,sjc);
	}
	/**
	 * 
	 * @param id => si单ID
	 * @param sjc =>SI单时间戳
	 * @return Object 执行取消装填
	 * @Description:
	 * 		取消已生效的单据
	 */
	@RequiresPermissions("custinv:si:edit")
	@RequestMapping(value="cancel")
	@ResponseBody
	public Object cancel(String id,String sjc){
		return siService.cencel(id, sjc);
	}
}
