package com.staybingo.hibernate.account;

import com.staybingo.account.Account;
import org.dozer.Mapper;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDAOImpl implements IAccountDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    Mapper mapper;

    public Account insert(Account account) {
        AccountEntity ae = mapper.map(account, AccountEntity.class);
        String id = (String) sessionFactory.getCurrentSession().save(ae);
        account.setId(id);
        return account;
    }

    public Account findByEmail(String email) {
        String hql = "from AccountEntity a where a.email = :email";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("email",email);

        if (query.list().isEmpty()) {
            return null;
        }

        return mapper.map(query.list().get(0), Account.class);
    };

}
