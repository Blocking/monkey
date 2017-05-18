package com.look.monkey.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.look.monkey.entity.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    
    @NotNull
    private Date signupDate = new Date();


    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                getId(), firstName, lastName);
    }

}