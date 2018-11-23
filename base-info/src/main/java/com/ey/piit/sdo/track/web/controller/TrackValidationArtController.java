package com.ey.piit.sdo.track.web.controller;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.track.service.TrackValidationArtService;
import com.ey.piit.sdo.track.vo.TrackValidationArtVo;

/**
 * 订单生产要求美工信息维护Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "track/trackValidationArt")
public class TrackValidationArtController extends BaseController {

	@Autowired
	private TrackValidationArtService trackValidationArtService;
	
	@RequiresPermissions("track:trackValidationArt:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/track/trackValidationArtList";
	}
	
	/**
	 * 根据id查询美工资料信息
	 * @param vo
	 * @return   
	 */
	@RequiresPermissions("track:trackValidationArt:view")
    @RequestMapping(value = "selectByDdid")
    @ResponseBody
    public Object selectByDdid(String ddid) {
        return trackValidationArtService.selectByDdid(ddid);
    }
	
	/**
     * 保存美工资料确认
     * @param vo
     * @return
     */
	@RequiresPermissions("track:trackValidationArt:view")
    @RequestMapping(value = "saveArtMatel")
    @ResponseBody
	public void saveArtMatel(@RequestParam(value = "artList") String reasonList) {
        JSONArray array = JSONArray.fromObject(reasonList);
        @SuppressWarnings("unchecked")
		List<TrackValidationArtVo> list = (List<TrackValidationArtVo>) JSONArray.toCollection(array, TrackValidationArtVo.class);
        trackValidationArtService.saveArtMatel(list);
    }

}