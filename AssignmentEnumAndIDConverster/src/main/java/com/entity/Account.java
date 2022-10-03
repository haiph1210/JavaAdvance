package com.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String name;
    @Column(name = "address")
    @Convert(converter = AddressConverter.class)
    private Address address;
    @Column(name = "create_date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createDate;
    @Column(name = "update_at",nullable = false,updatable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Account() {
    }

    public Account(String name, Address address) {
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createDate=" + createDate +
                ", updateAt=" + updateAt +
                '}';
    }
}
