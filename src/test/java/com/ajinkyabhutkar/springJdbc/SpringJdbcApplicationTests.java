package com.ajinkyabhutkar.springJdbc;


import com.ajinkyabhutkar.springJdbc.Dao.UserDao;
import com.ajinkyabhutkar.springJdbc.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJdbcApplicationTests {

	@Autowired
	private UserDao userDao;


	@Test
	void userTest(){
		User user=new User();
		user.setName("Yogiraj Bhutkar");
		user.setPassword("Test@521");
		user.setEmail("Test5@gmail.com");
		user.setCity("Koregaon");
		int rows= userDao.saveUser(user);

		Assertions.assertEquals(1,rows);
	}

}
