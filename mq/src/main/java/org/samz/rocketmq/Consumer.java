package org.samz.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;

public class Consumer {

    public static void main(String[] args) throws MQClientException {


        DefaultMQPushConsumer  defaultMQPushConsumer = new DefaultMQPushConsumer("ProducerGroup");

        defaultMQPushConsumer.subscribe("topic","*");

    }
}
