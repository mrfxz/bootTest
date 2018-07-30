/**
 * 
 */
package com.boot.test.common.base.pojo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@ConfigurationProperties(prefix = "common.sys-config.cfg-res-and-session-param")
public class CfgResAndSessionParam implements Serializable {
	/** */
	private static final long serialVersionUID = -6164270468382182889L;
	/** session过期时长,单位：分钟 */
	private int sessionExp;
	/** 验证码过期时长,单位：分钟 */
	private int verificationCodeExp;
	/** 短信发送次数限制周期，单位：小时 */
	private int sendTimesLimitExp;
	/** 短信发送最大次数限制>x，超过后延长解冻时间，防止攻击 */
	private int sendTimesMaxLimit;
	/** 短信发送限制次数 */
	private int sendTimesLimit;
	/** 图片等资源存放站点根目录 */
	private String resRootUrl;
	/** 是否发布模式 */
	private boolean releaseMode;
	/** 签名验证超时时间限制 单位：分钟 */
	private int authTimeLimit;

	/**
	 * @取得 session过期时长单位：分钟，默认30分钟
	 */
	public int getSessionExp() {
		return sessionExp;
	}

	/**
	 * @设置 session过期时长单位：分钟，默认30分钟
	 */
	public void setSessionExp(int sessionExp) {
		this.sessionExp = sessionExp;
	}

	/**
	 * @取得 验证码过期时长单位：分钟，默认5分钟
	 */
	public int getVerificationCodeExp() {
		return verificationCodeExp;
	}

	/**
	 * @设置 验证码过期时长单位：分钟，默认5分钟
	 */
	public void setVerificationCodeExp(int verificationCodeExp) {
		this.verificationCodeExp = verificationCodeExp;
	}

	/**
	 * @取得 短信发送次数限制周期，单位：分钟，默认24*60分钟
	 */
	public int getSendTimesLimitExp() {
		return sendTimesLimitExp;
	}

	/**
	 * @设置 短信发送次数限制周期，单位：分钟，默认24*60分钟
	 */
	public void setSendTimesLimitExp(int sendTimesLimitExp) {
		this.sendTimesLimitExp = sendTimesLimitExp;
	}

	/** @取得 短信发送最大次数限制>x，超过后延长解冻时间，防止攻击 */
	public int getSendTimesMaxLimit() {
		return sendTimesMaxLimit;
	}

	/** @设置 短信发送最大次数限制>x，超过后延长解冻时间，防止攻击 */
	public void setSendTimesMaxLimit(int sendTimesMaxLimit) {
		this.sendTimesMaxLimit = sendTimesMaxLimit;
	}

	/**
	 * @取得 图片等资源存放站点根目录
	 */
	public String getResRootUrl() {
		return resRootUrl;
	}

	/**
	 * @设置 图片等资源存放站点根目录
	 */
	public void setResRootUrl(String resRootUrl) {
		this.resRootUrl = resRootUrl;
	}

	/**
	 * @取得 是否发布模式
	 */
	public boolean getReleaseMode() {
		return releaseMode;
	}

	/**
	 * @设置 是否发布模式
	 */
	public void setReleaseMode(boolean releaseMode) {
		this.releaseMode = releaseMode;
	}

	/**
	 * @取得 签名验证超时时间限制 单位：分种
	 */
	public int getAuthTimeLimit() {
		return authTimeLimit;
	}

	/**
	 * @设置 签名验证超时时间限制 单位：分种
	 */
	public void setAuthTimeLimit(int authTimeLimit) {
		this.authTimeLimit = authTimeLimit;
	}

	/**
	 * @取得 sendTimesLimit
	 */
	public int getSendTimesLimit() {
		return sendTimesLimit;
	}

	/**
	 * @设置 sendTimesLimit
	 */
	public void setSendTimesLimit(int sendTimesLimit) {
		this.sendTimesLimit = sendTimesLimit;
	}

}
