package com.staybingo.config.spring;

import com.staybingo.hibernate.account.AccountEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class DatasourceConfiguration {

    @Bean
    public DataSource dataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/staybingo");
        dataSource.setUsername("vedha");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "validate");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");

        return properties;

    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.addProperties(getHibernateProperties());
        sessionFactoryBuilder.addAnnotatedClass(AccountEntity.class);
        return sessionFactoryBuilder.buildSessionFactory();
    }

    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }


}
