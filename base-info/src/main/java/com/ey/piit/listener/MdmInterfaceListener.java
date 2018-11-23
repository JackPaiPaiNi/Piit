package com.ey.piit.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.sdo.mdm.service.PidInfoService;
/**
 * 主数据推送SAP监听
 * @author tianrong
 *
 */
public class MdmInterfaceListener implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {	
		try {
				PidInfoService pidInfoService = SpringUtils.getBean(PidInfoService.class);
				String id =  execution.getVariable("id").toString();
				pidInfoService.tsSap(id);
			} catch (Exception e) {
				e.printStackTrace();
				//throw e;
			}
	}

}