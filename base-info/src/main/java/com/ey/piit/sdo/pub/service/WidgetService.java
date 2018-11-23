package com.ey.piit.sdo.pub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.core.entity.Organization;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.paginator.domain.PageJqGrid;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;
import com.ey.piit.core.utils.UserUtils;
import com.ey.piit.sdo.agent.vo.AgentVo;
import com.ey.piit.sdo.mdm.entity.MaterialInfo;
import com.ey.piit.sdo.mdm.vo.BankVo;
import com.ey.piit.sdo.mdm.vo.PidInfoVo;
import com.ey.piit.sdo.pub.entity.Mgrwd;
import com.ey.piit.sdo.pub.repository.WidgetDao;
import com.ey.piit.sdo.pub.vo.CustomerInfoVo;

/**
 * PUB管理Service
 * @author 魏诚
 */
@Service
public class WidgetService{

	@Autowired
	private WidgetDao widgetDao;
	
	@SuppressWarnings("unchecked")
	public Object callQueryCust(CustomerInfoVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 当前登陆人
		param.put("userId", UserUtils.getUser().getEmpCode());
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		widgetDao.callSelectCust(param);
		List<CustomerInfoVo> list = (List<CustomerInfoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	@SuppressWarnings("unchecked")
	public Object callQueryCustByXsy(CustomerInfoVo vo, PageBounds page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		// 可控部门
		param.put("bmIds", UserUtils.getOrgCodes());
		// 是否销售员
		param.put("sfXsy", UserUtils.isXys());
		widgetDao.callSelectCustByXsy(param);
		List<CustomerInfoVo> list = (List<CustomerInfoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryBank(BankVo vo, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		widgetDao.callSelectBank(param);
		List<BankVo> list = (List<BankVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryCompanyBank(String gsbm,String yhzh, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("gsbm", gsbm);
		param.put("yhzh", yhzh);
		param.put("page", page);
		widgetDao.callSelectCompanyBank(param);
		List<BankVo> list = (List<BankVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryPid(PidInfoVo vo,PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		widgetDao.callSelectPid(param);
		List<PidInfoVo> list = (List<PidInfoVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMaterial(String wlbh, String wlmc, String bz, String model, PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("bz", bz);
		param.put("wlbh", wlbh);
		param.put("wlmc", wlmc);
		param.put("model", model);
		param.put("page", page);
		widgetDao.callSelectMaterial(param);
		List<MaterialInfo> list = (List<MaterialInfo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 根据客户编码 获取LC信息
	 */
	
	@SuppressWarnings("unchecked")
	public Object callQueryLc(String khbm,String khmc,String lcbh,PageJqGrid page){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("khbm", khbm);
		param.put("khmc", khmc);
		param.put("lcbh", lcbh);
		param.put("page", page);
		widgetDao.callSelectLc(param);
		List<MaterialInfo> list = (List<MaterialInfo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	/**
	 * 根据编码、名称、类型获取销售组织、业务组
	 * @param code
	 * @param name
	 * @param type
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object callQueryOrg(String code, String name, String type, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", code);
		param.put("name", name);
		param.put("type", type);
		param.put("page", page);
		widgetDao.callSelectOrg(param);
		List<Organization> list = (List<Organization>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryBwtrxx(AgentVo vo, PageJqGrid page) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		widgetDao.callSelectBwtrxx(param);
		List<AgentVo> list = (List<AgentVo>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
	
	@SuppressWarnings("unchecked")
	public Object callQueryMgrwd(Mgrwd vo,PageJqGrid page){
		/*if(!"".equals(vo.getMbbsmc())){
			vo.setMbbs("是".equals(vo.getMbbsmc())?1:0);
		}*/
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("vo", vo);
		param.put("page", page);
		widgetDao.callSelectMgrwd(param);
		List<Mgrwd> list = (List<Mgrwd>) param.get("list");
		Paginator paginator = new Paginator(page.getPage(), page.getLimit(), (int) param.get("total"));
    	return new PageList<Object>(list, paginator);
	}
}