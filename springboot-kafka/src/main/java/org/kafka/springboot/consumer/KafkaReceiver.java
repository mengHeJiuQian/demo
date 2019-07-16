package org.kafka.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/17 14:13
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"zhisheng"})
    public void listen(ConsumerRecord record) {
        Optional kafkaMessage = Optional.ofNullable(record);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }
}
