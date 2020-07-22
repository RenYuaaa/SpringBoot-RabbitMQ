package com.ren.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import com.ren.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : renjiahui
 * @date : 2020/7/23 0:15
 * @desc : 消息的接收
 */
@Component
public class ReceiveHandler {

    //接收邮件消息
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_INFORM_EMAIL})
    public void getEmail(String msg, Message message, Channel channel) {
        System.out.println("接收到的消息是：" + msg);
        System.out.println("由Message接收到的消息：" + message.getBody());
    }

    //接收短信消息
    @RabbitListener(queues = {RabbitMQConfig.QUEUE_INFORM_SMS})
    public void getSms(String msg, Message message, Channel channel) {
        System.out.println("由Message接收到的消息：" + message.getBody());
    }

}
