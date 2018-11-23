package com.ey.piit.sdo.track.web.controller;

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
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.track.service.TrackInfoService;
import com.ey.piit.sdo.track.vo.TrackInfoVo;

/**
 * 订单跟踪主表查询Controller
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "track/trackInfo")
public class TrackInfoController extends BaseController {

	@Autowired
	private TrackInfoService trackInfoService;

	@RequiresPermissions("track:trackInfo:view")
	@RequestMapping(value = { "list", "" })
	public String list() {
		return "sdo/track/trackInfoList";
	}
	
	@RequiresPermissions("track:trackInfo:view")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(TrackInfoVo vo, PageJqGrid page) {
		return trackInfoService.callQueryByPage(vo, page);

	}
	
	@RequiresPermissions("track:trackInfo:edit")
	@RequestMapping(value = "edit")
	@ResponseBody
	public void edit(TrackInfoVo vo) {
		trackInfoService.edit(vo);
	}
	
	@RequiresPermissions("track:trackInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, TrackInfoVo vo) {
		trackInfoService.export(response, params, vo);
	}

	/**
	 * 查看整体状态
	 * @param ddid
	 * @return
	 */
	@RequiresPermissions("track:trackInfo:view")
	@RequestMapping(value = "viewZtzt", method = RequestMethod.GET)
    public ModelAndView viewZtzt(String ddid){
		ModelAndView view = new ModelAndView("sdo/track/ztztDh");
    	view.addObject("ztzt", trackInfoService.callSelectZtzt(ddid)); 
    	return view;
    }
	
	/**
	 * 订单详细信息查询
	 * @param ddid
	 * @return
	 */
	@RequiresPermissions("track:trackInfo:view")
	@RequestMapping(value = "viewDdxq", method = RequestMethod.GET)
    public ModelAndView viewDdxq(String ddid){
		ModelAndView view = new ModelAndView("sdo/track/orderInfoView");
    	view.addObject("order", trackInfoService.callQueryDdxq(ddid));
    	return view;
    }
	
	/**
	 * 同步订单状态
	 * @param vo
	 */
	@RequiresPermissions("track:trackInfo:edit")
    @RequestMapping(value = "tbddzt")
    @ResponseBody
    public void tbddzt() {
		trackInfoService.tbddzt();
    }
	
}