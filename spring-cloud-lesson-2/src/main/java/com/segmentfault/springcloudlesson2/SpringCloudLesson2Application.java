package com.segmentfault.springcloudlesson2;

import com.segmentfault.springcloudlesson2.bootstrap.MyPropertySourceLocator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudLesson2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudLesson2Application.class, args);
	}

//	@Bean
//	public MyPropertySourceLocator myPropertySourceLocator() {
//		return new MyPropertySourceLocator();
//	}

}
