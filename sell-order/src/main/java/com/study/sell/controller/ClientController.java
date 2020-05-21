package com.study.sell.controller;

import com.study.sell.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:15 2020/5/20
 * @Modified By:
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //第一种方式，直接用restTemplate，url写死
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8500/msg", String.class);
        //第二种方式，利用loadBalancerClient获取url，在用restTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s/msg",serviceInstance.getHost(), serviceInstance.getPort());
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        //第三种方式
//        String response = restTemplate.getForObject("http://product/msg", String.class);
//        String response = productClient.getProductMsg();
        log.info("response={}", response);
        return response;
    }

}
