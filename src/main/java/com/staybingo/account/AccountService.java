package com.staybingo.account;

import com.staybingo.hibernate.account.AccountEntity;
import com.staybingo.hibernate.account.AccountRepository;
import com.staybingo.hibernate.account.IAccountDAO;
import com.staybingo.util.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public AccountEntity registerNewAccount(AccountRegistration accountRegistration) throws AccountExistsException{
        if (emailExists(accountRegistration.getEmail())) {
            throw new AccountExistsException("There is already an account with that email address: " +
                accountRegistration.getEmail());
        }

        // TODO: bcrypt rest of registration process
        return accountRepository.save(convertToAccount(accountRegistration));
    }

    private boolean emailExists(String email) {
        AccountEntity account = accountRepository.findByEmail(email);
        return NullUtils.isNotNull(account);
    }

    private AccountEntity convertToAccount(AccountRegistration accountRegistration) {
        AccountEntity account = new AccountEntity();
        account.setEmail(accountRegistration.getEmail());
        account.setPassword(passwordEncoder.encode(accountRegistration.getPassword()));
        return  account;
    }

}
