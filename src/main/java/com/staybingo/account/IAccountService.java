package com.staybingo.account;

import org.springframework.stereotype.Service;

@Service
public interface IAccountService {

    public AccountEntity registerNewAccount(AccountRegistration accountRegistration) throws AccountExistsException;

}
