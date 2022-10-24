package com.vti.form;


import com.vti.validation.DepartmentNameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.List;

@Getter
@Setter
public class DepartmentCreateForm {
    @NotBlank(message = "{Department.createDepartment.form.name.NotBlank}")
    @Length(max = 10,message = "{Department.createDepartment.form.name.Length}")
    @DepartmentNameNotExists(message = "{Department.createDepartment.form.name.NotExists}")
    private String name;
    @NotNull(message = "notnull")
    @Pattern(
            regexp = "DEV||TEST||SM||PM",
            message = "nhập dev test scrummasster or project manager"
    )
    private String type;
    private Integer accountId;
    private List< @Valid Account> accounts;
    @Getter
    @Setter
    public static class Account{
        @NotBlank (message = "account username not blank")
        @Length(max = 10, message = " max = 10")
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String role;
    }
}
