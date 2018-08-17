/** */
package com.boot.test.event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boot.test.event.pojo.EventinfoPojo;
import com.boot.test.base.controller.BaseController;
import com.boot.test.event.service.iservice.IEventinfoService;

import java.util.List;

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

    private Logger logger = LogManager.getLogger(this.getClass());
  	/**
	 * get
	 * @param eventinfo
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	@ResponseBody
	public List<EventinfoPojo> get(EventinfoPojo eventinfo, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("蛋疼");
		return null;
	}

	@RequestMapping("/update")
	public void update(EventinfoPojo eventinfo, HttpServletRequest request, HttpServletResponse response) {
		eventinfoService.update(eventinfo);
	}
}
