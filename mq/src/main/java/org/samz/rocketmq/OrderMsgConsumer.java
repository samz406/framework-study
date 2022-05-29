package org.samz.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: lilin
 * @Date: 2022/5/26 11:28
 * @Description:
 */
public class OrderMsgConsumer {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("ProducerGroup");

        defaultMQPushConsumer.setNamesrvAddr("192.192.192.61:9876");
        defaultMQPushConsumer.subscribe("testOrderMsg2", "*");
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);

        //  defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                System.out.printf("%s 获取的消息 %s \n", LocalDateTime.now(), msgs);

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        defaultMQPushConsumer.start();

    }
}
