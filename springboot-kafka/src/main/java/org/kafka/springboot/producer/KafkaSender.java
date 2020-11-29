package org.kafka.springboot.producer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.kafka.springboot.beans.Message;
import org.kafka.springboot.config.KafkaConfig;
import org.kafka.springboot.dto.NameTaskDto;
import org.kafka.springboot.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/17 14:06
 */
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("zhisheng", gson.toJson(message));
    }

    public void splitNameTask(NameTaskDto taskDto) {
        ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConfig.GROUP_ID_SPLIT_PRINT_NAME_TASK,
                JsonUtil.toJson(taskDto));
        kafkaTemplate.send(record);
    }
}
