package com.myeurekaconsumer.myeurekaconsumer.consumer;

import org.springframework.stereotype.Component;

@Component
public class ConsumerFeignFallBackImpl  implements EurekaConsumer{

    @Override
    public String getTom() {
        return "服务调用失败";
    }

    @Override
    public String getToken(Long id) {
        return "TOKEN获取失败";
    }
}
