/**
 * 
 */
package com.boot.test.common.base.pojo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@ConfigurationProperties(prefix = "common.sys-config.cfg-custinfo-check-param")
public class CfgCustInfoCheckParam implements Serializable {
	/** */
	private static final long serialVersionUID = -2502452804955646159L;
	/** 图形验证码长度 */
	private int imgVerifCodeLength;
	/** 短信验证码长度 */
	private int smsVerifCodeLength;
	/** 登录失败限制次数 */
	private int loginErrTimes;
	/**
	 * 发送验证码时获得的图形验证码地址以及回调地址
	 * https://wwwt.bdxiaodai.com/app/share/rec01.html?checkApi=/cust/api/getClickCaptchaImgPub/v1&
	 * key=xxxxxxxxx
	 */
	private String regCodeClickCaptchaCode;

	/**
	 * @取得 图形验证码长度
	 */
	public int getImgVerifCodeLength() {
		return imgVerifCodeLength;
	}

	/**
	 * @设置 图形验证码长度
	 */
	public void setImgVerifCodeLength(int imgVerifCodeLength) {
		this.imgVerifCodeLength = imgVerifCodeLength;
	}

	/**
	 * @取得 短信验证码长度
	 */
	public int getSmsVerifCodeLength() {
		return smsVerifCodeLength;
	}

	/**
	 * @设置 短信验证码长度
	 */
	public void setSmsVerifCodeLength(int smsVerifCodeLength) {
		this.smsVerifCodeLength = smsVerifCodeLength;
	}

	/**
	 * @取得 登录失败限制次数
	 */
	public int getLoginErrTimes() {
		return loginErrTimes;
	}

	/**
	 * @设置 登录失败限制次数
	 */
	public void setLoginErrTimes(int loginErrTimes) {
		this.loginErrTimes = loginErrTimes;
	}

	/**
	 * @取得 发送验证码时获得的图形验证码地址以及回调地址https:wwwt.bdxiaodai.comappsharerec01.html?checkApi=
	 *     custapigetClickCaptchaImgPubv1&key=xxxxxxxxx
	 */
	public String getRegCodeClickCaptchaCode() {
		return regCodeClickCaptchaCode;
	}

	/**
	 * @设置 发送验证码时获得的图形验证码地址以及回调地址https:wwwt.bdxiaodai.comappsharerec01.html?checkApi=
	 *     custapigetClickCaptchaImgPubv1&key=xxxxxxxxx
	 */
	public void setRegCodeClickCaptchaCode(String regCodeClickCaptchaCode) {
		this.regCodeClickCaptchaCode = regCodeClickCaptchaCode;
	}

}
