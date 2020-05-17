package com.study.sell.product.service;

import com.study.sell.product.entity.ProductInfo;

import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 16:31 2020/5/17
 * @Modified By:
 */
public interface ProductService {

    /**
     * 查询所有的上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

}
