package com.codenotfound.artemis.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codenotfound.artemis.kafka.EdigasInQueue;
import com.codenotfound.artemis.producer.Sender;

@RestController
public class MessagingRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingRestController.class);

    @Autowired
    private Sender sender;

    @Autowired
    private EdigasInQueue queue;

    @PostMapping("/send/{id}/{message}")
    public String sendMessage(@PathVariable String id, @PathVariable String message) {
        LOGGER.info("Sending message {} with id {}...", message, id);
        sender.send(queue, message, id);
        return "done";
    }

    @PostMapping("/sendBulk/{messagePrefix}")
    public String sendBulkMessages(@PathVariable String messagePrefix) {
        int amount = 10;
        LOGGER.info("Sending {} bulk messages of id 0...4 and prefix {}", amount, messagePrefix);
        for (int i = 0; i < amount; i++) {
            String id = String.valueOf(i % 5);
            sender.send(queue, messagePrefix + "#" + id + "." + ((i / 5) + 1), id);
        }
        return "done";
    }
}
