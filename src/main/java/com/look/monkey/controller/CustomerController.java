package com.look.monkey.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.look.monkey.bean.ResultEntity;
import com.look.monkey.entity.Coffee;
import com.look.monkey.entity.redis.Student;
import com.look.monkey.repository.redis.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.look.monkey.entity.Customer;
import com.look.monkey.repository.jpa.CustomerRepository;
import com.look.monkey.repository.jpa.NamesOnly;
import com.look.monkey.repository.jpa.extend.CustomerExtendRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerRepository customerRepository;
	
	private final CustomerExtendRepository customerExtendRepository;

	private final StudentRepository studentRepository;

	private final ReactiveRedisOperations<String, Coffee> coffeeOps;

	private final StringRedisTemplate stringRedisTemplate;

	public CustomerController(CustomerRepository customerRepository, CustomerExtendRepository customerExtendRepository,
							  StudentRepository studentRepository, ReactiveRedisOperations<String, Coffee> coffeeOps,
							  StringRedisTemplate stringRedisTemplate) {
		this.customerRepository = customerRepository;
		this.customerExtendRepository = customerExtendRepository;
		this.studentRepository = studentRepository;
		this.coffeeOps = coffeeOps;
		this.stringRedisTemplate = stringRedisTemplate;
	}


	@RequestMapping(value="/findAll",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAll(){
		return this.customerRepository.findAll();
	}
	
	@RequestMapping(value="/findAllExtend",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAllQueryDSL(){
		return this.customerExtendRepository.findAll();
	}
	@RequestMapping(value="/findByLastName/{lastName}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findByLastName(
			@PathVariable("lastName") @NotNull String lastName
			){
		return this.customerExtendRepository.findByLastName(lastName);
	}
	
	@RequestMapping(value="/testProjects/{firstName}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<NamesOnly> testProjects(
			@PathVariable("firstName") @NotNull String firstName
			){
		return this.customerRepository.findByFirstName(firstName);
	}

	@GetMapping(value = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> te(){
		Student student = new Student(
				"Eng2015001", "John Doe", Student.Gender.MALE, 1);
		studentRepository.save(student);
		Student retrievedStudent =
				studentRepository.findById("Eng2015001").get();

		stringRedisTemplate.boundValueOps("key").set("value");

		String value = stringRedisTemplate.boundValueOps("key").get();

		return ResponseEntity.ok(retrievedStudent);
	}

	@GetMapping("/coffees")
	public Flux<Coffee> all() {
		return coffeeOps.keys("*")
				.flatMap(coffeeOps.opsForValue()::get);
	}
}
