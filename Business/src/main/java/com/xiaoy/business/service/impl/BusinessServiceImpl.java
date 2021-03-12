package com.xiaoy.business.service.impl;

import com.xiaoy.business.feign.OrderFeign;
import com.xiaoy.business.feign.StorageFeign;
import com.xiaoy.business.service.BusinessService;
import com.xiaoy.business.vo.OrderVo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyongtao
 * @since 2021-3-2 17:02
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private StorageFeign storageFeign;

    @Override
    @GlobalTransactional
    public boolean business(OrderVo orderVo) {
        orderFeign.insertOrder(orderVo);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        storageFeign.subStorage(orderVo.getCommodityCode(), orderVo.getCount());
        return true;
    }
}
