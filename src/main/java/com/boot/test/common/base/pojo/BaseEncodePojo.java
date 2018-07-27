/** */
package com.boot.test.common.base.pojo;

import com.boot.test.common.util.encode.Encode;
import org.springframework.util.StringUtils;



/**
 * @功能:数据脱敏基础类
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月3日上午10:49:01 @说明：
 * 
 *                         <pre></pre>
 */
public class BaseEncodePojo extends BasePojo {
	/** */
	private static final long serialVersionUID = 1L;
	/** 手机号码（未加密） */
	private String tel;
	/** 手机号码（已加密） */
	private String telEnc;
	/** 手机号码（未加密） */
	private String custTelNo;
	/** 手机号码（已加密） */
	private String custTelNoEnc;

	/** 邮箱（未加密） */
	private String email;
	/** 邮箱（已加密） */
	private String emailEnc;

	/** 银行卡号码（未加密） */
	private String bankCardCode;
	/** 银行卡号码（已加密） */
	private String bankCardCodeEnc;

	/** 银行卡绑定的手机号（未加密） */
	private String bankCardTel;
	/** 银行卡绑定的手机号（已加密） */
	private String bankCardTelEnc;

	/** 身份证编号（未加密） */
	private String idCardCode;
	/** 身份证编号（已加密） */
	private String idCardCodeEnc;

	/** 身份证姓名（未加密） */
	private String idCardName;
	/** 身份证姓名（已加密） */
	private String idCardNameEnc;

	/** 贷款人手机号（未加密） */
	private String brwTel;
	/** 贷款人手机号（已加密） */
	private String brwTelEnc;

	/** 贷款人身份证号码（未加密） */
	private String brwIdCardCode;
	/** 贷款人身份证号码（已加密） */
	private String brwIdCardCodeEnc;

	/** 贷款人姓名（未加密） */
	private String brwIdCardName;
	/** 贷款人姓名（已加密） */
	private String brwIdCardNameEnc;

	/** 中介手机号（未加密） */
	private String agentTel;
	/** 中介手机号（已加密） */
	private String agentTelEnc;

	/** 中介身份证号码（未加密） */
	private String agentIdCardCode;
	/** 中介身份证号码（已加密） */
	private String agentIdCardCodeEnc;

	/** 中介姓名（未加密） */
	private String agentIdCardName;
	/** 中介姓名（已加密） */
	private String agentIdCardNameEnc;

	/** 信贷经理手机号（未加密） */
	private String loanManagerTel;
	/** 信贷经理手机号（已加密） */
	private String loanManagerTelEnc;

	/**
	 * @取得 手机号码（未加密）
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @设置 手机号码（未加密）
	 */
	public void setTel(String tel) {
		this.tel = tel;
		this.telEnc = Encode.encodeTelNo(tel);
	}
	
	/**
	 * @取得 手机号码（未加密）
	 */
	public String getCustTelNo() {
		return custTelNo;
	}

	/**
	 * @设置 手机号码（未加密）
	 */
	public void setCustTelNo(String custTelNo) {
		this.custTelNo = custTelNo;
		this.custTelNoEnc = Encode.encodeTelNo(custTelNo);
	}

	/**
	 * @取得 手机号码（已加密）
	 */
	public String getTelEnc() {
		return telEnc;
	}

	/**
	 * @设置 手机号码（已加密）
	 */
	public void setTelEnc(String telEnc) {
		this.telEnc = telEnc;
		this.tel = Encode.decodeTelNo(telEnc);
	}
	
	/**
	 * @取得 手机号码（已加密）
	 */
	public String getCustTelNoEnc() {
		return custTelNoEnc;
	}

	/**
	 * @设置 手机号码（已加密）
	 */
	public void setCustTelNoEnc(String custTelNoEnc) {
		this.custTelNoEnc = custTelNoEnc;
		this.custTelNo = Encode.decodeTelNo(custTelNoEnc);
	}

	/** @取得 邮箱（未加密） */
	public String getEmail() {
		return email;
	}

	/** @设置 邮箱（未加密） */
	public void setEmail(String email) {
		this.email = email;
		this.emailEnc = Encode.encodeEmail(email);
	}

	/** @取得 邮箱（已加密） */
	public String getEmailEnc() {
		return emailEnc;
	}

	/** @设置 邮箱（已加密） */
	public void setEmailEnc(String emailEnc) {
		this.emailEnc = emailEnc;
		this.email = Encode.decodeEmail(emailEnc);
	}

	/** @取得 银行卡号码（未加密） */
	public String getBankCardCode() {
		return bankCardCode;
	}

	/** @设置 银行卡号码（未加密） */
	public void setBankCardCode(String bankCardCode) {
		this.bankCardCode = bankCardCode;
		this.bankCardCodeEnc = Encode.encodeBankCardNo(bankCardCode);
	}

	/** @取得 银行卡号码（已加密） */
	public String getBankCardCodeEnc() {
		return bankCardCodeEnc;
	}

	/** @设置 银行卡号码（已加密） */
	public void setBankCardCodeEnc(String bankCardCodeEnc) {
		this.bankCardCodeEnc = bankCardCodeEnc;
		this.bankCardCode = Encode.decodeBankCardNo(bankCardCodeEnc);
	}

	/** @取得 银行卡绑定的手机号（未加密） */
	public String getBankCardTel() {
		return bankCardTel;
	}

	/** @设置 银行卡绑定的手机号（未加密） */
	public void setBankCardTel(String bankCardTel) {
		this.bankCardTel = bankCardTel;
		this.bankCardTelEnc = Encode.encodeTelNo(bankCardTel);
	}

	/** @取得 银行卡绑定的手机号（已加密） */
	public String getBankCardTelEnc() {
		return bankCardTelEnc;
	}

	/** @设置 银行卡绑定的手机号（已加密） */
	public void setBankCardTelEnc(String bankCardTelEnc) {
		this.bankCardTelEnc = bankCardTelEnc;
		this.bankCardTel = Encode.decodeTelNo(bankCardTelEnc);
	}

	/** @取得 身份证编号（未加密） */
	public String getIdCardCode() {
		return idCardCode;
	}

	/** @设置 身份证编号（未加密） */
	public void setIdCardCode(String idCardCode) {
		this.idCardCode = idCardCode;
		this.idCardCodeEnc = Encode.encodeIdCardNo(idCardCode);
	}

	/** @取得 身份证编号（已加密） */
	public String getIdCardCodeEnc() {
		return idCardCodeEnc;
	}

	/** @设置 身份证编号（已加密） */
	public void setIdCardCodeEnc(String idCardCodeEnc) {
		this.idCardCodeEnc = idCardCodeEnc;
		this.idCardCode = Encode.decodeIdCardNo(idCardCodeEnc);
	}

	/** @取得 身份证姓名（未加密） */
	public String getIdCardName() {
		return idCardName;
	}

	/** @设置 身份证姓名（未加密） */
	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
		this.idCardNameEnc = Encode.encodeName(idCardName);
	}

	/** @取得 身份证姓名（已加密） */
	public String getIdCardNameEnc() {
		return idCardNameEnc;
	}

	/** @设置 身份证姓名（已加密） */
	public void setIdCardNameEnc(String idCardNameEnc) {
		this.idCardNameEnc = idCardNameEnc;
		this.idCardName = Encode.decodeName(idCardNameEnc);
	}

	/** 获取 贷款人手机号（未加密） */
	public String getBrwTel() {
		return this.brwTel;
	}

	/** 设置 贷款人手机号（未加密） */
	public void setBrwTel(String brwTel) {
		this.brwTel = brwTel;
		this.brwTelEnc = Encode.encodeTelNo(brwTel);
	}

	/** 获取 贷款人手机号（已加密） */
	public String getBrwTelEnc() {
		return this.brwTelEnc;
	}

	/** 设置 贷款人手机号（已加密） */
	public void setBrwTelEnc(String brwTelEnc) {
		this.brwTelEnc = brwTelEnc;
		this.brwTel = Encode.decodeTelNo(brwTelEnc);
	}

	/** 获取 贷款人身份证号码（未加密） */
	public String getBrwIdCardCode() {
		return this.brwIdCardCode;
	}

	/** 设置 贷款人身份证号码（未加密） */
	public void setBrwIdCardCode(String brwIdCardCode) {
		this.brwIdCardCode = brwIdCardCode;
		this.brwIdCardCodeEnc = Encode.encodeIdCardNo(brwIdCardCode);
	}

	/** 获取 贷款人身份证号码（已加密） */
	public String getBrwIdCardCodeEnc() {
		return this.brwIdCardCodeEnc;
	}

	/** 设置 贷款人身份证号码（已加密） */
	public void setBrwIdCardCodeEnc(String brwIdCardCodeEnc) {
		this.brwIdCardCodeEnc = brwIdCardCodeEnc;
		this.brwIdCardCode = Encode.decodeIdCardNo(brwIdCardCodeEnc);
	}

	/** 获取 贷款人姓名（未加密） */
	public String getBrwIdCardName() {
		return this.brwIdCardName;
	}

	/** 设置 贷款人姓名（未加密） */
	public void setBrwIdCardName(String brwIdCardName) {
		this.brwIdCardName = brwIdCardName;
		this.brwIdCardNameEnc = Encode.encodeName(brwIdCardName);
	}

	/** 获取 贷款人姓名（已加密） */
	public String getBrwIdCardNameEnc() {
		return this.brwIdCardNameEnc;
	}

	/** 设置 贷款人姓名（已加密） */
	public void setBrwIdCardNameEnc(String brwIdCardNameEnc) {
		this.brwIdCardNameEnc = brwIdCardNameEnc;
		this.brwIdCardName = Encode.decodeName(brwIdCardNameEnc);
	}

	/** 获取 中介手机号（未加密） */
	public String getAgentTel() {
		return this.agentTel;
	}

	/** 设置 中介手机号（未加密） */
	public void setAgentTel(String agentTel) {
		this.agentTel = agentTel;
		this.agentTelEnc = Encode.encodeTelNo(agentTel);
	}

	/** 获取 中介手机号（已加密） */
	public String getAgentTelEnc() {
		return this.agentTelEnc;
	}

	/** 设置 中介手机号（已加密） */
	public void setAgentTelEnc(String agentTelEnc) {
		this.agentTelEnc = agentTelEnc;
		this.agentTel = Encode.decodeTelNo(agentTelEnc);
	}

	/** 获取 中介身份证号码（未加密） */
	public String getAgentIdCardCode() {
		return this.agentIdCardCode;
	}

	/** 设置 中介身份证号码（未加密） */
	public void setAgentIdCardCode(String agentIdCardCode) {
		this.agentIdCardCode = agentIdCardCode;
		this.agentIdCardCodeEnc = Encode.encodeIdCardNo(agentIdCardCode);
	}

	/** 获取 中介身份证号码（已加密） */
	public String getAgentIdCardCodeEnc() {
		return this.agentIdCardCodeEnc;
	}

	/** 设置 中介身份证号码（已加密） */
	public void setAgentIdCardCodeEnc(String agentIdCardCodeEnc) {
		this.agentIdCardCodeEnc = agentIdCardCodeEnc;
		this.agentIdCardCode = Encode.decodeIdCardNo(agentIdCardCodeEnc);
	}

	/** 获取 中介姓名（未加密） */
	public String getAgentIdCardName() {
		return this.agentIdCardName;
	}

	/** 设置 中介姓名（未加密） */
	public void setAgentIdCardName(String agentIdCardName) {
		this.agentIdCardName = agentIdCardName;
		this.agentIdCardNameEnc = Encode.encodeName(agentIdCardName);
	}

	/** 获取 中介姓名（已加密） */
	public String getAgentIdCardNameEnc() {
		return this.agentIdCardNameEnc;
	}

	/** 设置 中介姓名（已加密） */
	public void setAgentIdCardNameEnc(String agentIdCardNameEnc) {
		this.agentIdCardNameEnc = agentIdCardNameEnc;
		this.agentIdCardName = Encode.decodeName(agentIdCardNameEnc);
	}

	/**
	 * @取得 信贷经理手机号（未加密）
	 */
	public String getLoanManagerTel() {
		return loanManagerTel;
	}

	/**
	 * @设置 信贷经理手机号（未加密）
	 */
	public void setLoanManagerTel(String loanManagerTel) {
		if(!StringUtils.isEmpty(loanManagerTel)){
			this.loanManagerTel = loanManagerTel;
			this.loanManagerTelEnc = Encode.encodeTelNo(loanManagerTel);
		}
	}

	/**
	 * @取得 信贷经理手机号（已加密）
	 */
	public String getLoanManagerTelEnc() {
		return loanManagerTelEnc;
	}

	/**
	 * @设置 信贷经理手机号（已加密）
	 */
	public void setLoanManagerTelEnc(String loanManagerTelEnc) {
		this.loanManagerTelEnc = loanManagerTelEnc;
		this.loanManagerTel = Encode.decodeTelNo(loanManagerTelEnc);
	}
}
