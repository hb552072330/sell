package com.study.sell.dto;

import com.study.sell.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:49 2020/5/20
 * @Modified By:
 */
@Data
public class OrderDTO {
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为新下单 */
    private Integer orderStatus;

    /** 支付状态, 默认未支付 */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
