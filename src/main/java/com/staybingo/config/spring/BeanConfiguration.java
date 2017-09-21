package com.staybingo.config.spring;

import com.staybingo.account.AccountService;
import com.staybingo.account.IAccountService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }

    @Bean
    public IAccountService accountService() {
        return new AccountService();
    }

}
