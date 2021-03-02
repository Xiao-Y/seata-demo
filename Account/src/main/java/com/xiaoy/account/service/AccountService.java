package com.xiaoy.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoy.account.dto.Account;

/**
 * @author liuyongtao
 * @since 2021-3-2 11:36
 */
public interface AccountService extends IService<Account> {

    boolean subAccount(String userId, Integer money);

}
