package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.exception.ServiceException;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.BankService;
import com.ey.piit.sdo.mdm.vo.BankVo;

/**
 * 银行信息维护Controller
 * @author 赵桃军
 */
@Controller
@RequestMapping(value = "mdm/bank")
public class BankController extends BaseController {

	@Autowired
	private BankService bankService;
	
	@RequiresPermissions("mdm:bank:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(BankVo vo, PageJqGrid page) {
        List<BankVo> list = bankService.queryByPage(vo, page);
        return list;
    }
    
    @RequiresPermissions("mdm:bank:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(BankVo vo) {
    	try {
    		bankService.edit(vo);
    	}catch(Exception e){
    		throw new ServiceException("银行SWIFT代码和是否客户开证行必填，且银行SWIFT代码不能和已存在数据重复");
    	}
    }
	
	@RequiresPermissions("mdm:bank:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/bankList";
	}
	
	@RequiresPermissions("mdm:bank:view")
	@RequestMapping(value = "form")
	public String form(BankVo vo, Model model) {
		BankVo record = bankService.findById(vo.getId());
		model.addAttribute("bank", record == null ? new BankVo() : record);
		return "sdo/mdm/bankForm";
	}
	
	@RequiresPermissions("mdm:bank:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, BankVo vo) {
		bankService.export(response, params, vo);
	}

}