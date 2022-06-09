package org.samz.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @author: lilin
 * @Date: 2022/6/1 17:53
 * @Description:
 */
public class Consumer2 {

    public static void main(String[] args) throws MQClientException {


        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("ProducerGroup2");

        defaultMQPushConsumer.setNamesrvAddr("192.192.192.62:9876");
        defaultMQPushConsumer.subscribe("SingleQueue","*");
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);
        defaultMQPushConsumer.setPullBatchSize(32);
        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(20);

      //  defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                System.out.printf("%s 获取的消息 %s \n", LocalDateTime.now(),msgs);

                if (new Random(10).nextInt(10)== 5){
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        defaultMQPushConsumer.start();

    }
}
