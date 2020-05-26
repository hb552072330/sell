package com.study.sell.product.enums;

import lombok.Getter;

/**
 * @Author: zhanghongbing
 * @Description: 商品上下架状态
 * @Date: Create in 16:35 2020/5/17
 * @Modified By:
 */
@Getter
public enum ProductStarusEnum {
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;
    private Integer code;
    private String name;

    ProductStarusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
