package com.study.sell.product.service.impl;

import com.study.sell.product.common.DecreaseStockInput;
import com.study.sell.product.common.ProductInfoOutput;
import com.study.sell.product.dto.CarDTO;
import com.study.sell.product.entity.ProductInfo;
import com.study.sell.product.enums.ProductStarusEnum;
import com.study.sell.product.exception.ProductException;
import com.study.sell.product.exception.ResultEnum;
import com.study.sell.product.repository.ProductInfoRepository;
import com.study.sell.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(productIdList);
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e, productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        return productInfoOutputList;
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            //商品不足
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
