package com.codenotfound.artemis.producer;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.codenotfound.artemis.kafka.EdigasInQueue;

@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(EdigasInQueue queue, String payload, String id) {
        LOGGER.info("Sending payload='{}' to queue='{}' with id={}", payload, queue.getName(), id);
        jmsTemplate.send(queue.getName(), session -> {
            Message message = session.createTextMessage(payload);
            message.setStringProperty("JMSXGroupID", "locationId=" + id);
            return message;
        });
    }
}
