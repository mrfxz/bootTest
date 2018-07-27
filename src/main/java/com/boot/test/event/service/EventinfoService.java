/** */
package com.boot.test.event.service;

import org.springframework.stereotype.Service;
import com.boot.test.base.service.BaseService;
import com.boot.test.event.dao.EventinfoDao;
import com.boot.test.event.pojo.EventinfoPojo;
import com.boot.test.event.service.iservice.IEventinfoService;

/**
 * @功能:【eventinfo 事件表】Service
 * @项目名:best-pay-sdk-develop
 * @作者:fxz
 * @日期:2018-07-27 14:58:24
 * @说明：<pre></pre>
 */
@Service
public class EventinfoService extends BaseService<EventinfoPojo, EventinfoDao> implements IEventinfoService {

}
