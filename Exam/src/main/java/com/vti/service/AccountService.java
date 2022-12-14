package com.vti.service;

import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountFilterForm;
import com.vti.form.AccountUpdateForm;
import com.vti.repository.IAccountRepository;
import com.vti.specsification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public Page<Account> findAll(Pageable pageable, AccountFilterForm form){
        Specification<Account> specification = AccountSpecification.buildWhere(form);
       return repository.findAll(specification,pageable);
    }

    @Override
    public Account findById(Integer id){
        return repository.findById(id).orElse(null);
    }
    @Override
    public Account findByUsername(String username){
        return repository.findByUsername(username);
    }
    @Override
    public void create(AccountCreateForm form){
        Account account = mapper.map(form,Account.class);
        repository.save(account);
    }
    @Override
    public void update(AccountUpdateForm form){
        Account account = mapper.map(form,Account.class);
        repository.save(account);
    }
    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
