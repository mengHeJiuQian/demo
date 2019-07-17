package org.kafka.springboot.controller;

import org.kafka.springboot.constant.ResponseMessage;
import org.kafka.springboot.dto.NameTaskDto;
import org.kafka.springboot.producer.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/16 22:40
 * 版本：1.0
 * 内容描述：批量生成消息，推送给kafka
 */
@RestController
@RequestMapping("/batchName")
public class BatchNameController {

    @Autowired
    private KafkaSender kafkaSender;

    @RequestMapping(value = "/produce", method = RequestMethod.GET)
    public String batchNameProduce(int num) {
        String batchId = UUID.randomUUID().toString();
        NameTaskDto taskDto = new NameTaskDto(batchId, num);
        kafkaSender.splitNameTask(taskDto);
        return ResponseMessage.OK;
    }

}
