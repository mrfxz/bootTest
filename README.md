# bootTest
study spring boot demo

springboot + mybatis 项目搭建

2018-07-27之前有如下功能: 
	1 excel简单的导入导出工具类 
	
						 2 freemarker + ftl 实现自动生成简单的CRUD

2018-08-17添加新的功能: 3 spring aop切面 
	
	
					   4 log4j2 + log4jdbc

2019-03-21添加新的功能: 
	5 quartz 定时任务，可由数据库配置cron,修改cron不用重启项目 
	
					   6 junit 单元测试

2019-08-06添加新的功能：
	7 整合rabbitmq,新增注解方式rabbitmq 5种队列demo

2019-08-09添加新的功能：
	8 整合redis,实现对redis简单的存取操作

2019-08-14添加新的功能：
    9 整合springcloud,实现eureka服务注册中心和feign服务接口访问,多个同名服务测试feign调用采用轮询方式实现负载均衡；添加fallBackFactory实现feign异常调用熔断,降级

2019-08-20添加新的功能：
	10 引入spring-security模块，实现eureka管理界面及client注册需要密码登录；添加服务间调用token验证，具体思路如下：
			
			1 创建一个服务提供token
			2 其他服务提供者添加拦截器验证token，验证通过才能调用服务
			3 消费者需要先获取token，然后再将token放入header中请求服务
			PS：本项目token统一存在一个redis里面，所有服务提供者共用一个redis,方便验证token
	
						11 引入gateway模块，简单实现统一网关（PS：通过网关路由的服务必须先在eureka注册，仅实现统一网关访问，安全验证拦截器实现原理和feign间调用验证拦截器原理一致，略。）




		  