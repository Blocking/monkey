package com.look.monkey.dataInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.look.monkey.entity.Customer;
import com.look.monkey.entity.User;
import com.look.monkey.repository.jpa.CustomerRepository;
import com.look.monkey.repository.jpa.UserRepository;
/**
 * 项目启动后 初始化数据
 */
@Component
public class InitData implements CommandLineRunner{
	
	private final CustomerRepository re;

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public InitData(CustomerRepository re, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.re = re;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	@Transactional(rollbackFor= Exception.class)
	public void run(String... paramArrayOfString) throws Exception {
		re.save(new Customer("佳佳","泰迪"));
		re.save(new Customer("广磊","笨熊"));
		User user = new User();
		user.setUsername("admin@123.com");
		user.setPassword(this.passwordEncoder.encode("123456"));
		userRepository.save(user);
	}

	
	
}
