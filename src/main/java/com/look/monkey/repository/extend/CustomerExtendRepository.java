package com.look.monkey.repository.extend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.bean.MessageDTO;
import com.look.monkey.entity.Customer;
import com.look.monkey.entity.QCustomer;
import com.look.monkey.repository.Abstract.AbstractRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.MySQLTemplates;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		return  this.selectFrom(qCustomer).where(qCustomer.firstName.in(ids)).fetch();
	}
	
	
	
	
	
	
	
	public void testQueryDSL2() {
	        long count = (Long)em.get().createQuery("select count("
	        		+ "concat(originalReportProGrammeData.programmeCode, '@', originalReportProGrammeData.originalReportSessionData.originalReport.cinemaCode)"
	        		+ ") from OriginalReportProGrammeData originalReportProGrammeData ")
	        		.getSingleResult();
	        log.info("count::{}",count);
	        
	}

}

