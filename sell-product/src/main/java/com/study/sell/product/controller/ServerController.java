package com.study.sell.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:13 2020/5/20
 * @Modified By:
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is a product message!";
    }
}
