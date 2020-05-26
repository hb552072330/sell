package com.study.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.study.sell.product.client", "com.study.sell.client"})
public class SellOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellOrderApplication.class, args);
    }

}
