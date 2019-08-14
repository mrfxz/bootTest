package com.boot.test.junit;

import com.boot.test.redis.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    @Qualifier("myRedisDao")
    private RedisDao dao;

    @Test
    public void test1() {
        dao.saveOrUpdate("hello", "lalala");
        String hello = dao.get("hello", String.class);
        System.out.println("Redis 取值为： " + hello);
    }

}
