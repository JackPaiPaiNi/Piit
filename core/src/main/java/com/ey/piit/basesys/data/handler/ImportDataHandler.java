package com.ey.piit.basesys.data.handler;

import java.util.List;
import java.util.Map;


/**
 * 导入回调类
 * @author Kevin-Y.Xu
 */
public interface ImportDataHandler<E> {

	/**
	 * 回调函数
	 * 导入预览成功后数据传递给应用，应用负责完成自己的业务逻辑
	 * @param list
	 * @param datas 如果业务发现处理时仍然有部分数据错误，
	 * 		可以将ImportData中isSuccess赋予false，并设置errorMessage错误原因
	 */
	public abstract void handleDatas(final List<E> list, final Map<String, String> params);
}
