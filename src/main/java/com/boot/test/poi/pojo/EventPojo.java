package com.boot.test.poi.pojo;

/**
 * 事件实体,对应数据库eventInfo表
 */
public class EventPojo {

    private Integer id;
    private String eventId;//事件ID
    private String eventDes;//事件描述
    private String remark;//备注
    private String reason;//原因

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventDes() {
        return eventDes;
    }

    public void setEventDes(String eventDes) {
        this.eventDes = eventDes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "EventPojo{" +
                "id=" + id +
                ", eventId='" + eventId + '\'' +
                ", eventDes='" + eventDes + '\'' +
                ", remark='" + remark + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
