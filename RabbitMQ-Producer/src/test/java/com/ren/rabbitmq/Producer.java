package com.ren.rabbitmq;

import com.ren.rabbitmq.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : renjiahui
 * @date : 2020/7/22 23:44
 * @desc : 消息发送方的测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //使用rabbitTemplate发送消息
    @Test
    public void sendEmail() {


        String message = "发送邮件消息给用户";
        /**
         * 参数说明：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_TOPICS_INFORM, "inform.email", message);
    }
}
