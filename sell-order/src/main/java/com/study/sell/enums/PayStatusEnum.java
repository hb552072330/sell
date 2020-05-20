package com.study.sell.enums;

import lombok.Getter;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:31 2020/5/20
 * @Modified By:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付完成"),
    ;

    private Integer code;

    private String name;

    PayStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
