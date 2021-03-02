package com.xiaoy.business.feign;

import com.xiaoy.business.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liuyongtao
 * @since 2021-3-2 16:51
 */
@FeignClient(name = "Order-Service")
public interface OrderFeign {

    @PostMapping("/order/insertOrder")
    boolean insertOrder(@RequestBody OrderVo order);
}
