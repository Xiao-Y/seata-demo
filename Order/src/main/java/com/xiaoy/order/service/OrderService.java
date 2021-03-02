package com.xiaoy.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoy.order.dto.Order;

/**
 * @author liuyongtao
 * @since 2021-3-2 11:36
 */
public interface OrderService extends IService<Order> {

    boolean insertOrder(Order order);
}
