package com.codenotfound.artemis.config;

import javax.jms.Session;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.codenotfound.artemis.consumer.Receiver;

@Configuration
@EnableJms
public class ReceiverConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverConfig.class);

    @Value("${artemis.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
        LOGGER.info("receiverActiveMQConnectionFactory config ...");
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        LOGGER.info("jmsListenerContainerFactory config ...");
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(receiverActiveMQConnectionFactory());
        factory.setConcurrency("3-3");

        // Sicherstellen, dass Nachrichten in der Queue verbleiben bis deren Verarbeitung vom Consumer quittiert wird
        // Die Quittierung geschieht automatisch
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return factory;
    }
}
