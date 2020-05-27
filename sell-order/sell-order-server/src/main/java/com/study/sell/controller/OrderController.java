package com.study.sell.controller;

import com.study.sell.client.ProductClient;
import com.study.sell.convert.OrderForm2OrderDTOConverter;
import com.study.sell.dto.CarDTO;
import com.study.sell.dto.OrderDTO;
import com.study.sell.enums.ResultEnum;
import com.study.sell.exception.OrderException;
import com.study.sell.form.OrderForm;
import com.study.sell.repository.OrderDetailRepository;
import com.study.sell.repository.OrderMasterRepository;
import com.study.sell.service.OrderService;
import com.study.sell.utils.ResultVOUtils;
import com.study.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:41 2020/5/20
 * @Modified By:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1、参数校验
     * 2、查询商品信息（调用商品服务）
     * 3、计算总价
     * 4、扣库存（调用商品服务）
     * 5、订单入库
     */
    @PostMapping("create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PRAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CAR_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtils.success(map);
    }
}
