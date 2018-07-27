package com.boot.test.base.controller;

import com.boot.test.common.base.controller.AbsBaseController;
import com.boot.test.common.base.pojo.BasePojo;
import com.boot.test.common.base.pojo.MgmtUser;

import javax.servlet.http.HttpServletRequest;


/**
 * @功能:
 * @项目名:dunningServer
 * @作者:wangjz
 * @日期:2017年8月5日下午2:38:21
 * @说明：<pre></pre>
 */
public class BaseController<T extends BasePojo> extends AbsBaseController<T> {
	/**
	 * 检查user对象是否授权，若授权则返回user对象，若未授权则抛异常
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public MgmtUser getAndCheckCurUserAccredit(HttpServletRequest request) throws Exception {
	return null;
	}
}
