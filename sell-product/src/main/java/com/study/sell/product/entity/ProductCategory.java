package com.study.sell.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 16:17 2020/5/17
 * @Modified By:
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;
    
    private Integer categoryType;

    private Date createTime;
    
    private Date updateTime;
}
