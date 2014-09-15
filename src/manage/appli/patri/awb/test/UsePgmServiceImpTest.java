package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.UsePgm;
import manage.appli.patri.awb.service.UsePgmService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsePgmServiceImpTest {

	private static ClassPathXmlApplicationContext context ;
	private static UsePgmService usepgmservice ;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		usepgmservice = (UsePgmService) context.getBean("usepgmService");
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
		
	}

	@Test
	public void testFindAll() {
		List<UsePgm> elm = usepgmservice.findAll(1);
		assertTrue(elm.size()>0) ;
		System.out.println(elm);
	}

	@Test
	public void testFindByName() {
//		List<UsePgm> elm = usepgmservice.findByName("CRXT001");
//		assertTrue(elm.size()>0) ;
//		System.out.println(elm);
	}

	@Test
	public void testFindByPrograms() {
		List<UsePgm> elm = usepgmservice.findByPrograms("BTGB110");
		assertTrue(elm.size()>0) ;
		System.out.println(elm);
	}

}
