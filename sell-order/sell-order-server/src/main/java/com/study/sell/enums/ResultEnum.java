package com.study.sell.enums;

import lombok.Getter;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 22:02 2020/5/26
 * @Modified By:
 */
@Getter
public enum ResultEnum {
    PRAM_ERROR(1, "参数错误"),
    CAR_EMPTY(2, "购物车为空")
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
