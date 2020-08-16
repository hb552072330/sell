package com.study.sell.product.controller;

import com.study.sell.product.config.BoyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:55 2020/8/15
 * @Modified By:
 */
@RestController
@RequestMapping("/boy")
public class BoyController {

    @Autowired
    private BoyConfig boyConfig;

    @GetMapping("/print")
    public String print(){
        return "name:" + boyConfig.getName() + "   age: " + boyConfig.getAge();
    }
}
