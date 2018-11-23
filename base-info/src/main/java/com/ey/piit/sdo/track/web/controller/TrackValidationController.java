package com.ey.piit.sdo.track.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.track.service.TrackValidationService;
import com.ey.piit.sdo.track.vo.TrackSoftwareVo;
import com.ey.piit.sdo.track.vo.TrackValidationVo;

/**
 * 订单生产要求维护Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "track/trackValidation")
public class TrackValidationController extends BaseController {
	
	@Autowired
	private ExcelImporter excelImporter;

	@Autowired
	private TrackValidationService trackValidationService;
	
	@RequiresPermissions("track:trackValidation:view")
	@RequestMapping(value = {"software"})
	public String software() {
		return "sdo/track/softwareList";
	}

    @RequiresPermissions("track:trackValidation:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(@RequestParam(value = "list") String list) {
    	  JSONArray array = JSONArray.fromObject(list);
		  JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd"}));
		  @SuppressWarnings("unchecked")
		  List<TrackValidationVo> voList = (List<TrackValidationVo>) JSONArray.toCollection(array, TrackValidationVo.class);
		  trackValidationService.saveOrUpdateAll(voList);
    }

	/**
	 * 软件确认导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("track:trackValidation:view")
    @RequestMapping(value = "softwareExport")
	public void softwareExport(HttpServletResponse response, @RequestParam Map<String, Object> params,
			@RequestParam(value = "ddList") String ddList) {
		JSONArray array = JSONArray.fromObject(ddList);
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd"}));
		@SuppressWarnings("unchecked")
		List<TrackValidationVo> list = (List<TrackValidationVo>) JSONArray.toCollection(array, TrackValidationVo.class);
		trackValidationService.exportDdxx(response, params, list);
	}
	
	/**
	 * 软件确认导入
	 */
	@RequiresPermissions("track:trackValidation:view")
	@RequestMapping(value = "softwareImport")
	@ResponseBody
	public void softwareImport(MultipartFile file, TrackSoftwareVo vo) {
		List<TrackSoftwareVo> list = excelImporter.importFileReturn(TrackSoftwareVo.class, file, null);
		trackValidationService.saveSoftWareImport(list);
	}
	
	@RequiresPermissions("track:trackValidation:view")
	@RequestMapping(value = {"plainTime"})
	public String plainTime() {
		return "sdo/track/plainTimeList";
	}
	
	/**
	 * 计划完成时间导出
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("track:trackValidation:view")
    @RequestMapping(value = "plainTimeExport")
	public void timeplainExport(HttpServletResponse response, @RequestParam Map<String, Object> params,
			@RequestParam(value = "ddList") String ddList) {
		JSONArray array = JSONArray.fromObject(ddList);
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd"}));
		@SuppressWarnings("unchecked")
		List<TrackValidationVo> list = (List<TrackValidationVo>) JSONArray.toCollection(array, TrackValidationVo.class);
		trackValidationService.exportDdxx(response, params, list);
	}
	
	/**
	 * 生产计划时间确认导入
	 */
	@RequiresPermissions("track:trackValidation:view")
	@RequestMapping(value = "plainTimeImport")
	@ResponseBody
	public void plaintimeImport(MultipartFile file, TrackValidationVo vo) {
		List<TrackValidationVo> list = excelImporter.importFileReturn(TrackValidationVo.class, file, null);
		trackValidationService.savePlainTimeImport(list);
	}
	
}