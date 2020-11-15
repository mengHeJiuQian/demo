package org.kafka.springboot;

import org.kafka.springboot.producer.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * describe:
 *
 * https://blog.csdn.net/a15835774652/article/details/81363164
 * kafka通过节点名去查找服务器，所以要配置服务端的 advertised.listeners=PLAINTEXT://izuf660km9nbcwquzfy6yiz:9092
 * 本地也要配置服务端的ip和机器名映射
 *
 * @author 梦合九千
 * @date 2019/5/17 14:21
 */
@EnableAutoConfiguration(exclude = {KafkaAutoConfiguration.class})
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

}
