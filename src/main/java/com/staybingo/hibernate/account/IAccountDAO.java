package com.staybingo.hibernate.account;

import com.staybingo.account.Account;

public interface IAccountDAO {

    public Account insert(Account account);
    public Account findByEmail(String email);

}
