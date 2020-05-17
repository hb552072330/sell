package com.study.sell.product.service.impl;

import com.study.sell.product.entity.ProductCategory;
import com.study.sell.product.service.ProductCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 17:17 2020/5/17
 * @Modified By:
 */
@SpringBootTest
class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(Arrays.asList(11, 12));
        Assert.isTrue(productCategoryList.size() > 0);
    }
}