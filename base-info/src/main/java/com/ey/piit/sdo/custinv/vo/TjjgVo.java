package com.ey.piit.sdo.custinv.vo;


import java.io.Serializable;

import com.ey.piit.sdo.custinv.entity.TjjgEntity;

/**
 * 以装柜清单为基础-调价结果表Vo
 * @author 张钧俊
 */
public class TjjgVo extends TjjgEntity  implements Serializable{


	private static final long serialVersionUID = -801096237117207621L;
	
	public TjjgVo(){
		super();
	}
	
	public TjjgVo(String id){
		super(id);
	}

}
