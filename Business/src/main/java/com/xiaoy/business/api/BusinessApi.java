package com.xiaoy.business.api;

import com.xiaoy.business.service.BusinessService;
import com.xiaoy.business.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyongtao
 * @since 2021-3-2 16:58
 */
@RestController
@RequestMapping("/business")
public class BusinessApi {

    @Autowired
    private BusinessService businessService;

    @PostMapping
    public boolean business(@RequestBody OrderVo orderVo) {
        return businessService.business(orderVo);
    }
}
