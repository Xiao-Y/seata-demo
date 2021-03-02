package com.xiaoy.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoy.storage.dto.Storage;

/**
 * @author liuyongtao
 * @since 2021-3-2 11:36
 */
public interface StorageService extends IService<Storage> {

    boolean subStorage(String commodityCode, Integer count);

}
