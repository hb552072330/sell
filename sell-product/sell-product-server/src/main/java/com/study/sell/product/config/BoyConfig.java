package com.study.sell.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 21:16 2020/8/15
 * @Modified By:
 */
@Data
@Component
@ConfigurationProperties("boy")
@RefreshScope
public class BoyConfig {
    private String name;
    private Integer age;
}
