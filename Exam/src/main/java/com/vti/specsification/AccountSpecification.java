package com.vti.specsification;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.AccountFilterForm;
import com.vti.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class AccountSpecification   {
    public static Specification<Account> buildWhere(AccountFilterForm form){
            if (form == null){
                return null;
            }
            return hasUsernameLike(form.getSearch()).or(hasDepartmentNameLike(form.getSearch())
                    .and(hasIdMaxGreaterThanOrEqualTo(form.getIdMax())
                            .and(hasIdMinLessThanOrEqualTo(form.getIdMin())

                            ))
            );

    }
    private static Specification<Account> hasUsernameLike(String search){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (!StringUtils.hasText(search)){
                    return null;
                }
                return builder.like(root.get("username"),"%"+ search.trim() + "%");
            }
        };
    }
    //so sánh filter
    private static Specification<Account> hasDepartmentNameLike(String search){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (!StringUtils.hasText(search)){
                    return null;
                }
                return builder.like(root.get("department").get("name"),"%"+ search.trim() + "%");
            }
        };
    }

    private static Specification<Account> hasIdMinLessThanOrEqualTo(Integer idMin){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (idMin == null) {
                    return null;
                }
                return builder.lessThanOrEqualTo(root.get("id"), idMin);
            }
                };
    }

    private static Specification<Account> hasIdMaxGreaterThanOrEqualTo(Integer idMax){
        return (root, query, builder) -> {
            if (idMax == null){
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get("id"),idMax);
        };
    }



}
