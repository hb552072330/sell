package com.study.sell.product.exception;

import lombok.Getter;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:37 2020/5/22
 * @Modified By:
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
