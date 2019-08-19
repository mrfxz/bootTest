package com.myeurekaconsumer.myeurekaconsumer.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("token",System.getProperty("token"));
    }
}
