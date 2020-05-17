package com.study.sell.product.repository;

import com.study.sell.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 16:21 2020/5/17
 * @Modified By:
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);
}
