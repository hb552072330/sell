package com.study.sell.product.service.impl;

import com.study.sell.product.entity.ProductCategory;
import com.study.sell.product.repository.ProductCategoryRepository;
import com.study.sell.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 17:16 2020/5/17
 * @Modified By:
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
