package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specsification.DepartmentSpecification;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    IDepartmentRepository departmentRepository;

    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Department> findAll(Pageable pageable, DepartmentFilterForm form) {
        Specification<Department> specification = DepartmentSpecification.buildWhere(form);
        return departmentRepository.findAll(specification,pageable);
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @SneakyThrows
    @Override
    @Transactional
    public void create(DepartmentCreateForm form) {
        // TODO neu nguoi ta muon truyen vao account da co san trong He thong thi sao??
        Department department = mapper.map(form, Department.class);
        List<Account> accounts = department.getAccounts();
        if (accounts == null || accounts.isEmpty()) {
            // neu k co acc nao, thi se return luon
            throw new Exception("Phong ban nay dang khong co account nao!");
        }
        for (Account account : accounts) {
            account.setDepartment(department);
        }
        Integer idMax = accounts.size();
        System.out.println(idMax);
        department.setTotalMembers(Double.valueOf(idMax));
        departmentRepository.save(department);

        accountRepository.saveAll(accounts);



    }

    @Override
    public void update(DepartmentUpdateForm form) {
        Department department = mapper.map(form, Department.class);
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
