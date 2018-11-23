package com.ey.piit.sdo.invoice.web.controller;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.report.service.ReportService;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.invoice.service.ZgListService;
import com.ey.piit.sdo.invoice.vo.ZgListVo;

/**
 * 装柜清单Controller
 * @author tianrong
 */
@Controller
@RequestMapping(value = "invoice/zglist")
public class ZgListController extends BaseController {

	@Autowired
	private ZgListService zgListService;
	
	@Autowired
	private ReportService reportService;
	
    /**
     * 发票主页
     * @return
     */
	@RequiresPermissions("invoice:zglist:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/invoice/sapZgList";
	}
	
	/**
     * 发票查询
     * @param vo
     * @param page
     * @return
     */
	@RequiresPermissions("invoice:zglist:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(ZgListVo vo, PageJqGrid page) {
        return zgListService.callQueryByPage(vo, page);
    }

    /**
	 * @function 导出
	 * @param HttpServletResponse,Map<String, Object>,ZgListVo
	 * @return null
	 * */
	@RequiresPermissions("invoice:zglist:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, ZgListVo vo) {
		zgListService.export(response, params, vo);
	}
}