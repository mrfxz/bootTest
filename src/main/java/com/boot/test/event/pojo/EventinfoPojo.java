/** */
package com.boot.test.event.pojo;

import com.boot.test.common.base.pojo.BasePojo;

/**
 * @功能:【eventinfo 事件表】PO
 * @项目名:best-pay-sdk-develop
 * @作者:fxz
 * @日期:2018-07-27 14:58:24
 * @说明：<pre></pre>
 */
public class EventinfoPojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
	/** 事件ID */
	private String eventId;
	/** 事件描述 */
	private String eventDes;
	/** 备注 */
	private String remark;
	/** 失败原因 */
	private String reason;

	
	/** @取得 事件ID */
	public String getEventId(){
		return eventId;
	}
	
	/** @设置 事件ID */
	public void setEventId(String eventId){
		this.eventId = eventId;
	}
	
	/** @取得 事件描述 */
	public String getEventDes(){
		return eventDes;
	}
	
	/** @设置 事件描述 */
	public void setEventDes(String eventDes){
		this.eventDes = eventDes;
	}
	
	/** @取得 备注 */
	public String getRemark(){
		return remark;
	}
	
	/** @设置 备注 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	/** @取得 失败原因 */
	public String getReason(){
		return reason;
	}
	
	/** @设置 失败原因 */
	public void setReason(String reason){
		this.reason = reason;
	}

}
