package org.kafka.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.kafka.springboot.config.KafkaConfig;
import org.kafka.springboot.dto.NameTaskBatchDto;
import org.kafka.springboot.dto.NameTaskDto;
import org.kafka.springboot.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/17 14:13
 */
@Component
@Slf4j
public class KafkaReceiver {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = {"zhisheng"})
    public void listen(ConsumerRecord record) {
        Optional kafkaMessage = Optional.ofNullable(record);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }

    /**
     * 分解任务为一批一批的
     */
    @KafkaListener(topics = KafkaConfig.GROUP_ID_SPLIT_PRINT_NAME_TASK, containerFactory = "kafkaListenerContainerFactory")
    public void splitNameTaskListenProcess(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {
        NameTaskDto taskDto = JsonUtil.fromJson(data.value(), NameTaskDto.class);
        int nameNum = taskDto.getNameNum(); // 消息的数量
        int batchNum = 3; // 每一批处理的数量
        while (nameNum > 0) {
            List<String> nameList = new ArrayList<>(batchNum);
            int actualBatch = nameNum > 3 ? batchNum : nameNum;
            for (int i = 0; i < actualBatch; i++) {
                nameList.add(UUID.randomUUID().toString());
            }
            nameNum -= 3;
            NameTaskBatchDto nameTaskBatchDto = new NameTaskBatchDto(taskDto.getBatchId(), nameList);

            ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConfig.GROUP_ID_BATCH_PRINT_NAME_TASK, JsonUtil.toJson(nameTaskBatchDto));
            kafkaTemplate.send(record);
        }
        acknowledgment.acknowledge();
    }

    /**
     * 消费分解后的任务生产的消息
     */
    @KafkaListener(topics = KafkaConfig.GROUP_ID_BATCH_PRINT_NAME_TASK, containerFactory = "kafkaListenerContainerFactory")
    public void nameTaskBatchListenProcess(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {
        NameTaskBatchDto nameTaskBatchDto = JsonUtil.fromJson(data.value(), NameTaskBatchDto.class);
        boolean hasError = false;
        log.info("消费一批数据开始");
        try {
            nameTaskBatchDto.getNameList().stream().forEach(System.out::println);
        } catch (Exception e) {
            log.error("消费一批数据出现异常,{}", JsonUtil.toJson(nameTaskBatchDto));
            log.error(e.getMessage(), e);
        } finally {
            if (hasError) {
                ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConfig.GROUP_ID_SPLIT_PRINT_NAME_TASK, JsonUtil.toJson(nameTaskBatchDto));
                kafkaTemplate.send(record);
                log.info("消费处理失败的消息重推kafka");
            }
        }
        log.info("消费一批数据结束");

        acknowledgment.acknowledge();
    }
}
