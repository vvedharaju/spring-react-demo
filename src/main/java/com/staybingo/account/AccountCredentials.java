package com.staybingo.account;

import com.staybingo.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class AccountCredentials {

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    public String getEmail() {
        return  this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return  this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}