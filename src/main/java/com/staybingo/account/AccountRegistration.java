package com.staybingo.account;

import com.staybingo.validation.PasswordMatches;
import com.staybingo.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@PasswordMatches
public class AccountRegistration {

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

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

    public String getMatchingPassword() {
        return  this.matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

}
