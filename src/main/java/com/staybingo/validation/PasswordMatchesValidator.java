package com.staybingo.validation;

import com.staybingo.account.AccountRegistration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        AccountRegistration accountRegistration = (AccountRegistration) obj;
        System.out.println("VEDHAAAAA " + accountRegistration.getPassword() +
                " " + accountRegistration.getMatchingPassword());
        return accountRegistration.getPassword().equals(accountRegistration.getMatchingPassword());
    }
}
