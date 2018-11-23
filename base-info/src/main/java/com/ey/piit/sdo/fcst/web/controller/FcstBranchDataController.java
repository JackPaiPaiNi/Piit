package com.ey.piit.sdo.fcst.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstBranchDataService;
import com.ey.piit.sdo.fcst.vo.FcstBranchDataVo;
import com.ey.piit.sdo.fcst.vo.FcstBranchTmpVo;

import net.sf.json.JSONArray;

/**
 * 分公司销售数据填报Controller
 * 
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "fcst/fcstBranchData")
public class FcstBranchDataController extends BaseController {

	@Autowired
	private FcstBranchDataService fcstBranchDataService;

	@Autowired
    private ExcelImporter excelImporter;

	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = { "list", "" })
	@SuppressWarnings("unchecked")
	public String list(Model model) {
		Map<String, Object> map = ((Map<String, Object>) fcstBranchDataService.callQueryTitles());
		model.addAttribute("titles", map.get("hblist"));
		return "sdo/fcst/fcstBranchDataList";
	}

	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = { "pidSelect" })
	public String pidSelect() {
		return "sdo/fcst/pidSelect";
	}
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = { "modelChart" })
	public String modelChart() {
		return "sdo/fcst/fcstBranchModelChart";
	}	
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = { "fcstHistory" })
	public String fcstHistory() {
		return "sdo/fcst/fcstBranchHistory";
	}

	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = { "statictics" })
	public String statictics() {
		return "sdo/fcst/fcstBranchStatistic";
	}
	/**
	 * 分公司销售预测历史
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "searchHistory")
	@ResponseBody
	public Object searchHistory(FcstBranchDataVo vo, PageJqGrid page) {
		return fcstBranchDataService.callQueryHistoryByPage(vo, page);
	}
	/**
	 * 分公司总部分公司型号
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "searchModelChart")
	@ResponseBody
	public Object searchModelChart(FcstBranchDataVo vo, PageJqGrid page) {
		return fcstBranchDataService.callQueryBranchModelByPage(vo, page);
	}
	
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "search")
	@ResponseBody
	public Object search(FcstBranchTmpVo vo, PageJqGrid page) {
		return fcstBranchDataService.callQueryByPage(vo, page);
	}
	
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "searchStatistic")
	@ResponseBody
	public Object searchStatistic(FcstBranchDataVo vo, PageJqGrid page) {
		return fcstBranchDataService.callQueryStatisticByPage(vo, page);
	}
	
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "callQuery")
	@ResponseBody
	public Object callQuery(FcstBranchTmpVo vo, PageJqGrid page) {
		return fcstBranchDataService.callQueryByPage(vo, page);
	}
    @RequiresPermissions("fcst:fcstBranchData:edit")
    @RequestMapping(value = "editModelChart")
    @ResponseBody
    public void editModelChart(FcstBranchDataVo vo) {
    	fcstBranchDataService.editModelChart(vo);
    }
	/**
	 * 查询预测统计报表头
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "searchStatisticTitle")
	@ResponseBody
	public Object searchStatisticTitle(FcstBranchDataVo vo) {
		return fcstBranchDataService.callQueryStatisticTitles(vo);
	}
	/**
	 * 查询预测统计报表头
	 * @param model
	 * @return
	 */
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "searchHtyTitle")
	@ResponseBody
	public Object searchHtyTitle(FcstBranchDataVo vo) {
		return fcstBranchDataService.callQueryHtyTitles(vo);
	}
	/**
	 * 调用存储过程的保存或编辑
	 * 
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "callEdit")
	@ResponseBody
	public void callEdit(@RequestParam(value = "list") String fcstlist) {
		JSONArray array = JSONArray.fromObject(fcstlist);
		@SuppressWarnings("unchecked")
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) JSONArray.toCollection(array, FcstBranchTmpVo.class);
		fcstBranchDataService.callEditList(list);
	}

	/**
	 * 调用存储过程删除
	 * 
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstBranchData:edit")
	@RequestMapping(value = "callDelete")
	@ResponseBody
	public void callDelete(@RequestParam(value = "list") String fcstlist) {
		JSONArray array = JSONArray.fromObject(fcstlist);
		@SuppressWarnings("unchecked")
		List<FcstBranchTmpVo> list = (List<FcstBranchTmpVo>) JSONArray.toCollection(array, FcstBranchTmpVo.class);
		fcstBranchDataService.callDeleteList(list);
	}

	/**
	 * 根据选择的pid信息查询出关联数据
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "queryJoin", method = RequestMethod.POST)
	@ResponseBody
	public Object queryJoin(FcstBranchTmpVo vo, PageJqGrid page) {
		return fcstBranchDataService.callQueryJoin(vo, page);
	}
	/**
	 * @function 导出分公司销售预测
	 * @param HttpServletResponse,Map<String, Object>,FcstBranchTmpVo
	 * @return null
	 * */
	@RequiresPermissions("fcst:fcstBranchData:edit")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstBranchTmpVo vo) {
		fcstBranchDataService.export(response, params, vo);
	}
	/**
	 * @function 导出分公司总部型号对照表
	 * @param HttpServletResponse,Map<String, Object>,FcstBranchTmpVo
	 * @return null
	 * */
	@RequiresPermissions("fcst:fcstBranchData:edit")
    @RequestMapping(value = "exportBranchModel")
	public void exportBranchModel(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstBranchDataVo vo) {
		fcstBranchDataService.exportBranchModel(response, params, vo);
	}	
	/**
	 * @function 导出分公司销售预测历史表
	 * @param HttpServletResponse,Map<String, Object>,FcstBranchTmpVo
	 * @return null
	 * */
	@RequiresPermissions("fcst:fcstBranchData:edit")
    @RequestMapping(value = "exportHistory")
	public void exportHistory(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstBranchDataVo vo) {
		fcstBranchDataService.exportHistory(response, params, vo);
	}
	/**
	 * @function 导出分公司销售预统计分析
	 * @param HttpServletResponse,Map<String, Object>,FcstBranchTmpVo
	 * @return null
	 * */
	@RequiresPermissions("fcst:fcstBranchData:edit")
    @RequestMapping(value = "exportStatistic")
	public void exportStatistic(HttpServletResponse response, @RequestParam Map<String, Object> params, FcstBranchDataVo vo) {
		fcstBranchDataService.exportStatistic(response, params, vo);
	}
	
    /**
     * @function 导入分公司销售预测
     * @param file
     * @return
     */
    @RequiresPermissions("fcst:fcstBranchData:edit")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ResponseBody 
	public void importFile(MultipartFile file){
    	List<FcstBranchTmpVo> list = excelImporter.importFileReturn(FcstBranchTmpVo.class, file, null);   
    	fcstBranchDataService.callEditList(list);
    }
}