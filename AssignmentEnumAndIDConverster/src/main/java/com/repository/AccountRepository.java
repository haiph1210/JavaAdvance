package com.repository;

import com.entity.Account;
import com.entity.Address;
import com.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class AccountRepository {
    public List<Account> findAll(){
        try(Session session = HibernateUtils.openSeesion()) {
            String hql = "From Account";
           return session.createQuery(hql,Account.class).getResultList();
        }
    }

    public void create(Account account){
        try(Session session = HibernateUtils.openSeesion()) {
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
        }
    }

    public long countbyAddress(Address address){
        try (Session session = HibernateUtils.openSeesion()) {
        String hql = "Select Count(address) From Account Where address =: address";
       return session.createQuery(hql, Long.class).setParameter("address",address).uniqueResult();
        }
    }
}
