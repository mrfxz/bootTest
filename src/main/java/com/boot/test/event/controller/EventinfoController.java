/** */
package com.boot.test.event.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boot.test.mail.javaMailUtil;
import com.boot.test.mail.javaMailUtil2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());
  	/**
	 * get
	 * @param eventinfo
	 * @param request
	 * @param response
	 */
	@RequestMapping("/get")
	@ResponseBody
	public List<EventinfoPojo> get(EventinfoPojo eventinfo, HttpServletRequest request, HttpServletResponse response){
        try{
            eventinfoService.aopTest();
        }catch(Exception e){}

		return null;
	}
    @RequestMapping("/update")
	public void update(EventinfoPojo eventinfo, HttpServletRequest request, HttpServletResponse response){
        eventinfoService.updateEvent(eventinfo);
    }
	@RequestMapping("/sendMail")
    public void sendMail(){
		javaMailUtil2 mail = new javaMailUtil2();
		try{
			mail.init();
		}catch (Exception e){
			System.out.println(e);
		}

	}
}
