package com.xiaoy.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoy.storage.dao.StorageDao;
import com.xiaoy.storage.dto.Storage;
import com.xiaoy.storage.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liuyongtao
 * @since 2021-3-2 15:57
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {

    @Override
    @Transactional
    public boolean subStorage(String commodityCode, Integer count) {
        LambdaQueryWrapper<Storage> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Storage::getCommodityCode, commodityCode);
        List<Storage> list = this.list(wrapper);

        Storage storage = list.get(0);
        Integer c = storage.getCount() - count;
        if (c < 0) {
            throw new RuntimeException("库存不不足！！！");
        }
        storage.setCount(c);
        this.updateById(storage);
        return true;
    }
}
