package com.look.monkey.dataInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.entity.Customer;
import com.look.monkey.entity.User;
import com.look.monkey.repository.CustomerRepository;
import com.look.monkey.repository.UserRepository;
/**
 * 项目启动后 初始化数据
 */
@Component
public class InitData implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository re;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 
	@Override
	@Transactional
	public void run(String... paramArrayOfString) throws Exception {
		re.save(new Customer("佳佳","泰迪"));
		re.save(new Customer("广磊","笨熊"));
		User user = new User();
		user.setUsername("admin@123.com");
		user.setPassword(this.passwordEncoder.encode("123456"));
		userRepository.save(user);
	}

	
	
}
