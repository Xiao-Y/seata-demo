package com.xiaoy.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoy.account.dao.AccountDao;
import com.xiaoy.account.dto.Account;
import com.xiaoy.account.service.AccountService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liuyongtao
 * @since 2021-3-2 15:57
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public boolean subAccount(String userId, Integer money) {
        LambdaQueryWrapper<Account> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Account::getUserId, userId);
        List<Account> accounts = accountDao.selectList(wrapper);

//        for (Account account : accounts) {
//            Integer m = account.getMoney() - money;
//            account.setMoney(m);
//            this.updateById(account);
//        }

        Account account = accounts.get(0);
        Integer m = account.getMoney() - money;
        if (m < 0) {
            throw new RuntimeException("余额不足！！");
        }
        account.setMoney(m);
        this.updateById(account);
        return true;
    }

    @Override
    @GlobalTransactional
    public boolean addAccount(String userId, Integer money) {
        LambdaQueryWrapper<Account> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Account::getUserId, userId);
        List<Account> accounts = accountDao.selectList(wrapper);
        Account account = accounts.get(0);
        account.setMoney(account.getMoney() + money);
        this.updateById(account);
        return true;
    }
}
