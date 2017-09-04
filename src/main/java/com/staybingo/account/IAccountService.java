package com.staybingo.account;

public interface IAccountService {

    public Account registerNewAccount(AccountRegistration accountRegistration) throws AccountExistsException;

}
