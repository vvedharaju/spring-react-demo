package com.staybingo.account;

import com.staybingo.hibernate.account.IAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IAccountDAO IAccountDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = IAccountDAO.findByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException(
                    "No user found with email: "+ email);
        }
        // TODO: figure out roles

        return new User(account.getEmail(), account.getPassword(), Collections.emptyList());
    }

}
