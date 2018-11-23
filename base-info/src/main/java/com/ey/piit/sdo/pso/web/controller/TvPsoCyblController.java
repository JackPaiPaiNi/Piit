package com.ey.piit.sdo.pso.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.pso.service.PsoService;
import com.ey.piit.sdo.pso.vo.PsoVo;
/**
 * TV预走货储运补录TvPsoCyblController
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "pso/tvPsoCybl")
public class TvPsoCyblController extends BaseController {

	@Autowired
	private PsoService psoService;
	
	/**
	 * 储运补录菜单
	 * @return
	 */
	@RequiresPermissions("pso:tvPsoCybl:view")
	@RequestMapping(value = { "list", "" })
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("sdo/pso/psoTvCyblList");
		return view;
	}
	
	/**
	 * 储运补录查询
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("pso:tvPsoCybl:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(PsoVo vo, PageJqGrid page) {
		return psoService.callQueryCyblByPage(vo, page);
	}
	
	/**
	 * 储运补录编辑页面
	 * @return
	 */
	@RequiresPermissions("pso:tvPsoCybl:edit")
	@RequestMapping(value = "editPage", method = RequestMethod.GET)
	public ModelAndView editPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoTvCyblEdit");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}
	
	/**
	 * 储运补录查看
	 * @return
	 */
	@RequiresPermissions("pso:tvPsoCybl:view")
	@RequestMapping(value = "viewPage", method = RequestMethod.GET)
	public ModelAndView viewPage(String id) {
		ModelAndView view = new ModelAndView("sdo/pso/psoTvCyblView");
		view.addObject("PsoVo", psoService.callQueryById(id));
		return view;
	}

	/**
	 * 储运补录保存
	 * @param id
	 * @return
	 */
	@RequiresPermissions("pso:tvPsoCybl:view")
    @RequestMapping(value = "submit")
    @ResponseBody
	public void submit(PsoVo vo) {
		psoService.callCyblSave(vo);
	}
	

}