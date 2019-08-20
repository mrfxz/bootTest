package com.boot.test.common.interceptor;

import com.boot.test.redis.RedisDao;
import com.boot.test.util.JsonTool;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CheckTokenInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("myRedisDao")
    private RedisDao dao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        if(url.indexOf("/pub/") >0){
            logger.info("获取token接口，直接放行。");
            return true;
        }

        String webToken = request.getHeader("token");
        if(webToken !=null){
            String localToken = dao.get(webToken, String.class);
            if(webToken.equals(localToken)){
                logger.info("token认证通过： " + webToken);
                return true;
            }
        }

        logger.info("token认证失败： " + webToken);
        httpResponse(response,"认证失败，请重新获取token");
        return false;
    }

    /**
     * response返回数据
     *
     * @param response
     * @return
     * @throws IOException
     */
    public  void httpResponse(HttpServletResponse response,String str) {
        PrintWriter writer = null;
        try {
            response.setContentType("text/plain");
            response.setCharacterEncoding("utf-8");
            writer = response.getWriter();
            writer.write(str);
            writer.flush();
        } catch (Exception ex) {
            logger.error("服务端返回异常", ex);
            try {
                response.sendError(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException e) {}
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
