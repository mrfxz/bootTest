package com.boot.test.junit;

import com.boot.test.common.scheduler.SchedulerManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JobTest {
    @Autowired
    private SchedulerManager manager;

    @Test
    public void jobTest1() throws ClassNotFoundException, SchedulerException {
        manager.startJob(null);
    }
}
