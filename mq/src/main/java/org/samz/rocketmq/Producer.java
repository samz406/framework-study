package org.samz.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 生产者
 */
public class Producer {


    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {


        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("ProducerGroup");

        defaultMQProducer.setNamesrvAddr("192.192.192.62:9876");
        defaultMQProducer.start();
        for (int i = 0; i < 20; i++) {
            Message message = new Message("SingleQueue", ("Hello").getBytes());
            defaultMQProducer.send(message);
        }

    }
}
