package com.staybingo.account;

import com.staybingo.common.repositories.BaseCRUDRepository;

public interface AccountRepository extends BaseCRUDRepository<AccountEntity, String> {

    public AccountEntity findByEmail(String email);

}
