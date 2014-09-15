package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import manage.appli.patri.awb.service.AuthenticationService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AuthenticationServiceImpTest {

	
	
	 private static ClassPathXmlApplicationContext context ;
	private static AuthenticationService authen ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		authen = (AuthenticationService) context.getBean("authenticationService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testLogin() {
		assertTrue(authen.login("admin", "admin"));
	}

}
