package test;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankledger.attachement.controller.AttachController;
import com.bankledger.attachement.dao.AttachementDao;
import com.bankledger.attachement.entity.FileMag;
import com.bankledger.attachement.service.AttachementServiceImpl;
import com.bankledger.attachement.web.JsonResult;

public class TestCase {
	String title="面向对象";
	ClassPathXmlApplicationContext ac;
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext(
						"spring-mvc.xml","spring-mybatis.xml","spring-pool.xml");
		System.out.println("ac:"+ac);
	}
	@After
	public void destory() {
		ac.close();
	}
	@Test
	public void test1() {
		AttachementDao d = ac.getBean("attachementDao",AttachementDao.class);
		System.out.println(d);
		List<FileMag> c = d.findSomeObjects(title);
		System.out.println(c);
	}
	@Test
	public void test2() {
		AttachementServiceImpl d  = ac.getBean("attachementServiceImpl",AttachementServiceImpl.class);
		List <FileMag> list = d.findSomeObjects(title);
		System.out.println(list);
	}
	@Test
	public void test3() {
		AttachController a = ac.getBean("attachController",AttachController.class);
		JsonResult abc = a.doFindSomeObjects(title);
		System.out.println(abc);
	}
	
}
