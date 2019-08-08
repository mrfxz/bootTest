package com.boot.test.common.scheduler.job;

import com.boot.test.common.scheduler.tool.SchedulerTool;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;


@Component
@DisallowConcurrentExecution
public class Job1 implements Job{
	/** 任务工具 */
	private final SchedulerTool taskTool;

	public Job1() {
		taskTool = new SchedulerTool();
	}


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		taskTool.begin("测试任务开始");
		System.out.println("开始处理任务。。。");
		taskTool.end("测试任务结束",1);
		
	}
	
}
