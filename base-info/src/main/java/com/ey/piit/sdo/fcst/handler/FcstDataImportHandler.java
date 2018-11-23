package com.ey.piit.sdo.fcst.handler;

import java.util.List;
import java.util.Map;

import com.ey.piit.basesys.data.handler.ImportDataHandler;
import com.ey.piit.core.spring.SpringUtils;
import com.ey.piit.sdo.fcst.service.FcstDataService;
import com.ey.piit.sdo.fcst.vo.TmpFcstDataVo;

public class FcstDataImportHandler implements ImportDataHandler<TmpFcstDataVo> {
	private FcstDataService fcstDataService = SpringUtils.getBean(FcstDataService.class);
	@Override
	public void handleDatas(List<TmpFcstDataVo> list, Map<String, String> params) {
		fcstDataService.importFcstData(list,Integer.parseInt(params.get("sfzg")),params.get("lrfs"));
	};
	
	
	@SuppressWarnings("unused")
	private void validate(TmpFcstDataVo vo) {
	}
}
