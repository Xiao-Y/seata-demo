package com.xiaoy.storage.api;

import com.xiaoy.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyongtao
 * @since 2021-3-2 11:36
 */
@RestController
public class StorageApi {

    @Autowired
    private StorageService storageService;

    @PostMapping("/subStorage/{commodityCode}")
    public boolean subStorage(@PathVariable("commodityCode") String commodityCode, @RequestParam("count") Integer count) {
        return storageService.subStorage(commodityCode, count);
    }

}
