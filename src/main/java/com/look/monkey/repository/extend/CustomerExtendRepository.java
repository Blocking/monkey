package com.look.monkey.repository.extend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.bean.MessageDTO;
import com.look.monkey.entity.Customer;
import com.look.monkey.entity.QCustomer;
import com.look.monkey.repository.Abstract.AbstractRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DslExpression;
import com.querydsl.example.sql.QCinema;
import com.querydsl.example.sql.QOriginalReport;
import com.querydsl.example.sql.QOriginalReportProGrammeData;
import com.querydsl.example.sql.QOriginalReportSessionData;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
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
//		ids.add("广磊");
		return  this.selectFrom(qCustomer).where(qCustomer.firstName.in(ids)).fetch();
	}
	
	
	public List<MessageDTO> testSqlQueryDSL(){
		
		MySQLTemplates sqlTemplates = new MySQLTemplates();
		JPASQLQuery<MessageDTO> query = new JPASQLQuery<>(em.get(), sqlTemplates);
		 QOriginalReportSessionData qOriginalReportSessionData = QOriginalReportSessionData.originalReportSessionData;
	        QCinema qCinema = QCinema.cinema;
	        QOriginalReportProGrammeData qOriginalReportProGrammeData = QOriginalReportProGrammeData.originalReportProGrammeData;
	        QOriginalReport qOriginalReport = QOriginalReport.originalReport;
	        
	        query.select(
	        		Projections.bean(MessageDTO.class, qCinema.shortName,
	    	                qOriginalReportProGrammeData.programmeSales.sum().as("programmeSales"),
	    	                qOriginalReportProGrammeData.programmeOtherSales.sum().as("programmeOtherSales"),
	    	          qOriginalReportSessionData.audienceCount.sum().as("audienceCount")
	    	                )
	        		
	                )
	        .from(qOriginalReportSessionData)
	        .leftJoin(qOriginalReport).on(qOriginalReport.id.eq(qOriginalReportSessionData.originalReportId))
	        .leftJoin(qOriginalReportProGrammeData).on(qOriginalReportProGrammeData.originalReportSessionDataId.eq(qOriginalReportSessionData.id))
	        .leftJoin(qCinema).on(qOriginalReport.cinemaCode.eq(qCinema.code))
	        .groupBy(qCinema.shortName);
	       /* JPASQLQuery<MessageDTO> queryCount = new JPASQLQuery<>(em.get(), sqlTemplates);
	        
	        
	        
	        long count = queryCount.from(query, new QOriginalReportSessionData("a")).fetchCount();*/
	        long count = query.clone().select(qCinema.shortName.countDistinct()).fetchOne();
	        
	        query.offset(0).limit(10);
	        
	        log.info("count:[{}]",count);
		return query.fetch();
	}
	
	
	public void testQueryDSL() {
		 com.look.monkey.entity.report.OriginalReport.QOriginalReportSessionData qOriginalReportSessionData =  com.look.monkey.entity.report.OriginalReport.QOriginalReportSessionData.originalReportSessionData;
		 com.look.monkey.entity.cinema.QCinema qCinema = com.look.monkey.entity.cinema.QCinema.cinema;
	        com.look.monkey.entity.report.OriginalReport.QOriginalReportProGrammeData qOriginalReportProGrammeData = com.look.monkey.entity.report.OriginalReport.QOriginalReportProGrammeData.originalReportProGrammeData;
	        BooleanBuilder where = new BooleanBuilder();
	        JPAQuery<Tuple> query = new JPAQuery<>(em.get());
	        		
	        query.select(qCinema.province.name, qCinema.cinemaChain.name, qCinema.shortName, qOriginalReportProGrammeData.programmeCode,
	                qOriginalReportProGrammeData.programmeSales, qOriginalReportProGrammeData.programmeOtherSales, qOriginalReportSessionData.originalReport.businessDate)
	        .from(qCinema, qOriginalReportSessionData, qOriginalReportProGrammeData);

	        where.and(qCinema.code.eq(qOriginalReportSessionData.originalReport.cinemaCode));
	        where.and(qOriginalReportProGrammeData.originalReportSessionData.id.eq(qOriginalReportSessionData.id));
	        
	        query.where(where);
	        Long total = query.fetchCount();
	        query.offset(0);
	        query.limit(10);
	        List<Tuple> list = query.fetch();
	        log.info("total:[{}]====tupleSize:[{}]===tuple:{}",total,list.size(),list);
	}
	
	
	public void testQueryDSL1() {
		com.look.monkey.entity.report.OriginalReport.QOriginalReportProGrammeData qOriginalReportProGrammeData = com.look.monkey.entity.report.OriginalReport.QOriginalReportProGrammeData.originalReportProGrammeData;
	        BooleanBuilder where = new BooleanBuilder();
	        JPAQuery<Tuple> query = new JPAQuery<>(em.get());
	        query.select(qOriginalReportProGrammeData.originalReportSessionData.originalReport.cinemaCode, qOriginalReportProGrammeData.programmeCode,
	                qOriginalReportProGrammeData.programmeSales.sum(), 
	                qOriginalReportProGrammeData.programmeOtherSales.sum(),
	                qOriginalReportProGrammeData.originalReportSessionData.originalReport.businessDate)
	        .from(qOriginalReportProGrammeData)
	        ;
	        
	        
	        query.where(where);
	        
	        List<String> m =  query.clone().select(qOriginalReportProGrammeData.originalReportSessionData.originalReport.cinemaCode.concat(qOriginalReportProGrammeData.programmeCode)).distinct().fetch();
	        
	        log.info("m:[{}]",m.size());
	        
	        query.groupBy(qOriginalReportProGrammeData.originalReportSessionData.originalReport.cinemaCode, qOriginalReportProGrammeData.programmeCode,
	        		qOriginalReportProGrammeData.originalReportSessionData.originalReport.businessDate);
	        
	        Long total = 0l;//query.fetchCount();
	        query.offset(0);
	        query.limit(200);
	        List<Tuple> list = query.fetch();
	        log.info("total:[{}]====tupleSize:[{}]===tuple:{}",total,list.size(),list);
	        
	       /* long count = (Long)em.get().createQuery("SELECT\r\n" + 
	        		"	count(\r\n" + 
	        		"		DISTINCT originalReportProGrammeData.originalReportSessionData.originalReport.cinemaCode,\r\n" + 
	        		"		originalReportProGrammeData.programmeCode,\r\n" + 
	        		"		originalReportProGrammeData.originalReportSessionData.originalReport.businessDate\r\n" + 
	        		"	)\r\n" + 
	        		"FROM\r\n" + 
	        		"	OriginalReportProGrammeData originalReportProGrammeData").getSingleResult();
	        log.info("count::{}",count);*/
	        
	}
	
	
	public void testQueryDSL2() {
	        long count = (Long)em.get().createQuery("select count("
	        		+ "concat(originalReportProGrammeData.programmeCode, '@', originalReportProGrammeData.originalReportSessionData.originalReport.cinemaCode)"
	        		+ ") from OriginalReportProGrammeData originalReportProGrammeData ")
	        		.getSingleResult();
	        log.info("count::{}",count);
	        
	}

}

