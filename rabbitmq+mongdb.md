# rabbitmq
## 安装
### Linux 环境下面
> 下载地址：[rabbitmq 下载地址](https://akamai.bintray.com/18/18ce3115e7934e9540e39bbe4b53c035caea76f9e2d459943cb753abe54105c7?__gda__=exp=1507984589~hmac=4125107768949851335447fffa173da5f7d213e6a703cb528a29f2189713e99d&response-content-disposition=attachment%3Bfilename%3D%22rabbitmq-server_3.6.12-1_all.deb%22&response-content-type=application%2Fx-debian-package&requestInfo=U2FsdGVkX1-qgCWLb-w4046RwReB0ZBhVQqalnXsFASiNjzOyMGdt4rAsP6ObgfZshVg7NmkzmOY3rUlzny0AX4qTaJoEjshdh9Qt6fVPCSJrU5DfMqdnk1eQC3hOaX6F3h9dqt3KiAl_1qUs4LGrxjZm64zURMGuRfnR2uGcGxpmxRtOYO_k9cWwYas3yym)

### 启动
下载RabbitMQ的安装包，如下安装：

+ 安装 dpkg -i rabbitmq-server_2.6.1-1_all.deb


+ /etc/init.d/rabbitmq-server start|stop|restart
来启动、停止、重启rabbitmq。 

+  service rabbitmq-server start.

### Window 环境下面
[Windows 环境下面](http://www.cnblogs.com/ericli-ericli/p/5902270.html)
### 依赖
> Below is the list of dependencies of RabbitMQ server as of 3.6.3:

> erlang-nox (>= 1:16.b.3) | esl-erlang. Erlang can installed either from the standard repositories, backport repositories or Erlang Solutions.
init-system-helpers >= 1.13. Required for systemd support.

    socat
    
    adduser
    
    logrotate



## 配置

## 优化方案

#### Sping boot 配置
>
	1. # RABBIT (RabbitProperties)  
	2. spring.rabbitmq.host= # connection host  
	3. spring.rabbitmq.port= # connection port  
	4. spring.rabbitmq.addresses= # connection addresses (e.g. myhost:9999,otherhost:1111)  
	5. spring.rabbitmq.username= # login user  
	6. spring.rabbitmq.password= # login password  
	7. spring.rabbitmq.virtualhost=  
	8. spring.rabbitmq.dynamic= 
#### Spring boot MQ 注解
```

	Argument
	
	EnableRabbit
	
	Exchange
	
	Queue
	
	QueueBinding
	
	RabbitBootstrapConfiguration
	
	RabbitHandler
	
	RabbitListener

      //参数中使用@Header获取mesage
    @RabbitListener(queues = { "ccs.queue.async.reply", "ccs.queue.bds.reply", "ccs.queue.etl.reply", "ccs.queue.mal.reply" })
    public void asyncReply(BaseResponse response) {
        logger.debug(response.getMsg());
        ccsQtrtzLogService.updateExecResultById(response.getMsg(), response.isSuccess());
    }
	
	RabbitListenerAnnotationBeanPostProcessor
	
	RabbitListenerConfigurer
	
	RabbitListeners

```
### 注册 MQ队列


##### 配置消息交换



####  NOTE
> RabbitMQ 高可用性、高性能、灵活性
>
> AMQP，即Advanced Message Queuing Protocol，高级消息队列协议

# mongdb

## linux 安装 MongDB
####
curl -O https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.0.6.tgz    # 下载
tar -zxvf mongodb-linux-x86_64-3.0.6.tgz                                   # 解压
mv  mongodb-linux-x86_64-3.0.6/ /usr/local/mongodb     

## 配置

## 优化方案


### Maven 依赖
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>



[RabbitMQ 使用](http://www.cnblogs.com/boshen-hzb/p/6841982.html)

[Rabbit MQ](https://segmentfault.com/a/1190000004401870)


```

	//创建ConnectionFactory //注意: guest的用户只能够在localhost 127.0.0.1进行测试
	        String hostname = "localhost";
	        String username = "mytest";
	        String password = "mytest";
	        String virtualHost = "/";
	        CachingConnectionFactory cf = new CachingConnectionFactory(hostname);
	        cf.setUsername(username);
	        cf.setPassword(password);
	        cf.setVirtualHost(virtualHost);
	
	        RabbitAdmin admin = new RabbitAdmin(cf);
	
	　　　　//创建Exchange
	        String exchangeName = "direct.test.exchange";
	        DirectExchange exchange = new DirectExchange(exchangeName);
	        admin.declareExchange(exchange);
	
	　　　　//创建Queue
	        String queueName = "direct.test.queue";
	        Queue queue = new Queue(queueName, true, false, false, null);
	        admin.declareQueue(queue);
	
	　　　　//创建Binding
	        String routingKey = "direct.test.queue";
	        admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(routingKey));
	
	　　　　//创建RabbitTemplate
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(cf);
	        rabbitTemplate.setExchange(exchangeName);
	        rabbitTemplate.setQueue(queueName);
	
	　　　　//创建Message
	        String messageStr = "this is direct message";
	        Message message = MessageBuilder.withBody(messageStr.getBytes())
	                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).build();
	　　　　//根据routingKey发送消息
	        System.out.println("message=" + message);
	        rabbitTemplate.send(routingKey, message);
	
	　　　　//接收消息
	        Message resultMessage = rabbitTemplate.receive();
	        System.out.println("resultMessage=" + resultMessage);
	        if (resultMessage != null) {
	            System.out.println("receive massage=" + new String(resultMessage.getBody()));
	        }
	    }

```

[MQ 最佳例子 ](https://segmentfa@EnableRabbitult.com/a/1190000004401870)


[Spring boot RabbitMQ官网例子](https://docs.spring.io/spring-amqp/docs/current/api/org/springframework/amqp/rabbit/annotation/EnableRabbit.html)



