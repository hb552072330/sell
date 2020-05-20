package com.study.sell.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:29 2020/5/20
 * @Modified By:
 */
@Component
public class RestTemplatConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
