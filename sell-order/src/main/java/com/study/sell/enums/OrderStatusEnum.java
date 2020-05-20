package com.study.sell.enums;

import lombok.Getter;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 20:31 2020/5/20
 * @Modified By:
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    
    private Integer code;
    
    private String name;

    OrderStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
