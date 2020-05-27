package com.study.sell.repository;

import com.study.sell.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhanghongbing
 * @Description:
 * @Date: Create in 23:44 2020/5/18
 * @Modified By:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
