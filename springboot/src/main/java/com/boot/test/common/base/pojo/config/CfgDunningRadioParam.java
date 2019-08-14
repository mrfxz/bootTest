package com.boot.test.common.base.pojo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@ConfigurationProperties(prefix = "common.sys-config.cfg-sys-message-radio")
public class CfgDunningRadioParam implements Serializable {
    /**
     * UUID
     */
    private static final long serialVersionUID = -6161935993835479624L;

    /**
     * 各部门滚动消息数量，查询条件
     */
    private static Integer radioAmount;

    /**
     * 每个部门消息更新时间间隔，判断缓存有效依据 ：分钟
     */
    private static Long updateInterval;

    /**
     * 消息有效时间，过期消息不会被广播：分钟
     */
    private static Long vaildTime;

    /**
     * @取得 radioAmount
     */
    public static Integer getRadioAmount() {
        return radioAmount;
    }

    /**
     * @设置 radioAmount
     */
    public void setRadioAmount(Integer radioAmount) {
        CfgDunningRadioParam.radioAmount = radioAmount;
    }

    /**
     * @取得 updateInterval
     */
    public static Long getUpdateInterval() {
        return updateInterval;
    }

    /**
     * @设置 updateInterval
     */
    public void setUpdateInterval(Long updateInterval) {
        CfgDunningRadioParam.updateInterval = updateInterval;
    }

    /**
     * @取得 消息有效时间，过期消息不会被广播：分钟
     */
    public static Long getVaildTime() {
        return vaildTime;
    }

    /**
     * @设置 消息有效时间，过期消息不会被广播：分钟
     */
    public static void setVaildTime(Long vaildTime) {
        CfgDunningRadioParam.vaildTime = vaildTime;
    }
}
