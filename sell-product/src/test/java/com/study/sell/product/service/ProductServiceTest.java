package com.study.sell.product.service;

import com.study.sell.product.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 16:40 2020/5/17
 * @Modified By:
 */
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.isTrue(productInfoList.size() > 0);
    }
}