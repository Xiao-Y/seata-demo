package com.xiaoy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liuyongtao
 * @since 2021-3-2 16:51
 */
@FeignClient(name = "Account-Service")
public interface AccountFeign {

    @PostMapping("/account/subAccount/{userId}")
    boolean subAccount(@PathVariable("userId") String userId, @RequestParam("money") Integer money);
}
