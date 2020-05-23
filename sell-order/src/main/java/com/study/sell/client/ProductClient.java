package com.study.sell.client;

import com.study.sell.dto.CarDTO;
import com.study.sell.dto.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:39 2020/5/21
 * @Modified By:
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String getProductMsg();

    @PostMapping("/product/orderList")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CarDTO> carDTOList);
}
