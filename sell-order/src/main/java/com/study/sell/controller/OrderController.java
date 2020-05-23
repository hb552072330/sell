package com.study.sell.controller;

import com.study.sell.client.ProductClient;
import com.study.sell.dto.OrderDTO;
import com.study.sell.repository.OrderDetailRepository;
import com.study.sell.repository.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:41 2020/5/20
 * @Modified By:
 */
@RestController
public class OrderController {



    /**
     * 1、参数校验
     * 2、查询商品信息（调用商品服务）
     * 3、计算总价
     * 4、扣库存（调用商品服务）
     * 5、订单入库
     */
    public void create(OrderDTO orderDTO){

    }
}
