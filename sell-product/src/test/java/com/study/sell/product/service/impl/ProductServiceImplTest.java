package com.study.sell.product.service.impl;

import com.study.sell.product.dto.CarDTO;
import com.study.sell.product.entity.ProductInfo;
import com.study.sell.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:07 2020/5/22
 * @Modified By:
 */
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void listForOrder() {
        List<ProductInfo> productInfos = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.isTrue(productInfos.size() > 0);
    }

    @Test
    void decreaseStock() {
        CarDTO carDTO = new CarDTO("157875196366160022", 2);
        productService.decreaseStock(Arrays.asList(carDTO));
    }
}