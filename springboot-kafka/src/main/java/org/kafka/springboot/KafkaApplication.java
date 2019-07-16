package org.kafka.springboot;

import org.kafka.springboot.producer.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);
        for (int i = 0; i < 3; i++) {
            //调用消息发送类中的消息发送方法
            sender.send();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
