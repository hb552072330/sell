package com.study.sell.product.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:29 2020/5/22
 * @Modified By:
 */
@Data
public class DecreaseStockInput {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    @JsonCreator
    public DecreaseStockInput(/* String productId, Integer productQuantity){*/
            @JsonProperty("productId") String productId,
            @JsonProperty("productQuantity") Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
