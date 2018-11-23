package com.ey.piit.sdo.track.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.core.utils.ExportUtil;
import com.ey.piit.sdo.track.service.TrackDelayService;
import com.ey.piit.sdo.track.vo.TrackDelayVo;
import com.ey.piit.sdo.track.vo.TrackValidationVo;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

/**
 * 订单延误原因维护Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "track/trackDelay")
public class TrackDelayController extends BaseController {

	@Autowired
	private TrackDelayService trackDelayService;
	
	@Autowired
	private ExportUtil exportUtil;
	
	@Autowired
	private ExcelImporter excelImporter;
	
	@RequiresPermissions("track:trackDelay:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/track/trackDelayList";
	}
	
	@RequiresPermissions("track:trackDelay:view")
    @RequestMapping(value = "selectByDdid")
    @ResponseBody
    public Object selectByDdid(String ddid) {
        return trackDelayService.selectByDdid(ddid);
    }
    
	/**
     * 保存延误原因
     * @param vo
     * @return
     */
	@RequiresPermissions("track:trackDelay:view")
    @RequestMapping(value = "saveDelayReasons")
    @ResponseBody
	public Object saveDelayReasons(@RequestParam(value = "reasonList") String reasonList) {
        JSONArray array = JSONArray.fromObject(reasonList);
        @SuppressWarnings("unchecked")
		List<TrackDelayVo> list = (List<TrackDelayVo>) JSONArray.toCollection(array, TrackDelayVo.class);
        return trackDelayService.saveDelayReasons(list);
    }
	
	
	/**
	 * 导出延误信息
	 * @param response
	 * @param params
	 * @param vo
	 */
	@RequiresPermissions("track:trackDelay:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params,
			@RequestParam(value = "list") String list) {
		JSONArray array = JSONArray.fromObject(list);
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(new String[] {"yyyy-MM-dd"}));
		@SuppressWarnings("unchecked")
		List<TrackValidationVo> listEntity = (List<TrackValidationVo>) JSONArray.toCollection(array, TrackDelayVo.class);
		exportUtil.exportSync(response, params, listEntity);
	}
	
	/**
	 * 延误信息导入
	 * @param file
	 * @param vo
	 */
	@RequiresPermissions("track:trackDelay:view")
	@RequestMapping(value = "import")
	@ResponseBody
	public void importCkdFile(MultipartFile file, TrackDelayVo vo) {
		List<TrackDelayVo> list = excelImporter.importFileReturn(TrackDelayVo.class, file, null);
		trackDelayService.saveImport(list);
	}
	
}