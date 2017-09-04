package com.staybingo.account;

import com.staybingo.hibernate.account.IAccountDAO;
import com.staybingo.util.NullUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService implements IAccountService{

    @Autowired
    IAccountDAO IAccountDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public Account registerNewAccount(AccountRegistration accountRegistration) throws AccountExistsException{
        if (emailExists(accountRegistration.getEmail())) {
            throw new AccountExistsException("There is already an account with that email address: " +
                accountRegistration.getEmail());
        }

        // TODO: bcrypt rest of registration process
        return IAccountDAO.insert(convertToAccount(accountRegistration));
    }

    private boolean emailExists(String email) {
        Account account = IAccountDAO.findByEmail(email);
        return NullUtils.isNotNull(account);
    }

    private Account convertToAccount(AccountRegistration accountRegistration) {
        Account account = new Account();
        account.setEmail(accountRegistration.getEmail());
        account.setPassword(passwordEncoder.encode(accountRegistration.getPassword()));
        return  account;
    }

}
