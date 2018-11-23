package com.ey.piit.basesys.data.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.basesys.data.excel.ExcelImporter;
import com.ey.piit.basesys.data.excel.setting.ExcelSetting;
import com.ey.piit.basesys.data.excel.setting.ExcelSettingHelper;
import com.ey.piit.basesys.data.handler.ImportDataPreviewHandler;
import com.ey.piit.basesys.data.service.ImporterService;
import com.ey.piit.basesys.data.vo.ImportDataVo;
import com.ey.piit.basesys.data.vo.ImportInfoVo;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.web.controller.base.BaseController;

import net.sf.json.JSONObject;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
@Controller
@RequestMapping("/base/importer")
public class ImporterController extends BaseController {

    @Autowired
    private ImporterService importerService;
    
    @Autowired
    private ExcelImporter excelImporter;

    @RequiresPermissions("importer:search")
    @RequestMapping(method = RequestMethod.GET)
    public String listPage() throws Exception{
        return "base/importer/list";
    }
    
    @RequiresPermissions("importer:search")
    @RequestMapping(value = "/redirectList", method = RequestMethod.GET)
    public String redirectListPage(String importId,HttpServletRequest request) throws Exception{
		ImportInfoVo importInfo = importerService.findImportInfoByImportId(importId);
//		ExcelSetting excelSetting = ExcelSettingHelper.parseExcelSetting(importInfo.getExcelConfig());
		ExcelSetting excelSetting = excelImporter.findExcelSetting(Class.forName(importInfo.getClassName()));
		if(excelSetting.isStopOnError()){
			boolean boo = importerService.haveImportErrData(importId);
			if(boo) {
				String stopOnError = "stop";
				request.setAttribute("stopOnError", stopOnError);
			}
		}
		request.setAttribute("excelSetting", excelSetting);
        return "base/importer/redirectList";
    }

    @RequiresPermissions("importer:search")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Object search(@RequestParam Map<String, String> params, PageJqGrid page) {
        List<ImportDataVo> list = importerService.queryImportDataByPage(params, page);
        return list;
    }

    @RequiresPermissions("importer:edit")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
	public String edit(String importId) throws Exception{
		ImportInfoVo importInfo = importerService.findImportInfoByImportId(importId);
//		ExcelSetting excelSetting = ExcelSettingHelper.parseExcelSetting(importInfo.getExcelConfig());
		ExcelSetting excelSetting = excelImporter.findExcelSetting(Class.forName(importInfo.getClassName()));
		
		// 获取handler对象
		ImportDataPreviewHandler<?> handling = (ImportDataPreviewHandler<?>) ExcelSettingHelper.getImportDataHanler(excelSetting.getHandleClass());
		
		List list = importerService.findImportDataList(importId, excelSetting);
		
		Map<String, String> params = null;
		String importParams = importInfo.getImportParams();
		if (StringUtils.isNotEmpty(importParams)) {
			JSONObject json = JSONObject.fromObject(importParams);
			params = (Map<String, String>) JSONObject.toBean(json, Map.class);
		}
		
		handling.handleDatas(list, params);
		
		if (excelSetting.getRedirect())
			return excelSetting.getNextAction();
		else
			return "base/importer/list";
	}
}