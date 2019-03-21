package com.boot.test.common.scheduler.job;

import com.boot.test.common.scheduler.tool.SchedulerTool;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @功能:
 * @项目名:serviceMgmt
 * @作者:chuxu
 * @日期:2018年2月27日上午11:07:53
 */
@Component
@DisallowConcurrentExecution
public class Job1 implements Job{
	/** 任务工具 */
	private final SchedulerTool taskTool;

	public Job1() {
		taskTool = new SchedulerTool();
	}
	
	/**
	 * 人工审核自动归档定时任务：审核推荐人归档
	 * 将审核中超过一天的案件自动归档
	 */

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		taskTool.begin("测试任务开始");
		System.out.println("开始处理任务。。。");
		taskTool.end("测试任务结束",1);
		
	}
	
}
