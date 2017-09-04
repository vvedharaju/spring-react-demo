package com.staybingo.account;

import com.staybingo.validation.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

public class Account {

    private String id;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    public String getId() { return this.id; }

    public void setId(String id) {
        this.id = id;
    }

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
