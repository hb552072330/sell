package com.study.sell.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:39 2020/5/21
 * @Modified By:
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String getProductMsg();
}
