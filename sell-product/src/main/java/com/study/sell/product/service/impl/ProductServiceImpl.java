package com.study.sell.product.service.impl;

import com.study.sell.product.dto.CarDTO;
import com.study.sell.product.entity.ProductInfo;
import com.study.sell.product.enums.ProductStarusEnum;
import com.study.sell.product.exception.ProductException;
import com.study.sell.product.exception.ResultEnum;
import com.study.sell.product.repository.ProductInfoRepository;
import com.study.sell.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<CarDTO> carDTOList) {
        for (CarDTO carDTO : carDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(carDTO.getProductId());
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - carDTO.getProductQuantity();
            //商品不足
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
