package com.study.sell.exception;

import com.study.sell.enums.ResultEnum;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 22:06 2020/5/26
 * @Modified By:
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
