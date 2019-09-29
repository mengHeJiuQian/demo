package com.forezp.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: sheldon
 * @Create Date: 2019/9/29 11:23
 * @Update Date: 2019/9/29 11:23
 */
@EnableTurbine
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableEurekaClient
@RestController
@SpringBootApplication
public class ServiceTurbineApplication {

    /**
     * http://localhost:8764/turbine.stream
     */

    public static void main(String[] args) {
        SpringApplication.run( ServiceTurbineApplication.class, args );
    }

}
