package com.ey.piit.sdo.custinv.dao;

import java.util.Map;

import com.ey.piit.core.repository.base.BatisRepository;

@BatisRepository
public interface CustInvDao {

	/**
	 * @param param
	 * @Description: 主页查询发票信息
	 */
	public void callSelects(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 根据ID查询一个发票信息
	 */
	public void callFindById(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 查询发票明细信息
	 */
	public void callFindItems(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 查询装箱单信息
	 */
	public void callFindPackings(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 取消
	 */
	public void callCancel(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 保存发票主信息
	 */
	public void callSaveMain(Map<String, Object> param);

	/**
	 * @param pram
	 * @Description: 保存装箱单信息
	 */
	public void callSaveFindPackings(Map<String, Object> pram);

	/**
	 * @param param
	 * @Description: 保存发票明细
	 */
	public void callSaveItems(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 删除发票信息
	 */
	public void callDelete(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 提交发票
	 */
	public void callSubmit(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 加载可选取物料信息
	 */
	public void callLoadMaterial(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 加载选取后的发票箱单信息
	 */
	public void callLoadCUSTINV(Map<String, Object> param);

	/**
	 * @param param
	 * @Description: 根据出货信息查询发票明细（阿根廷专用）
	 */
	public void callFPMX_BY_CHXX(Map<String, Object> param);

}
