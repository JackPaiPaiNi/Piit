package com.ey.piit.sdo.mdm.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.core.entity.BaseEntity.Oper;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.mdm.service.CompanyInfoService;
import com.ey.piit.sdo.mdm.vo.CompanyBankAccountVo;
import com.ey.piit.sdo.mdm.vo.CompanyInfoVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.sf.json.JSONArray;

/**
 * 公司信息维护Controller
 * @author z赵桃军
 */
@Controller
@RequestMapping(value = "mdm/companyInfo")
public class CompanyInfoController extends BaseController {

	@Autowired
	private CompanyInfoService companyInfoService;
	
	@RequiresPermissions("mdm:companyInfo:view")
    @RequestMapping(value = "search")
    @ResponseBody
    public Object search(CompanyInfoVo vo, PageJqGrid page) {
        List<CompanyInfoVo> list = companyInfoService.queryByPage(vo, page);
        return list;
    }
    
    @SuppressWarnings("unchecked")
	@RequiresPermissions("mdm:companyInfo:edit")
    @RequestMapping(value = "edit")
    @ResponseBody
    public void edit(CompanyInfoVo vo,String bankAccountList) {
    	if(bankAccountList!=null &&  bankAccountList.trim().length() !=0){
    	   JSONArray bankAcountArray = JSONArray.fromObject(bankAccountList);
    	   List<CompanyBankAccountVo> bankAcountVoList = (List<CompanyBankAccountVo>) JSONArray.toCollection(bankAcountArray,CompanyBankAccountVo.class); 
           for(CompanyBankAccountVo cbv:bankAcountVoList){
        	   if(cbv.getId().length()<9){
        		   //新增清掉id防止id为jqgrid的id格式
        		   cbv.setId(null);
        	   }
           }
    	   vo.setCompanyBankAccountList(bankAcountVoList); 
    	}
    	if(vo.getOper().equals(Oper.del)){
    		companyInfoService.delete(vo);
    	}else{
    		companyInfoService.saveOrUpdate(vo);
    	}
    }
	
	@RequiresPermissions("mdm:companyInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list() {
		return "sdo/mdm/companyInfoList";
	}
	
	@RequiresPermissions("mdm:companyInfo:view")
    @RequestMapping(value = "export")
	public void export(HttpServletResponse response, @RequestParam Map<String, Object> params, CompanyInfoVo vo) {
		companyInfoService.export(response, params, vo);
	}
	@RequiresPermissions("mdm:companyInfo:view")
	@RequestMapping(value = "editPage")
	public String editPage() {
		return "sdo/mdm/companyInfoEdit";
	}
	
	
	@RequiresPermissions("mdm:companyInfo:view")
	@RequestMapping(value = "findById")
	@ResponseBody
	public Object findById(String id) throws JsonProcessingException {
		 CompanyInfoVo vo = companyInfoService.findById(id);
		 return vo;
	}
	
	/**
	 * 查询受益人信息
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/selectSyr", method = RequestMethod.POST)
    @ResponseBody
    public Object selectSyr(int type){
    	return companyInfoService.callQuerySyr(type);
    }
}