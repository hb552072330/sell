package com.study.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SellEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellEurekaServerApplication.class, args);
    }

}
