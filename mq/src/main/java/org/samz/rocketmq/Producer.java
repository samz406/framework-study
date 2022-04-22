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

        defaultMQProducer.setNamesrvAddr("192.192.192.61:9876");
        defaultMQProducer.start();

       // defaultMQProducer.setNamesrvAddr("127.0.0.1");


        for (int i = 0; i < 10; i++) {
            Message message = new Message("TestTopic", ("Hello").getBytes());
            defaultMQProducer.send(message);
        }



    }
}
