/** */
package com.boot.test.event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boot.test.event.pojo.EventinfoPojo;
import com.boot.test.base.controller.BaseController;
import com.boot.test.event.service.iservice.IEventinfoService;

/**
 * @功能:【eventinfo 事件表】controller
 * @项目名:best-pay-sdk-develop
 * @作者:fxz
 * @日期:2018-07-27 14:58:24
 * @说明：<pre></pre>
 */
@RestController
@RequestMapping("/eventinfo")
public class EventinfoController extends BaseController<EventinfoPojo> {
	/** eventinfo 事件表service*/
    @Autowired
    private IEventinfoService eventinfoService;
    
  	/**
	 * get
	 * @param eventinfo
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	public void get(EventinfoPojo eventinfo, HttpServletRequest request, HttpServletResponse response) {

	}
}
