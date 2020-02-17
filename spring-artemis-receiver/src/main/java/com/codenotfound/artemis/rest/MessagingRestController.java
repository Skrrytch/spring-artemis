package com.codenotfound.artemis.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingRestController.class);

    //    @Autowired
    //    private ConsumerFactory<String, String> consumerFactory;
    //
    //    @Autowired
    //    private KafkaListenerEndpointRegistry registry;
    //
    //    @PostMapping("/consumers/pause")
    //    public void pauseTopic() {
    //        String topic = QueueOfIncomingEdigas.NAME;
    //        LOGGER.info("Pausing all consumers for topic {} ...", topic);
    //        MessageListenerContainer container = registry.getListenerContainer(QueueOfIncomingEdigas.NAME);
    //        if (container != null) {
    //            if (container.isContainerPaused()) {
    //                LOGGER.info("Pause already active for {}", topic);
    //            } else if (container.isPauseRequested()) {
    //                LOGGER.info("Pause already requested for {}", topic);
    //            } else {
    //                container.pause();
    //                LOGGER.info("Pause for {} requested", topic);
    //            }
    //        } else {
    //            LOGGER.error("No container found for  topic {}", topic);
    //        }
    //    }
    //
    //    @PostMapping("/consumers/resume")
    //    public void resumeTopic() {
    //        String topic = QueueOfIncomingEdigas.NAME;
    //        LOGGER.info("Resuming all consumers for topic {} ...", topic);
    //        MessageListenerContainer container = registry.getListenerContainer(topic);
    //        if (container != null) {
    //            if (container.isContainerPaused() || container.isPauseRequested()) {
    //                container.resume();
    //                LOGGER.info("Resume for {} requested!", topic);
    //            } else {
    //                LOGGER.info("Not paused or requested for {}", topic);
    //            }
    //        } else {
    //            LOGGER.info("No container found for topic {}", topic);
    //        }
    //    }
    //
    //    @GetMapping("/status")
    //    public KafkaStatus getStatus() {
    //        List<TopicStatus> topics = new ArrayList<>();
    //
    //        try (Consumer<String, String> consumer = consumerFactory.createConsumer()) {
    //            Map<String, List<PartitionInfo>> map = consumer.listTopics();
    //            for (Map.Entry<String, List<PartitionInfo>> entry : map.entrySet()) {
    //                String topicName = entry.getKey();
    //                MessageListenerContainer container = registry.getListenerContainer(QueueOfIncomingEdigas.NAME);
    //                Collection<TopicPartition> assignedPartitions = container.getAssignedPartitions();
    //                List<PartitionStatus> partitions = new ArrayList<>();
    //                for (TopicPartition partition : assignedPartitions) {
    //                    partitions.add(new PartitionStatus(partition));
    //                }
    //                Collections.sort(partitions);
    //                topics.add(new TopicStatus(topicName, partitions, container));
    //            }
    //        }
    //
    //        return new KafkaStatus(topics);
    //    }
}
