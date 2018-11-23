package com.ey.piit.sdo.agent.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.entity.User;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.token.annotation.Token;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.agent.service.AgentService;
import com.ey.piit.sdo.agent.vo.AgentVo;

/**
 * 委托Controller
 * @author 高文浩
 */
@Controller
@RequestMapping(value = "agent/agent")
public class AgentController extends BaseController {

	@Autowired
	private AgentService agentService;
    
	@RequiresPermissions("agent:agent:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/agent/agentList";
	}
	
	@RequiresPermissions("agent:agent:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(AgentVo vo, PageJqGrid page) {
		return agentService.callQueryByPage(vo, page);
    }
	
	@RequiresPermissions("agent:agent:view")
	@RequestMapping(value = {"editPage"})
	@Token(create = true)
	public String editPage(Model model) {
		User user = UserUtils.getUser();
    	model.addAttribute("wtrid", user.getEmpCode());//委托人ID
    	model.addAttribute("wtrmc", user.getUserName());//委托人名称
		return "sdo/agent/agentEdit";
	}
	
	@RequiresPermissions("agent:agent:view")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    @Token(verify = false)
    public Object findById(String id){
    	return agentService.callQueryById(id);
    }
	
    @RequiresPermissions("agent:agent:edit")
    @RequestMapping(value = "submit")
    @ResponseBody
    @Token(verify = true)
    public Object submit(AgentVo vo) {
    	return agentService.submit(vo);
    }
	
	/**
	 * 委托取消
	 * @param vo
	 */
	@RequiresPermissions("agent:agent:edit")
    @RequestMapping(value = "cancel")
    @ResponseBody
    public void cancel(AgentVo vo) {
		agentService.cancel(vo);
    }
}