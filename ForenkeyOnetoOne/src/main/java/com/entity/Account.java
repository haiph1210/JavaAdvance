package com.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "account_id")
//    @GenericGenerator(
//            name = "account_id",
//            strategy = "com.entity.AccountIDConverter"
//    )
    private Integer id;

    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String name;
//    @Column(name = "address")
//    @Convert(converter = AddressConverter.class)
//    private Address address;
//    @Column(name = "create_date",nullable = false,updatable = false)
//    @CreationTimestamp
//    private LocalDate createDate;
//    @Column(name = "update_at",nullable = false,updatable = false)
//    @UpdateTimestamp
//    private LocalDateTime updateAt;

    @OneToOne
    @JoinColumn(name = "group_id",referencedColumnName = "id",unique = true,nullable = false)
    private Group group;


    public Account() {
    }



    public Account(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public LocalDate getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDate createDate) {
//        this.createDate = createDate;
//    }
//
//    public LocalDateTime getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(LocalDateTime updateAt) {
//        this.updateAt = updateAt;
//    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
//                ", address=" + address +
//                ", createDate=" + createDate +
//                ", updateAt=" + updateAt +
                ", group=" + group.getName() +
                '}';
    }
}
