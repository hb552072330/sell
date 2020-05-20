package com.study.sell.service;

import com.study.sell.dto.OrderDTO;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:47 2020/5/20
 * @Modified By:
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
