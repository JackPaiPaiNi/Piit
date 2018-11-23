package com.ey.piit.interfaces.payment.dto;

import com.ey.piit.interfaces.base.entity.BaseResponse;

/**
 * SAP返回收款认领报文
 * @author tianrong
 *
 */

public class PayReceiveClaimMsgResponse  extends BaseResponse{

	private String skdh;//收款单号


	public String getSkdh() {
		return skdh;
	}
	public void setSkdh(String skdh) {
		this.skdh = skdh;
	}
}
