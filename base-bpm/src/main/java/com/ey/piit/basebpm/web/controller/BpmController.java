package com.ey.piit.basebpm.web.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.basebpm.entity.TaskBean;
import com.ey.piit.basebpm.service.HistoryQueryService;
import com.ey.piit.basebpm.service.ProcessInstanceService;
import com.ey.piit.basebpm.service.ProcessTaskService;
import com.ey.piit.core.common.Constants;
import com.ey.piit.core.entity.User;
import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;

/**
 * @author Kevin-Y.Xu
 */
@Controller
@RequestMapping("/base/bpm")
public class BpmController extends BaseController{
	
	@Autowired
	private ProcessTaskService processTaskService;
	
	@Autowired
	private HistoryQueryService historyQueryService;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
    @RequestMapping(value = "/taskList", method = RequestMethod.GET)
    public String tasklist(Model model) {
        return "base/bpm/taskList";
    }
    
    @RequestMapping(value = "/historyTaskList", method = RequestMethod.GET)
    public String historyTaskList(Model model) {
        return "base/bpm/historyTaskList";
    }
    
    @RequestMapping(value = "/historyProcessList", method = RequestMethod.GET)
    public String historyProcessList(Model model) {
        return "base/bpm/historyProcessList";
    }
    
    @RequestMapping(value = "/searchTask", method = RequestMethod.POST)
    @ResponseBody
    public Object searchTask(PageJqGrid page, String dh, String ywlx,/* String fqr,*/ String gskh) {
    	User user = findCurUser();
    	List<TaskBean> taskList = processTaskService.findTask(user.getEmpCode(), page, dh, ywlx,/* fqr,*/ gskh);
        return taskList;
    }
    
    @RequestMapping(value = "/searchHistoryProcess", method = RequestMethod.POST)
    @ResponseBody
    public Object searchHistoryProcess(@RequestParam Map<String, String> params, PageJqGrid page) {
    	String userId = null;
    	Subject currentUser = SecurityUtils.getSubject();
    	if (!currentUser.isPermitted("bpm:admin")) {
    		Session session = currentUser.getSession();
        	User user = (User)session.getAttribute(Constants.CURRENT_USER);
        	userId = user.getEmpCode();
		}
    	List<TaskBean> taskList = historyQueryService.findHistoryProcess(userId, params, page);
        return taskList;
    }
    
    @RequestMapping(value = "/findHistoryProcessDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object findHistoryProcessDetail(String processId) {
    	List<TaskBean> taskList = historyQueryService.findHistoryProcessDetail(processId);
    	return taskList;
    }
    
    @RequestMapping(value = "/searchHistoryTask", method = RequestMethod.POST)
    @ResponseBody
    public Object searchHistoryTask(@RequestParam Map<String, String> params, PageJqGrid page) {
    	String userId = null;
    	Subject currentUser = SecurityUtils.getSubject();
    	if (!currentUser.isPermitted("bpm:admin")) {
    		Session session = currentUser.getSession();
        	User user = (User)session.getAttribute(Constants.CURRENT_USER);
        	userId = user.getEmpCode();
		}
    	List<TaskBean> taskList = historyQueryService.findHistoryTask(userId, params, page);
        return taskList;
    }
    
    /**
	 * 查看当前流程图
	 */
	/*public String showBpmImage(){
	}*/
	
	@RequestMapping(value = "/genBpmImage")
	public void genBpmImage(HttpServletRequest request, HttpServletResponse response, String processInstanceId) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = processInstanceService.genBpmImage(processInstanceId);
			out = response.getOutputStream();
			IOUtils.copy(in, out);
		} catch (Exception e) {
			throw new ServiceException(e);
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}
    
}
