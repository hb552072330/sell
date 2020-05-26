package com.study.sell.product.vo;

import lombok.Data;

/**
 * @Author: zhanghongbing
 * @Description: HTTP请求返回最外层对象
 * @Date: Create in 17:21 2020/5/17
 * @Modified By:
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T data;
}
