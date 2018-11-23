package com.ey.piit.basedemo.user.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.ey.piit.basedemo.user.entity.UserDemo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户Entity
 * @author kevin
 */
public class UserDemoVo extends UserDemo {

	private List<UserDemoVo> userList = new ArrayList<UserDemoVo>();
	private Integer pId;
	private String pName;
	private Integer pReturn;
	private String pMsg;
	private String testLength;
	
	private MultipartFile[] files;//上传用
	private List<DemoFileVo> fileList;//展示用
	
	/**
	 * 格式：[{"id":"2","oper":"del"}]
	 */
    private String fileOper;//操作用

	public UserDemoVo() {
		super();
	}

	public UserDemoVo(String id){
		super(id);
	}

	public List<UserDemoVo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDemoVo> userList) {
		this.userList = userList;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getpReturn() {
		return pReturn;
	}

	public void setpReturn(Integer pReturn) {
		this.pReturn = pReturn;
	}

	public String getpMsg() {
		return pMsg;
	}

	public void setpMsg(String pMsg) {
		this.pMsg = pMsg;
	}
	
	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public String getFileOper() {
		return fileOper;
	}

	public void setFileOper(String fileOper) {
		this.fileOper = fileOper;
	}

	public List<DemoFileVo> getFileList() {
		return fileList;
	}

	public void setFileList(List<DemoFileVo> fileList) {
		this.fileList = fileList;
	}

	@Length(min=0, max=5, message="测试长度必须介于 0 和 5 之间")
	public String getTestLength() {
		return testLength;
	}

	public void setTestLength(String testLength) {
		this.testLength = testLength;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

}