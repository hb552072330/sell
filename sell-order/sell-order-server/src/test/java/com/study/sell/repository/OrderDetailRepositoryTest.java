package com.study.sell.repository;

import com.study.sell.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 19:53 2020/5/20
 * @Modified By:
 */
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("111");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(12));
        orderDetail.setProductIcon("http://xxxxx");
        orderDetail.setProductQuantity(1);
        orderDetail.setOrderId("123");
        OrderDetail save = orderDetailRepository.save(orderDetail);
        Assert.isTrue(save.getDetailId() != null );
    }
}