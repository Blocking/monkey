package com.look.monkey.repository.extend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.entity.Customer;
import com.look.monkey.entity.QCustomer;
import com.look.monkey.repository.Abstract.AbstractRepository;

@Repository
@Transactional
public class CustomerExtendRepository extends AbstractRepository<Customer> {
	private QCustomer qCustomer = QCustomer.customer;

	public List<Customer> findAll(){
		return this.selectFrom(qCustomer).fetch();
	}
	
	public Customer findByLastName(String lastName){
		return this
				.selectFrom(qCustomer)
				.where(qCustomer.lastName.contains(lastName))
				.fetchFirst();
	}

	public List<Customer> getAll(){
		List<String> ids = new ArrayList<>();
		ids.add("佳佳");
//		ids.add("广磊");
		return  this.selectFrom(qCustomer).where(qCustomer.firstName.in(ids)).fetch();
	}

}
