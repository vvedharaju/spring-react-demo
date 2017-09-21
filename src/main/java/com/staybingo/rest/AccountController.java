package com.staybingo.rest;


import com.staybingo.account.*;
import com.staybingo.util.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/register")
    @ResponseBody
    public AccountEntity registerAccount(@RequestBody AccountRegistration accountRegistration) {
        AccountEntity registeredAccount = accountService.registerNewAccount(accountRegistration);

        if(NullUtils.isNull(registeredAccount)) {
            return null;
        }

        return registeredAccount;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAccount(@RequestBody AccountEntity account) {
        System.out.println("HEREEEE DELETE " + account.getId());
        accountRepository.delete(account);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<AccountEntity> getAccounts() {
        System.out.println("HEREEEE");
        return accountRepository.findAll();
    }

}
