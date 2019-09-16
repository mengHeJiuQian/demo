package com.segmentfault.springcloudlesson3configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudLesson3ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLesson3ConfigServerApplication.class, args);
		// System.out.println(System.getProperty("user.dir"));
	}

}
