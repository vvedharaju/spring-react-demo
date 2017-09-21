package com.staybingo.account;

import com.staybingo.hibernate.account.AccountEntity;

public interface IAccountService {

    public AccountEntity registerNewAccount(AccountRegistration accountRegistration) throws AccountExistsException;

}
