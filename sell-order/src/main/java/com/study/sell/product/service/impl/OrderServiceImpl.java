package com.study.sell.product.service.impl;

import com.study.sell.dto.OrderDTO;
import com.study.sell.entity.OrderMaster;
import com.study.sell.enums.OrderStatusEnum;
import com.study.sell.enums.PayStatusEnum;
import com.study.sell.repository.OrderDetailRepository;
import com.study.sell.repository.OrderMasterRepository;
import com.study.sell.service.OrderService;
import com.study.sell.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:52 2020/5/20
 * @Modified By:
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(new BigDecimal(0.3));
        orderMaster.setOrderId(KeyUtils.genUniqueKey());
        orderMasterRepository.save(orderMaster);
        orderDTO.setOrderId(orderMaster.getOrderId());
        return orderDTO;
    }
}
