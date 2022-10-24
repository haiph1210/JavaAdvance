package com.vti.specsification;

import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class DepartmentSpecification {

    public static Specification<Department> buildWhere(DepartmentFilterForm form){
        if (form == null){
            return null;
        }
        return hasCreatedDateEqual(form.getCreatedDate())
                .and(hasMaxCreatedDateGreaterThanOrEqualTo(form.getMaxCreatedDate())
                        .and(hasMinCreatedDateLessThanOrEqualTo(form.getMinCreatedDate())
                                .and(hasMinYearCreatedDateLessThanOrEqualTo(form.getMinCreatedYear())
                                        .and(hasTypeEqual(form.getType())
                                        )))
                );
    }

    public static Specification<Department> hasCreatedDateEqual(LocalDate createdDate){
        return new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
               if (createdDate == null){
                   return null;
               }
               return builder.equal(root.get("createdDate").as(LocalDate.class),createdDate);
            }
        };
    }

    private static Specification<Department> hasMinCreatedDateLessThanOrEqualTo(LocalDate minCreatedDate){
       return (root, query, builder) -> {
       if (minCreatedDate == null){
           return null;
       }
       return builder.lessThanOrEqualTo(root.get("createdDate").as(LocalDate.class),minCreatedDate);
       };
    }

    private static Specification<Department> hasMaxCreatedDateGreaterThanOrEqualTo(LocalDate maxCreatedDate){
        return (root, query, builder) -> {
            if (maxCreatedDate == null){
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get("createdDate").as(LocalDate.class),maxCreatedDate);
        };
    }

    private static Specification<Department> hasMinYearCreatedDateLessThanOrEqualTo(Integer minCreatedYear){
        return (root, query, builder) ->{
            if (minCreatedYear == null){
                return null;
            }
            return builder.lessThanOrEqualTo(
                    builder.function("YEAR",Integer.class,root.get("createdDate")),minCreatedYear
                       );
        };
    }

    public static Specification<Department> hasTypeEqual(Department.Type type){
        return new
                Specification<Department>() {
                    @Override
                    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                        if (type == null){
                            return null;
                        }
                        return builder.equal(root.get("type"),type);
                    }
                };
    }


}
