/*
 * ParaConfigService.java
 * Copyright(C) 2015-2020 EY
 * All rights reserved.
 * -----------------------------------------------
 * 2015-11-24 Created
 */
package com.ey.piit.basesys.para.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.piit.basesys.common.Constants;
import com.ey.piit.basesys.para.repository.ParaConfigDao;
import com.ey.piit.basesys.para.vo.ParaConfigVo;
import com.ey.piit.basesys.utils.ParaConfigUtils;
import com.ey.piit.core.entity.CoreEntity;
import com.ey.piit.core.paginator.domain.PageBounds;
import com.ey.piit.core.repository.ICoreDao;
import com.ey.piit.core.service.CoreService;
import com.ey.piit.core.utils.HttpUtils;

/**
 * T_PARA_CONFIG
 * MDM配置表
 * 
 * @author Kevin Xu
 * @version 1.0 2015-11-24
 */
@Service
public class ParaConfigService extends CoreService {

    @Autowired
    private ParaConfigDao paraConfigDao;
    
    public ParaConfigVo findById(String id) {
        return paraConfigDao.selectById(id);
    }

    public List<ParaConfigVo> queryByPage(Map<String, Object> params, PageBounds page) {
        return paraConfigDao.selectByPage(params, page);
    }

    @Override
    protected ICoreDao getDao() {
        return paraConfigDao;
    }
    
    public ParaConfigVo findByKey(String key){
    	return ParaConfigUtils.findParaConfig(key);
    }
    
    public static void clearCache(){
    	ParaConfigUtils.clearCache();
    }
    
    @Override
	protected void saveAfter(CoreEntity record) {
    	ParaConfigVo paraConfig = findByKey("MAIN_SERVER_ADDRESS");
		String address = paraConfig.getValue();
		
		HttpUtils.postRequest(address+"/base/common/refreshCache", "type="+Constants.CACHE_TYPE_PARA);
	}

	@Override
	protected void updateAfter(CoreEntity record) {
		ParaConfigVo paraConfig = findByKey("MAIN_SERVER_ADDRESS");
		String address = paraConfig.getValue();
		
		HttpUtils.postRequest(address+"/base/common/refreshCache", "type="+Constants.CACHE_TYPE_PARA);
	}

	@Override
	protected void deleteAfter(CoreEntity record) {
		ParaConfigVo paraConfig = findByKey("MAIN_SERVER_ADDRESS");
		String address = paraConfig.getValue();
		
		HttpUtils.postRequest(address+"/base/common/refreshCache", "type="+Constants.CACHE_TYPE_PARA);
	}
}