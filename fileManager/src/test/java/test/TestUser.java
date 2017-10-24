package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankledger.login.dao.LoginDao;
import com.bankledger.login.entity.User;

public class TestUser {
	ClassPathXmlApplicationContext ac;
	@Before
	public void init() {
		ac=
				new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml","spring-pool.xml");
	}
	@Test
	public void test1(){
		LoginDao d = ac.getBean("loginDao",LoginDao.class);
		User user = d.findObjectByName("abc");
		System.out.println(user);
		Integer count =d.isExist("abc");
		System.out.println(count);
		Assert.assertNotEquals(null, count);
	}
	
	@After
	public void destory() {
		ac.close();
	}
}
