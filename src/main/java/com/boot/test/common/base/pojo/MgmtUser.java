/** */
package com.boot.test.common.base.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * @功能:管理员对象
 * @项目名:dunning
 * @作者:wangjz
 * @日期:2017-11-21 18:35:14
 * @说明：<pre></pre>
 */
public class MgmtUser extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 账号 */
	private String account;
	/** 密码 */
	private String password;
	/** 真实姓名 */
	private String userName;
	/** 手机号 */
	private String telNo;
	/** 邮箱 */
	private String email;
	/** 公司id */
	private Long companyId;
	/** 公司name */
	private String companyName;
	/** 部门id */
	private Long departmentId;
	/** 部门name */
	private String departmentName;
	/** 最后登陆时间 */
	private Timestamp lastLoginTime;
	/** 是否可以授权：0否、1是 */
	private Integer accreditable;
	/** 状态：0无效、1正常、2离职 */
	private Integer status;

	/** 程序运行版本，用于清理js、css缓存 */
	private String jsVer;
	/** 用户 角色ids */
	private List<Long> roleIdList;
	/** 用户 登陆token */
	private String loginToken;

	/**
	 * 设置创建人信息
	 * 
	 * @param pojo
	 * @param
	 */
	public void setCreateInfo(BasePojo pojo) {
		pojo.setCreaterId(this.getId());
		pojo.setCreaterName(this.getUserName());
		pojo.setCreateTime(new Timestamp(new Date().getTime()));
	}

	/**
	 * 设置修改人信息
	 * 
	 * @param pojo
	 * @param
	 */
	public void setModifyInfo(BasePojo pojo) {
		pojo.setModId(this.getId());
		pojo.setModName(this.getUserName());
		pojo.setModTime(new Timestamp(new Date().getTime()));
	}

	/** @取得 账号 */
	public String getAccount() {
		return account;
	}

	/** @设置 账号 */
	public void setAccount(String account) {
		this.account = account;
	}

	/** @取得 密码 */
	public String getPassword() {
		return password;
	}

	/** @设置 密码 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** @取得 真实姓名 */
	public String getUserName() {
		return userName;
	}

	/** @设置 真实姓名 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/** @取得 手机号 */
	public String getTelNo() {
		return telNo;
	}

	/** @设置 手机号 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/** @取得 邮箱 */
	public String getEmail() {
		return email;
	}

	/** @设置 邮箱 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** @取得 公司id */
	public Long getCompanyId() {
		return companyId;
	}

	/** @设置 公司id */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/** @取得 公司name */
	public String getCompanyName() {
		return companyName;
	}

	/** @设置 公司name */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/** @取得 部门id */
	public Long getDepartmentId() {
		return departmentId;
	}

	/** @设置 部门id */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/** @取得 部门name */
	public String getDepartmentName() {
		return departmentName;
	}

	/** @设置 部门name */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/** @取得 最后登陆时间 */
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	/** @设置 最后登陆时间 */
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/** @取得 是否可以授权：0否、1是 */
	public Integer getAccreditable() {
		return accreditable;
	}

	/** @设置 是否可以授权：0否、1是 */
	public void setAccreditable(Integer accreditable) {
		this.accreditable = accreditable;
	}

	/** @取得 状态：0无效、1正常、2离职 */
	public Integer getStatus() {
		return status;
	}

	/** @设置 状态：0无效、1正常、2离职 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/** @取得 程序运行版本，用于清理js、css缓存 */
	public String getJsVer() {
		return jsVer;
	}

	/** @设置 程序运行版本，用于清理js、css缓存 */
	public void setJsVer(String jsVer) {
		this.jsVer = jsVer;
	}

	/** @取得 用户角色ids */
	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	/** @设置 用户角色ids */
	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	/** @取得 用户登陆token */
	public String getLoginToken() {
		return loginToken;
	}

	/** @设置 用户登陆token */
	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

}
