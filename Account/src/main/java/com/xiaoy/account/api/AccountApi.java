package com.xiaoy.account.api;

import com.xiaoy.account.dto.Account;
import com.xiaoy.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyongtao
 * @since 2021-3-2 11:36
 */
@RestController
public class AccountApi {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") Long id) {
        return accountService.getById(id);
//        return new Account();
    }

    @PostMapping("/subAccount/{userId}")
    public boolean subAccount(@PathVariable("userId") String userId, @RequestParam("money") Integer money) {
        return accountService.subAccount(userId, money);
    }

    @PostMapping("/addAccount/{userId}")
    public boolean addAccount(@PathVariable("userId") String userId, @RequestParam("money") Integer money) {
        accountService.addAccount(userId, money);
        return true;
    }
}
