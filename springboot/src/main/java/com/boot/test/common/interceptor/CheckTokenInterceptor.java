package com.boot.test.common.interceptor;

import com.boot.test.redis.RedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CheckTokenInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("myRedisDao")
    private RedisDao dao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String webToken = request.getHeader("token");
        String localToken = dao.get(webToken, String.class);
        if(webToken.equals(localToken)){
            logger.info("token认证通过： " + webToken);
            return true;
        }
        logger.info("token认证失败： " + webToken);
        return false;
    }
}
