package com.look.monkey.repository.extend;

import com.look.monkey.entity.Customer;
import com.look.monkey.entity.QCustomer;
import com.look.monkey.repository.Abstract.AbstractRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class CustomerExtendRepository extends AbstractRepository<Customer> {
    private QCustomer qCustomer = QCustomer.customer;

    public List<Customer> findAll() {
        return this.selectFrom(qCustomer).fetch();
    }

    public Customer findByLastName(String lastName) {
        return this.selectFrom(qCustomer)
                .where(qCustomer.lastName.contains(lastName))
                .fetchFirst();
    }

    public List<Customer> getAll() {
        List<String> ids = new ArrayList<>();
        ids.add("佳佳");
        return this.selectFrom(qCustomer).where(qCustomer.firstName.in(ids)).fetch();
    }


}

