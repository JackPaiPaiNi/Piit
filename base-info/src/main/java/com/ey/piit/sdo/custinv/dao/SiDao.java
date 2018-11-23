package com.ey.piit.sdo.custinv.dao;

import java.util.Map;
import com.ey.piit.core.repository.base.BatisRepository;

/**
 * @author: junc
 * @date: 2018年6月29日 上午8:55:53
 * @Description: SI DAO类
 */
@BatisRepository
public interface SiDao {
	/**
	 * @param: param
	 * @return: void
	 * @Description: 根据条件查询SI记录集合
	 */
	public void callSelects(Map<String, Object> param);

	/**
	 * @param: param
	 * @return: void
	 * @Description: 根据编号查询一条SI的详细记录集合
	 */
	public void callSelectItems(Map<String, Object> param);

	/**
	 * @param: param
	 * @return: void
	 * @Description: 根据编号查询一条SI记录
	 */
	public void callSelectById(Map<String, Object> param);

	/**
	 * @param param
	 * @return: void
	 * @Description: 保存SI记录
	 */
	public void callSave(Map<String, Object> param);

	/**
	 * @param param
	 *            =>保存对象
	 * @Description: 保存SI详情明细记录
	 */
	public void callSaveITEM(Map<String, Object> param);

	/**
	 * @param param
	 * @return: void
	 * @Description: 删除SI记录
	 */
	public void callDelete(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 取消SI单
	 */
	public void callCancel(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 提交SI单
	 */
	public void callSubmit(Map<String, Object> param);

	/**
	 * @param param
	 * @return void
	 * @Description: 查询SI中 抓取出货通知单信息
	 */
	public void callSelectList(Map<String, Object> param);

	/**
	 * @param param
	 * @return void
	 * @Description: 根据选择的出货单号，查询SI单所需要的主详信息
	 */
	public void callShippingInfo(Map<String, Object> param);

	/**
	 * @param param
	 *            => SI单信息
	 * @Description: 提交SI单
	 */
	public void callSubmitSI(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 取自动生成SI单号
	 */
	public String callGetSiNo();

}
