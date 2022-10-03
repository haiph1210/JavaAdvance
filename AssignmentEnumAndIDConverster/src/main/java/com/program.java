package com;

import com.entity.Account;
import com.entity.Address;
import com.repository.AccountRepository;
import com.utils.HibernateUtils;

import java.util.List;

public class program {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();

        // Create students
        System.out.println("------------ Create students ------------");
        repository.create(new Account("Nam", Address.HAIPHONG));
        repository.create(new Account("Duyên", Address.HANOI));
        repository.create(new Account("Trung", Address.NINHBINH));
        repository.create(new Account("Giang", Address.HOCHIMINH));

        // Get all students
        System.out.println("------------ Get all students ------------");
        List<Account> accounts = repository.findAll();
        for (Account account : accounts) {
            System.out.println("student = " + account);
        }

        HibernateUtils.closeSeesion();
    }

}
