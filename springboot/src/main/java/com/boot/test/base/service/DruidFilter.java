package com.boot.test.base.service;

/**
 * 配置监控拦截器
 * druid监控拦截器
 *
 * @ClassName: DruidFilter
 */

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
                ,})// 忽略资源

public class DruidFilter extends DruidStatProperties.WebStatFilter {

}



