package com.boot.test.eurekaProductor;

import com.boot.test.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "productor")
public class ProductorController {

    @Autowired
    @Qualifier("myRedisDao")
    private RedisDao dao;

    @Value("${server.port}")
    private String port;

    @RequestMapping(method = RequestMethod.GET)
    public String getTom() {
        return "i am tom!" + port;
    }

    @RequestMapping(value = "/token/{id}",method = RequestMethod.GET)
    public String getToken(@PathVariable("id") Long id){
        String token = dao.get(id.toString(), String.class);
        if(token != null){
            return token;
        }
        token = UUID.randomUUID().toString();
        dao.saveOrUpdate(token,token,60);
        return token;
    }
}
