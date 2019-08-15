package com.myeurekaconsumer.myeurekaconsumer.consumer;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFeignFallFactory implements FallbackFactory<EurekaConsumer> {

    private Logger logger= LoggerFactory.getLogger(MyFeignFallFactory.class);

    @Override
    public EurekaConsumer create(Throwable throwable) {
        logger.info("错误信息： " + throwable);
        return new EurekaConsumer(){
            @Override
            public String getTom() {
                //此时如果有请求数据的话，可以把请求数据记录下来，以便后期重新请求
                return "服务调用出错";
            }
        };
    }
}
