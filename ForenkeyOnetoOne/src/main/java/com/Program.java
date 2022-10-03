package com;



import com.entity.Account;
import com.entity.Group;
import com.repository.AccountRepository;
import com.repository.GroupRepository;
import com.utils.HibernateUtils;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        AccountRepository sRepository = new AccountRepository();
        GroupRepository gRepository = new GroupRepository();

        // Create groups
        System.out.println("------------ Create groups ------------");
        gRepository.create(new Group("SQL"));
        gRepository.create(new Group("Java Basic"));
        gRepository.create(new Group("Front end"));
        gRepository.create(new Group("Java Advanced"));

        // Create students
        System.out.println("------------ Create students ------------");
        sRepository.create(new Account("Nam", new Group(1)));
        sRepository.create(new Account("Hùng", new Group(2)));
        sRepository.create(new Account("Cường", new Group(3)));
        sRepository.create(new Account("Duy", new Group(4)));
        // sRepository.create(new Student("Hải", new Group(4)));

        // Get all groups
        System.out.println("------------ Get all groups ------------");
        List<Group> groups = gRepository.getAll();
        for (Group group : groups) {
            System.out.println("group = " + group);
        }

        // Get all students
        System.out.println("------------ Get all students ------------");
        List<Account> accounts = sRepository.findAll();
        for (Account account : accounts) {
            System.out.println("student = " + account);
        }

        HibernateUtils.closeSeesion();
    }
}