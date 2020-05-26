package com.study.sell.service.impl;

import com.study.sell.dto.CarDTO;
import com.study.sell.dto.OrderDTO;
import com.study.sell.dto.ProductInfo;
import com.study.sell.entity.OrderDetail;
import com.study.sell.entity.OrderMaster;
import com.study.sell.enums.OrderStatusEnum;
import com.study.sell.enums.PayStatusEnum;
import com.study.sell.product.client.ProductClient;
import com.study.sell.product.common.DecreaseStockInput;
import com.study.sell.product.common.ProductInfoOutput;
import com.study.sell.repository.OrderDetailRepository;
import com.study.sell.repository.OrderMasterRepository;
import com.study.sell.service.OrderService;
import com.study.sell.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:52 2020/5/20
 * @Modified By:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
//    private ProductClient productClient;
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.genUniqueKey();
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        BigDecimal orderAmout = BigDecimal.ZERO;
        //计算总价
        Map<String, ProductInfoOutput> productInfoMap = productInfoList.stream().collect(Collectors.toMap(ProductInfoOutput::getProductId, ProductInfoOutput -> ProductInfoOutput));
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfoOutput productInfo = productInfoMap.get(orderDetail.getProductId());
            orderAmout = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmout);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            orderDetailRepository.save(orderDetail);
        }
        //扣除库存
        List<DecreaseStockInput> carDTOList = orderDTO.getOrderDetailList().stream().map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(carDTOList);
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
