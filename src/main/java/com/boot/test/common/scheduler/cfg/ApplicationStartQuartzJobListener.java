package com.boot.test.common.scheduler.cfg;

import com.boot.test.common.scheduler.SchedulerManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


@Configuration
public class ApplicationStartQuartzJobListener implements ApplicationListener<ContextRefreshedEvent>{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private SchedulerManager manager;

    /**
     * 初始启动quartz
     */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			manager.startAll();
		} catch (Exception e) {
			logger.info("启动定时任务出错:" + e);
		}
	}

    /**
     * 初始注入scheduler
     * @return
     * @throws SchedulerException
     */
    @Bean
    public Scheduler scheduler() throws SchedulerException{
        SchedulerFactory schedulerFactoryBean = new StdSchedulerFactory();
        return schedulerFactoryBean.getScheduler(); 
    }
}
