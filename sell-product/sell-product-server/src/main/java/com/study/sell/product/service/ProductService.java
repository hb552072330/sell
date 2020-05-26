package com.study.sell.product.service;

import com.study.sell.product.common.DecreaseStockInput;
import com.study.sell.product.common.ProductInfoOutput;
import com.study.sell.product.dto.CarDTO;
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
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表信息（给订单服务）
     *
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
