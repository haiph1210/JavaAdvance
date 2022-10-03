//package com.entity;
//
//import com.repository.AccountRepository;
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//import java.io.Serializable;
//
//public class AccountIDConverter implements IdentifierGenerator {
//    private final AccountRepository repository = new AccountRepository();
//    @Override
//    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
//        Account account = (Account) o;
//        Address address = account.getAddress();
//        long count = repository.countbyAddress(address);
//
//        return String.format("%c-%d",address.getAddress(),count+1) ;
//    }
//}
