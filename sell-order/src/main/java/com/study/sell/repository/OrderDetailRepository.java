package com.study.sell.repository;

import com.study.sell.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 23:46 2020/5/18
 * @Modified By:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
