package com.boot.test.junit;

import com.boot.test.mq.rabbitmq.routing.MyProductorRouting;
import com.boot.test.mq.rabbitmq.subscription.MyProductorFanout;
import com.boot.test.mq.rabbitmq.topic.MyProductorTopic;
import com.boot.test.mq.rabbitmq.work.MyProductorWork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class rabbitmqTest {
    @Autowired
    private MyProductorWork productor;
    @Autowired
    private MyProductorFanout fanout;

    @Autowired
    private MyProductorRouting routing;
    @Autowired
    private MyProductorTopic topic;

    @Test
    public void testTopic() {
        StringBuilder sb = new StringBuilder("routeKey");
        for (int i = 1; i <= 5; i++) {
            topic.pro("topicExchange", sb.toString(), "topic_msg_" + i);
            sb.append(".");
        }

    }

    @Test
    public void testRouting() {
//        routing.pro("routeExchange","routeKey.2","lalala");
    }

    @Test
    public void test() {
//        productor.product("simple早上好哇！","springBoot_rabbit_simple");
    }

    @Test
    public void testWork() throws InterruptedException {
//        for(int i = 1; i< 21; i++){
//            productor.product("work_" + i,"springBoot_rabbit_work");
//            Thread.sleep(300);
//        }
    }

//    @Test
//    public void testFanout(){
//        for(int i = 1; i< 21; i++){
//            fanout.product("fanout_" + i,"springBoot_rabbit_fanoutExchange");
//        }
//    }

}
