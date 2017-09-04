package com.staybingo.rest;


import com.staybingo.account.Account;
import com.staybingo.account.AccountRegistration;
import com.staybingo.account.AccountService;
import com.staybingo.account.IAccountService;
import com.staybingo.hibernate.account.IAccountDAO;
import com.staybingo.util.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Supplier;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @RequestMapping("/register")
    @ResponseBody
    public Account registerAccount(@RequestBody AccountRegistration accountRegistration) {
        Account registeredAccount = accountService.registerNewAccount(accountRegistration);

        if(NullUtils.isNull(registeredAccount)) {
            return null;
        }

        return registeredAccount;
    }

}
