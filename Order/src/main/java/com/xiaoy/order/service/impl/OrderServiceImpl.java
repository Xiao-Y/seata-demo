package com.xiaoy.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoy.order.dao.OrderDao;
import com.xiaoy.order.dto.Order;
import com.xiaoy.order.feign.AccountFeign;
import com.xiaoy.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuyongtao
 * @since 2021-3-2 15:57
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountFeign accountFeign;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertOrder(Order order) {
        orderDao.insert(order);
        accountFeign.subAccount(order.getUserId(), order.getMoney());
        return true;
    }
}
