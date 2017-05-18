package com.look.monkey.dataInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.look.monkey.entity.Customer;
import com.look.monkey.repository.CustomerRepository;

@Component
public class InitData implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository re;

	@Override
	public void run(String... paramArrayOfString) throws Exception {
		Customer c0 = new Customer("佳佳","泰迪");
		Customer c1 = new Customer("广磊","笨熊");
		re.save(c0);
		re.save(c1);
	}

}
