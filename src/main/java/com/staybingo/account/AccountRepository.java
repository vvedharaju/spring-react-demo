package com.staybingo.account;

import com.staybingo.common.repositories.BaseCRUDRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends BaseCRUDRepository<AccountEntity, Integer> {

    public AccountEntity findByEmail(String email);

    public List<AccountEntity> findAll();

}
