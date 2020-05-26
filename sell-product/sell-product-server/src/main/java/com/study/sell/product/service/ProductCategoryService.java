package com.study.sell.product.service;

import com.study.sell.product.entity.ProductCategory;

import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 17:13 2020/5/17
 * @Modified By:
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
