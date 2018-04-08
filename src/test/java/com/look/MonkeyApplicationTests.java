package com.look;

import com.look.monkey.MonkeyApplication;
import com.look.monkey.repository.extend.CustomerExtendRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MonkeyApplication.class)
public class MonkeyApplicationTests {

	@Autowired
	private CustomerExtendRepository repository;

	@Test
	public void contextLoads() {
		repository.testSqlQueryDSL();
	}

}
