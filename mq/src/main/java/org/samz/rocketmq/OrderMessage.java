package org.samz.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author: lilin
 * @Date: 2022/5/26 10:58
 * @Description: 顺序消息
 */
public class OrderMessage {


    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {

        TransactionMQProducer producer = new TransactionMQProducer("testOrderMsgGroup");

        producer.setNamesrvAddr("192.192.192.61:9876");
        producer.start();
        MsgSelector msgSelector = new MsgSelector();

        for (int i = 0; i < 100; i++) {
            int orderId = i % 10;
            String msg = "Hello RocketMQ" + i;
            Message message = new Message("testOrderMsg2", msg.getBytes());
            final SendResult send = producer.send(message, msgSelector, orderId);

            System.out.println(send);
        }

    }

    /**
     * 发送队列选择器
     */
    static class MsgSelector implements MessageQueueSelector {

        @Override
        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {

            Integer id = (Integer) arg;
            int index = id % mqs.size();
            return mqs.get(index);
        }
    }
}
