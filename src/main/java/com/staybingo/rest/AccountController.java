package com.staybingo.rest;


import com.staybingo.account.AccountRegistration;
import com.staybingo.account.IAccountService;
import com.staybingo.account.AccountEntity;
import com.staybingo.util.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @RequestMapping("/register")
    @ResponseBody
    public AccountEntity registerAccount(@RequestBody AccountRegistration accountRegistration) {
        AccountEntity registeredAccount = accountService.registerNewAccount(accountRegistration);

        if(NullUtils.isNull(registeredAccount)) {
            return null;
        }

        return registeredAccount;
    }

}
