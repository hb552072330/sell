package com.study.sell.repository;

import com.study.sell.entity.OrderMaster;
import com.study.sell.enums.OrderStatusEnum;
import com.study.sell.enums.PayStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:13 2020/5/20
 * @Modified By:
 */
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("北京");
        orderMaster.setBuyerName("黑");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setOrderAmount(new BigDecimal(12));
        orderMaster.setOrderId("123");
        orderMaster.setBuyerOpenid("openid");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster master = orderMasterRepository.save(orderMaster);
        Assert.isTrue(master != null);
    }

}