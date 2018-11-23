package com.ey.piit.sdo.fcst.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.ey.piit.core.entity.User;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstDataService;
import com.ey.piit.sdo.fcst.vo.FcstDataVo;
import com.ey.piit.sdo.fcst.vo.TmpApproveFcstDataVo;
import com.ey.piit.sdo.fcst.vo.TmpFcstDataVo;

import net.sf.json.JSONArray;

/**
 * 采购FCST填报Controller
 * @author 赵明
 */
@Controller
@RequestMapping(value = "fcst/fcstData")
public class FcstDataController extends BaseController {

	@Autowired
	private FcstDataService fcstDataService;
	
	@Autowired
    private ExcelImporter excelImporter;
	/**
	 * 填报页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */

	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(TmpFcstDataVo vo, PageJqGrid page) {
        return fcstDataService.callSelectByPage(vo, page);
    }
	/**
	 * 评审页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */

	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "searchApproveFcst")
    @ResponseBody
    public Object searchApproveFcst(TmpFcstDataVo vo, PageJqGrid page) {
        return fcstDataService.callSelectApproveByPage(vo, page);
    }	
	/**
	 * FCST查询页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */

	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "searchFcst")
    @ResponseBody
    public Object searchFcst(TmpFcstDataVo vo, PageJqGrid page) {
        return fcstDataService.callSelectFcstByPage(vo, page);
    }
	
	/**
	 * 移除页面查询方法
	 * @param vo
	 * @param page
	 * @return
	 */
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "query")
    @ResponseBody
    public Object query(FcstDataVo vo, PageJqGrid page) {
        return fcstDataService.callQueryByPage(vo, page);
    }
    
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "searchPid")
    @ResponseBody
    public Object searchPid(String pid, PageJqGrid page) {
        return fcstDataService.searchPid(pid, page);
    }
	
	
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void editFcstData(FcstDataVo vo) {
		 fcstDataService.editFcstData(vo);
    }
    
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "editDzzg")
    @ResponseBody
    public void editDzzg(String zc) {
		 fcstDataService.editDzzg(zc);
    }   
    
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public void delete(@RequestParam(value = "list") String fcstlist) {
		JSONArray array = JSONArray.fromObject(fcstlist);
		@SuppressWarnings("unchecked")
		List<FcstDataVo> list = (List<FcstDataVo>) JSONArray.toCollection(array, FcstDataVo.class);
		 fcstDataService.deletesFcstData(list);
    }
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "remove")
    @ResponseBody
    public void remove(@RequestParam(value = "list") String fcstlist) {
		JSONArray array = JSONArray.fromObject(fcstlist);
		@SuppressWarnings("unchecked")
		List<FcstDataVo> list = (List<FcstDataVo>) JSONArray.toCollection(array, FcstDataVo.class);
		 fcstDataService.removeFcstData(list);
    }   
    /**
     * 
     * @param file
     * @return
     */
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    @ResponseBody 
	public Object importFile(MultipartFile file,String sfzg,String lrfs){
    	Map<String, String> params =new HashMap<String, String>();
    	params.put("sfzg", sfzg);
    	params.put("lrfs", lrfs);
    	excelImporter.importFile(TmpFcstDataVo.class, file, params);
    	@SuppressWarnings("rawtypes")
		List gson=new ArrayList(); 
    	return gson;
	}
    /**
     * 
     * @param file
     * @return
     */
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "importApprove", method = RequestMethod.POST)
    @ResponseBody 
	public Object importApprove(MultipartFile file){
    	Map<String, String> params =new HashMap<String, String>();
    	return excelImporter.importFile(TmpApproveFcstDataVo.class, file, params);   
	}    
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstData:view")
	@RequestMapping(value = {"list", ""})
	public String list(Model model) {
		Map<String, Object> _mapzcnr=((Map<String, Object>)fcstDataService.getFcstDqznr());
		model.addAttribute("zc",_mapzcnr.get("zc"));
		return "sdo/fcst/fcstDataList";
	}
	
	@RequiresPermissions("fcst:fcstData:view")
	@RequestMapping(value = "deletePage")
	public String deletePage() {
		return "sdo/fcst/fcstDataDelete";
	}
	
    @RequiresPermissions("fcst:fcstData:edit")
    @RequestMapping(value = "editFcstApproveData")
    @ResponseBody
    public void editFcstApproveData(TmpApproveFcstDataVo vo) {
	     List<TmpApproveFcstDataVo> list = new ArrayList<TmpApproveFcstDataVo>();
	     list.add(vo);
		 fcstDataService.importFcstApproveData(list);
    }
    
	/**
	 * 常规录入页面
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstData:view")
	@RequestMapping(value = "editPage")
	public String editPage(String zc,Model model) {
		Map<String, Object> _mapzcnr=((Map<String, Object>)fcstDataService.getFcstDqznr());
		Map<String, Object> map=((Map<String, Object>)fcstDataService.callQueryTitles((String)_mapzcnr.get("zc")));
		model.addAttribute("zc",_mapzcnr.get("zc"));
		model.addAttribute("notice",_mapzcnr.get("nr"));
		model.addAttribute("ny",_mapzcnr.get("ny"));
		model.addAttribute("hbtitles",map.get("hblist"));
		return "sdo/fcst/fcstDataEdit";
	}
	/**
	 * 特殊录入页面
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstData:view")
	@RequestMapping(value = "editSpecialPage")
	public String editSpecialPage(Model model) {
		Map<String, Object> _mapzcnr=((Map<String, Object>)fcstDataService.getFcstDqznr());
		Map<String, Object> map=((Map<String, Object>)fcstDataService.callQueryTitles((String)_mapzcnr.get("zc")));
		model.addAttribute("zc",_mapzcnr.get("zc"));
		model.addAttribute("notice",_mapzcnr.get("nr"));
		model.addAttribute("ny",_mapzcnr.get("ny"));
		model.addAttribute("hbtitles",map.get("hblist"));
		return "sdo/fcst/fcstDataSpecialEdit";
	}
	
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstData:view")
	@RequestMapping(value = "approvePage")
	public String approvePage(Model model) {
		Map<String, Object> _mapzcnr=((Map<String, Object>)fcstDataService.getFcstDqznr());
		Map<String, Object> map=((Map<String, Object>)fcstDataService.callQueryApproveTitles((String)_mapzcnr.get("zc")));
		model.addAttribute("hbtitles",map.get("hblist"));
		model.addAttribute("notice",_mapzcnr.get("nr"));
		model.addAttribute("ny",_mapzcnr.get("ny"));
		model.addAttribute("zc",_mapzcnr.get("zc"));
		model.addAttribute("sfps",_mapzcnr.get("sfps"));
		return "sdo/fcst/fcstDataApprove";
	}
	/**
	 * 根据周次获取FCST汇总表头
	 * @param vo
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "findFcstTitles", method = RequestMethod.POST)
    @ResponseBody
    public Object findFcstTitles(String kszc,String jszc) {
		Map<String, Object> map=((Map<String, Object>)fcstDataService.callSelectFcstTitles(kszc,jszc));
		Map<String, Object> titlesMap=new HashMap<String,Object>();
		titlesMap.put("titles", map.get("hblist"));
        return titlesMap;
    }	
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, TmpFcstDataVo vo) {
		User user = UserUtils.getUser();
		vo.setXsyid(user.getLoginAcct());
		fcstDataService.export(response, params, vo);
	}
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "exportApproveFcst")
	public void exportApproveFcst(HttpServletResponse response, @RequestParam Map<String, Object> params, TmpFcstDataVo vo) {
		User user = UserUtils.getUser();
		vo.setXsyid(user.getLoginAcct());
		fcstDataService.exportApproveFcst(response, params, vo);
	}
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "exportFcst")
	public void exportFcst(HttpServletResponse response, @RequestParam Map<String, Object> params, TmpFcstDataVo vo) {
		fcstDataService.exportFcst(response, params, vo);
	}	
	@RequiresPermissions("fcst:fcstData:view")
    @RequestMapping(value = "exportApprove")
	public void exportApprove(HttpServletResponse response, @RequestParam Map<String, Object> params, TmpFcstDataVo vo) {
		User user = UserUtils.getUser();
		vo.setXsyid(user.getLoginAcct());
		fcstDataService.exportApprove(response, params, vo);
	}	
	/**
	 * 同步pid研发bom
	 * @param vo
	 */
	@RequiresPermissions("fcst:fcstData:view")
	@RequestMapping(value = "snycPpxxBom")
	@ResponseBody
	public void snycPpxxBom(String pid) {
		fcstDataService.snycPpxxBom(pid);
	}
}