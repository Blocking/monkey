package com.look.monkey.repository.jpa;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.Repository;

import com.look.monkey.entity.Customer;


public interface CustomerRepository extends Repository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
    List<Customer> findAll();
    
    Customer save(Customer customer);
    
    Collection<NamesOnly> findByFirstName(String lastName);

}