package com.boot.test.common.base.pojo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@ConfigurationProperties(prefix = "sys-message-cfg.template")
public class CfgSysMessageTemplate implements Serializable {
	/** UUID */
	private static final long serialVersionUID = 3391255137075559110L;

	/** 【系统消息】广播内容模板 */
	private static String repayRadio;

	/**
	 * @取得 【系统消息】广播内容模板
	 */
	public static String getRepayRadio() {
		return repayRadio;
	}

	/**
	 * @设置 【系统消息】广播内容模板
	 */
	public static void setRepayRadio(String repayRadio) {
		CfgSysMessageTemplate.repayRadio = repayRadio;
	}
}
