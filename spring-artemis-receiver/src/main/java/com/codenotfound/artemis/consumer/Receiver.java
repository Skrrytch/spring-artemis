package com.codenotfound.artemis.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    /**
     * group-rebalance
     * - nur wenn true, dann wwerden alle Consumer neu aufgeteilt, falls neue hinzukommen
     * - unabhängig von true/false: Fallen Consumer weg, so werden die Nachrichten von deren MessageGroups neu verteilt (beim Eintreffen)
     * consumer.prefetchSize
     * - >1: Es werden mehrere Nachrichten geholt (caching pro Consumer)
     * - 1: Immer nur eine Nachricht holen und verarbeiten (kein Cachen von Nachrichten in den Queues)
     *
     * @param message
     */
    @JmsListener(destination = QueueOfIncomingEdigas.NAME
            +"?group-rebalance=true&consumer.prefetchSize=1",
            concurrency = "2-2")
    public void receive(String message) {
        LOGGER.info("received message='{}'", message);
        int waitLoop = 10;
        for (int count = 1; count < waitLoop; count++) {
            try {
                Thread.sleep(2000);
                LOGGER.info("\"{}\": {} of {}", message, count, waitLoop);
            } catch (InterruptedException e) {
            }
        }
        LOGGER.info("\"{}\": done", message);
    }
}
