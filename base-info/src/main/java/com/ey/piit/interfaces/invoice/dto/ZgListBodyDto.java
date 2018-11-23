package com.ey.piit.interfaces.invoice.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
装柜清单查询接口
 * @author tianrong
 *
 */
@XStreamAlias("ROW")
public class ZgListBodyDto {
	@XStreamAlias("CHDNO")
	private String chdno= "";//出货单号

	public String getChdno() {
		return chdno;
	}

	public void setChdno(String chdno) {
		this.chdno = chdno;
	}
	
	
}
