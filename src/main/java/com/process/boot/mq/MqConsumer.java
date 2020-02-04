package com.process.boot.mq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xukaixuan
 */
@Component
//@RabbitListener(queues = "xboot.hello")
public class MqConsumer {

    @RabbitListener(bindings = {
        @QueueBinding(value = @Queue(value = "xboot.pay.task", durable = "true"),
            exchange = @Exchange(value = ""), key = "xboot.pay.task")})
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

    @RabbitListener(queues = "xboot.pay.status")
    public void processStatus(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
