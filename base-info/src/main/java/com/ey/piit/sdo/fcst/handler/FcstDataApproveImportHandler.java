package com.ey.piit.sdo.fcst.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.sdo.fcst.service.FcstDataService;
import com.ey.piit.sdo.fcst.vo.TmpApproveFcstDataVo;
import com.ey.piit.sdo.fcst.vo.TmpFcstDataVo;

public class FcstDataApproveImportHandler implements ImportDataHandler<TmpApproveFcstDataVo> {
	private FcstDataService fcstDataService = SpringUtils.getBean(FcstDataService.class);
	@Override
	public void handleDatas(List<TmpApproveFcstDataVo> list, Map<String, String> params) {
		fcstDataService.importFcstApproveData(list);
	};
	
	
	@SuppressWarnings("unused")
	private void validate(TmpFcstDataVo vo) {
	}
}
