package com.ey.piit.sdo.pub.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ey.piit.baseinfo.utils.DictUtils;
import com.ey.piit.core.service.UserService;
import com.ey.piit.core.web.controller.base.BaseController;
import com.ey.piit.sdo.fcst.service.FcstWeekService;
import com.ey.piit.sdo.fcst.vo.FcstWeekVo;
import com.ey.piit.sdo.mdm.service.CompanyBankAccountService;
import com.ey.piit.sdo.mdm.service.CompanyInfoService;
import com.ey.piit.sdo.mdm.service.ShippingCompanyService;
import com.ey.piit.sdo.mdm.vo.CompanyBankAccountVo;
import com.ey.piit.sdo.mdm.vo.CompanyInfoVo;
import com.ey.piit.sdo.mdm.vo.ShippingCompanyVo;
import com.ey.piit.sdo.payment.service.PayTermService;
import com.ey.piit.sdo.payment.vo.PayTermVo;
import com.ey.piit.sdo.pub.service.Select2Service;

/**
 * Select2 Controller
 * @author 魏诚
 */
@Controller
@RequestMapping(value = "pub/select2")
public class Select2Controller extends BaseController {
	
	@Autowired
	private Select2Service select2Service;

	@Autowired
	private CompanyBankAccountService CompanyankAccountService;
	
	@Autowired
	private PayTermService payTermService;
	
	@Autowired
	private CompanyInfoService companyInfoService;
	
	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	@Autowired
	private FcstWeekService fcstWeekService;
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/companyBank", method = RequestMethod.POST)
    @ResponseBody
    public Object selectCompanyBank(CompanyBankAccountVo vo){
    	@SuppressWarnings("rawtypes")
		List list =  CompanyankAccountService.queryCompanyBacnk(vo);
    	return  list ;
    }
    @RequestMapping(value = "/companyBankAcconut", method = RequestMethod.POST)
    @ResponseBody
    public Object selectCompanyBankAcconut(CompanyBankAccountVo vo){
    	return CompanyankAccountService.queryByParam(vo);
    }
    
    @RequestMapping(value = "/selectPayTerm", method = RequestMethod.POST)
    @ResponseBody
    public Object selectPayTerm(){
    	PayTermVo vo = new PayTermVo();
    	// 只取有效的付款条件
    	vo.setZt(1);
    	return payTermService.queryByParam(vo);
    }
    
    @RequestMapping(value = "/selectLcPayTerm", method = RequestMethod.POST)
    @ResponseBody
    public Object selectLcPayTerm(){
    	PayTermVo vo = new PayTermVo();
    	vo.setXdLc(0.01);
    	return payTermService.queryByParam(vo);
    }
    
    @RequestMapping(value = "/companyInfos", method = RequestMethod.POST)
    @ResponseBody
    public Object selectCompanyInfos(){
    	return companyInfoService.queryByParam(new CompanyInfoVo());
    }
    
    @RequestMapping(value = "/shippingCompany", method = RequestMethod.POST)
    @ResponseBody
    public Object selectShippingCompany(){
    	return shippingCompanyService.queryByParam(new ShippingCompanyVo());
    }
    
    @RequestMapping(value = "/selectFcstWeek", method = RequestMethod.POST)
    @ResponseBody
    public Object selectFcstWeek(){
    	return fcstWeekService.queryByParam(new FcstWeekVo());
    }
    
    @RequestMapping(value = "/selectUserByRole", method = RequestMethod.POST)
    @ResponseBody
    public Object findGcs(String roleCode){
    	return userService.queryByRoleCode(roleCode);
    }
    
    @RequestMapping(value = "/selectCountry", method = RequestMethod.POST)
    @ResponseBody
    public Object selectCountry(){
    	return select2Service.callQueryCountry();
    }
    /**
     * pid申请查询设计师
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "/selectSjsByRole", method = RequestMethod.POST)
    @ResponseBody
    public Object selectSjs(String roleCode){
    	return select2Service.callQuerySjsByRole(roleCode);
    }
    
    /**
     * 加工方式查询
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "/selectJgfs", method = RequestMethod.POST)
    @ResponseBody
    public Object selectJgfs(String zhfs){
    	return select2Service.callQueryJgfs(zhfs);
    }
    
    /**
     * 查询数据字典
     * 
     * */
    @RequestMapping(value = "/dict", method = RequestMethod.POST)
    @ResponseBody
    public Object selectDict(String type){
    	return DictUtils.queryByType(type);
    }
    
    /**
     * 收货方代码查询
     * @param xwgj
     * @return
     */
    @RequestMapping(value = "/selectShfdm", method = RequestMethod.POST)
    @ResponseBody
    public Object selectShfdm(String xwgj){
    	return select2Service.callQueryShfdm(xwgj);
    }
}