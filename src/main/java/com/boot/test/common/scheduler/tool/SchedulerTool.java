package com.boot.test.common.scheduler.tool;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SchedulerTool {

	/** 日志对象 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private Long beginTime;

	private Long endTime;

	private Integer count = 0;

	public void begin(String jobName) {
		this.beginTime = System.currentTimeMillis();
		logger.info("【定时任务：{}】：在 {} 开始... ", jobName, new Timestamp(this.beginTime).toString());
	}

	public void end(String jobName,Integer count) {
		if(count != null)this.count = count;
		this.endTime = System.currentTimeMillis();
		logger.info("【定时任务：{}】：在 {} 完成，共处理{}条数据,花费时间：{}s", jobName,
				new Timestamp(this.beginTime).toString(), this.count,
				(this.endTime - this.beginTime) / 1000);
	}
}
