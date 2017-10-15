package com.example.rabbitserver.service;

import com.example.rabbitserver.dto.Bar;
import com.example.rabbitserver.dto.Foo;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author tannc
 * @create_time 2017/10/1514:30
 */
@Component
public class SenderService {

    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    public void sendFoo2Rabbitmq(final Foo foo) {
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.foo", foo);
    }

    public void sendBar2Rabbitmq(final Bar bar){
        this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.bar", bar);
    }
}
