package com.study.sell.product.service.impl;

import com.study.sell.product.entity.ProductInfo;
import com.study.sell.product.enums.ProductStarusEnum;
import com.study.sell.product.repository.ProductInfoRepository;
import com.study.sell.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 16:32 2020/5/17
 * @Modified By:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(ProductStarusEnum.UP.getCode());
        return productInfoList;
    }
}
