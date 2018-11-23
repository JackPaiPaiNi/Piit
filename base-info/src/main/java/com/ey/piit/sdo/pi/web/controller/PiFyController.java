package com.ey.piit.sdo.pi.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.pi.service.PiService;
import com.ey.piit.sdo.pi.vo.PiItemVo;
import com.ey.piit.sdo.pi.vo.PiVo;

/**
 * PI副营业务 管理Controller
 * @author tianrong
 * @version 1.0
 */
@Controller
@RequestMapping(value = "pi/piFy")
public class PiFyController extends BaseController {

	@Autowired
	private PiService piService;
	/**
	 * @function 副营PI查询页面跳转
	 * @param
	 * @return sdo/pi/piDiversityList
	 * */
	@RequiresPermissions("pi:piFy:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/pi/piFyList";
	}
	
	/**
	 * @function 副营PI编辑页面跳转
	 * @param 
	 * @return sdo/pi/piFyEdit
	 * */
    @RequiresPermissions("pi:piFy:view")
    @RequestMapping(value = "editPage", method = RequestMethod.GET)
    @Token (create = true)
    public String editPage(Model model){
    	User user = UserUtils.getUser();
    	model.addAttribute("xsyid", user.getEmpCode());//销售员ID
    	model.addAttribute("xsymc", user.getUserName());//销售员名称
    	model.addAttribute("ywz", user.getGroupCode());//业务组
    	model.addAttribute("ywzmc", user.getGroupName());//业务组名称
    	model.addAttribute("xszz", user.getDeptCode());//销售组织
    	model.addAttribute("xszzmc", user.getDeptName());//销售组织名称
    	return "sdo/pi/piFyEdit";
    }

	/**
	 * @function 副营PI打印页面跳转
	 * @param id
	 * @return ModelAndView
	 * */
	@RequiresPermissions("pi:piFy:view")
    @RequestMapping(value = "print", method = RequestMethod.GET)
    public ModelAndView print(String id){
    	ModelAndView view = new ModelAndView("sdo/pi/piPrint");
    	view.addObject("pi",piService.callQueryPrintById(id)); 
    	return view;
    }
	

	/**
	 * @function 副营PI查看页面跳转
	 * @param id
	 * @return ModelAndView
	 * */
    @RequestMapping(value = "viewPage", method = RequestMethod.GET)
    public ModelAndView viewPage(String id){
		ModelAndView view = new ModelAndView("sdo/pi/piView");
    	view.addObject("pi",piService.callQueryById(id)); 
    	return view;
    }
    /**
	 * @function 副营PI查看页面跳转
	 * @param id
	 * @return ModelAndView
	 * */
    @RequestMapping(value = "viewPageByDh", method = RequestMethod.GET)
    public ModelAndView viewPageByDh(String piid){
		ModelAndView view = new ModelAndView("sdo/pi/piView");
    	view.addObject("pi",piService.callQueryByDh(piid)); 
    	return view;
    }

	/**
	 * @function 副营PI审核页面跳转
	 * @param 
	 * @return sdo/pi/piFyApprove
	 * */
    @RequestMapping(value = "approvePage", method = RequestMethod.GET)
    @Token(create = true)
    public String approvePage(){
    	return "sdo/pi/piFyApprove";
    }
	
	/**
	 * @function 查询副营PI
	 * @param PiVo,PageJqGrid
	 * @return PageList<Object>(list, paginator)
	 * */
	@RequiresPermissions("pi:piFy:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(PiVo vo, PageJqGrid page) {
		return piService.callQueryByPage(vo, page);
    }

	/**
	 * @function 查询副营PI明细
	 * @param id
	 * @return PiVo
	 * */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return piService.callQueryById(id);
    }

	/**
	 * @function 导出副营PI
	 * @param HttpServletResponse,Map<String, Object>,PiVo
	 * @return null
	 * */
	@RequiresPermissions("pi:piFy:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, PiVo vo) {
		piService.export(response, params, vo);
	}
	
	/**
	 * @fu副营PIn 删除副营PI
	 * @param id,sjc
	 * @return null
	 * */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(String id,String sjc,int zt,String processId) {
    	piService.delete(id,sjc,zt,processId);
    }

	/**
	 * @function 保存副营PI
	 * @param PiVo,piList
	 * @return PiVo
	 * */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    @Token(verify = true)
    public Object save(PiVo vo, @RequestParam(value = "piList")String piList) {
    	JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<PiItemVo> list = (List<PiItemVo>) JSONArray.toCollection(array, PiItemVo.class);
    	vo.setPiItemList(list);
    	return piService.edit(vo);
    }

	/**
	 * @function 提交副营PI
	 * @param PiVo,piList
	 * @return null
	 * */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public Object submit(PiVo vo, @RequestParam(value = "piList")String piList) {
    	JSONArray array = JSONArray.fromObject(piList);
		@SuppressWarnings("unchecked")
		List<PiItemVo> list = (List<PiItemVo>) JSONArray.toCollection(array, PiItemVo.class);
    	vo.setPiItemList(list);
    	piService.submit(vo);
    	return  vo;
    }

	/**
	 * @function 副营PI审核
	 * @param PiVo,type,shyj
	 * @return null
	 * */
    @RequestMapping(value = "approve")
    @ResponseBody
    @Token(verify = true)
    public Object approve(PiVo vo) {
    	piService.approve(vo);
    	return vo;
    }
    
    /**
     * @function 副营PI撤回取消（type：1取消 2撤回）
     * @param vo
     */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(PiVo vo, Integer type) {
    	piService.cancel(vo, type);
    }
    
    /**
     * function 副营PI变更
     * @param vo
     */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "change")
    @ResponseBody
    public void change(PiVo vo) {
    	piService.change(vo);
    }
    
    /**
     * function 副营PI变更
     * @param vo
     */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "bfchange")
    @ResponseBody
    public void bfchange(PiVo vo) {
    	piService.bfchange(vo);
    }
    
    /**
     * function 副营PI取回
     * @param vo
     */
    @RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "getback")
    @ResponseBody
    public void getback(PiVo vo) {
    	piService.getback(vo);
    }
    
    /**
     * function 工装PI导入明细
     * @param file
     * @return
     */
	@RequiresPermissions("pi:piFy:edit")
    @RequestMapping(value = "upload")
    @ResponseBody
	public Object importFile(MultipartFile file){
    	return piService.importFile(file);
	}
}