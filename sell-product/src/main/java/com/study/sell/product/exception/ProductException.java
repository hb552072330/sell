package com.study.sell.product.exception;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:35 2020/5/22
 * @Modified By:
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
