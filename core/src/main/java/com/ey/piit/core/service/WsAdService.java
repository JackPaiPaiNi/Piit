package com.ey.piit.core.service;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import webservice.HwWsControlServiceStub;

import com.ey.piit.core.entity.AdEntity;

/**
 * 供SDO调用的AD域 服务接口 
 * 用户登录验证密码，创建域账号，禁用域账号，重置域账号密码
 * @author denghai
 *
 */
@Service
public class WsAdService {
	/**
	 * 验证域账号密码
	 * @param frem
	 * @param password
	 * @throws RemoteException
	 */
	public  boolean validateAccount(String frem, String password)
			throws RemoteException {
		boolean result = false;
		try {
			HwWsControlServiceStub stub = new HwWsControlServiceStub();
			// 输入
			HwWsControlServiceStub.ValidateAccountE cp = new HwWsControlServiceStub.ValidateAccountE();
			// 输出
			HwWsControlServiceStub.ValidateAccountResponse out = new HwWsControlServiceStub.ValidateAccountResponse();
			// 输入参数
			HwWsControlServiceStub.ValidateAccount in = new HwWsControlServiceStub.ValidateAccount();
			in.setID(frem);
			in.setPwd(password);
			cp.setValidateAccount(in);
			out = stub.validateAccount(cp).getValidateAccountResponse();
			// 调用
			String out_str = out.get_return();
			if("true".equals(out_str)){
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	/**
	 * 重置密码
	 * 
	 * @param frem
	 * @param password
	 * @throws RemoteException
	 */
	public  String changePwd(String frem, String password)
			throws RemoteException {
		String result="";
		try {
			HwWsControlServiceStub stub = new HwWsControlServiceStub();
			// 输入
			HwWsControlServiceStub.ChangPwdE cp = new HwWsControlServiceStub.ChangPwdE();
			// 输出
			HwWsControlServiceStub.ChangPwdResponse out = new HwWsControlServiceStub.ChangPwdResponse();
			// 输入参数
			HwWsControlServiceStub.ChangPwd in = new HwWsControlServiceStub.ChangPwd();
			in.setID(frem);
			in.setPwd(password);
			cp.setChangPwd(in);
			out = stub.changPwd(cp).getChangPwdResponse();
			// 调用
			result = out.get_return();
			System.out.println("-------------->" + result);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	/**
	 * 添加用户
	 * 
	 * @param args
	 */
	public  String addUser(AdEntity adentity) throws RemoteException {
		String result = "";
		try {
			HwWsControlServiceStub stub = new HwWsControlServiceStub();
			// 输入
			HwWsControlServiceStub.AddUserE cp = new HwWsControlServiceStub.AddUserE();
			// 输出
			HwWsControlServiceStub.AddUserResponse out = new HwWsControlServiceStub.AddUserResponse();
			// 输入参数
			HwWsControlServiceStub.AddUser in = new HwWsControlServiceStub.AddUser();
			HwWsControlServiceStub.AdEntity ad = new HwWsControlServiceStub.AdEntity();
			ad.setCn(adentity.getCn());
			ad.setDepartment(adentity.getDepartment());
			ad.setDisplayname(adentity.getDisplayname());
			ad.setFlag(adentity.getFlag());
			ad.setForgs(adentity.getForgs());
			ad.setFrem(adentity.getFrem());
			ad.setGivenname(adentity.getGivenname());
			ad.setMail(adentity.getMail());
			ad.setMsg(adentity.getMsg());
			ad.setOlddn(adentity.getOlddn());
			ad.setParent(adentity.getParent());
			ad.setPassword(adentity.getPassword());
			ad.setSn(adentity.getSn());
			ad.setUserprincipalname(adentity.getUserprincipalname());
			ad.setExtensionattribute1(adentity.getExtensionattribute1());
            ad.setPwd(adentity.getPwd());
            ad.setAdzh(adentity.getAdzh());
            ad.setDescribe(adentity.getDescribe());
			in.setArg0(ad);
			cp.setAddUser(in);
			out = stub.addUser(cp).getAddUserResponse();

			// 调用
			result = out.get_return();
			System.out.println("-------------->" + result);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	/**
	 * 禁用用户
	 * 
	 * @param args
	 */
	public  String disableUser(String frem) throws RemoteException {
		String result = "";
		try {
			HwWsControlServiceStub stub = new HwWsControlServiceStub();
			// 输入
			HwWsControlServiceStub.DisableUserE cp = new HwWsControlServiceStub.DisableUserE();
			// 输出
			HwWsControlServiceStub.DisableUserResponse out = new HwWsControlServiceStub.DisableUserResponse();
			// 输入参数
			HwWsControlServiceStub.DisableUser in = new HwWsControlServiceStub.DisableUser();
			in.setID(frem);
			cp.setDisableUser(in);
			out = stub.disableUser(cp).getDisableUserResponse();
			// 调用
			result = out.get_return();
			System.out.println("-------------->" + result);
		} catch (Exception e) {
			e.printStackTrace();
		    throw e;
		}
		return result;
	}
	
	/**
	 * 启用用户
	 * 
	 * @param args
	 */
	public  String activeUser(String frem) throws RemoteException {
		String result = "";
		try {
			HwWsControlServiceStub stub = new HwWsControlServiceStub();
			// 输入
			HwWsControlServiceStub.ActiveUserE cp = new HwWsControlServiceStub.ActiveUserE();
			// 输出
			HwWsControlServiceStub.ActiveUserResponse out = new HwWsControlServiceStub.ActiveUserResponse();
			// 输入参数
			HwWsControlServiceStub.ActiveUser in = new HwWsControlServiceStub.ActiveUser();
			in.setID(frem);
			cp.setActiveUser(in);
			out = stub.activeUser(cp).getActiveUserResponse();
			// 调用
			result = out.get_return();
			System.out.println("-------------->" + result);
		} catch (Exception e) {
			e.printStackTrace();
		    throw e;
		}
		return result;
	}
	
	/**
	 * 修改用户
	 * 
	 * @param args
	 */
	public  String modifyUser(AdEntity adentity) throws RemoteException {
		String result = "";
		try {
			HwWsControlServiceStub stub = new HwWsControlServiceStub();
			// 输入
			HwWsControlServiceStub.ModifyUserE cp = new HwWsControlServiceStub.ModifyUserE();
			// 输出
			HwWsControlServiceStub.ModifyUserResponse out = new HwWsControlServiceStub.ModifyUserResponse();
			// 输入参数
			HwWsControlServiceStub.ModifyUser in = new HwWsControlServiceStub.ModifyUser();
			HwWsControlServiceStub.AdEntity ad = new HwWsControlServiceStub.AdEntity();
			ad.setCn(adentity.getCn());
			ad.setDepartment(adentity.getDepartment());
			ad.setDisplayname(adentity.getDisplayname());
			ad.setFlag(adentity.getFlag());
			ad.setForgs(adentity.getForgs());
			ad.setFrem(adentity.getFrem());
			ad.setGivenname(adentity.getGivenname());
			ad.setMail(adentity.getMail());
			ad.setMsg(adentity.getMsg());
			ad.setOlddn(adentity.getOlddn());
			ad.setParent(adentity.getParent());
			ad.setPassword(adentity.getPassword());
			ad.setSn(adentity.getSn());
			ad.setUserprincipalname(adentity.getUserprincipalname());
			ad.setExtensionattribute1(adentity.getExtensionattribute1());
            ad.setPwd(adentity.getPwd());
            ad.setAdzh(adentity.getAdzh());
            ad.setDescribe(adentity.getDescribe());
			in.setArg0(ad);
			cp.setModifyUser(in);
			out = stub.modifyUser(cp).getModifyUserResponse();

			// 调用
			result = out.get_return();
			System.out.println("-------------->" + result);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

}
