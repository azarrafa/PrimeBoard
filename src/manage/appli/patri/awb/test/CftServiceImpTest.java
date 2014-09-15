package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.Cft;
import manage.appli.patri.awb.service.CftService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CftServiceImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static CftService cftservice ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		cftservice = (CftService) context.getBean("cftService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
//		List<Cft> elem =cftservice.findAll();
//		assertTrue(elem.size()>0) ;
//		System.out.println(elem);
		
		
	}

	@Test
	public void testFindByjobAppel() {
		List<Cft> elem =cftservice.findByjobAppel("AB10002.S");
		assertTrue(elem.size()>0) ;
		System.out.println(elem);
	}

	@Test
	public void testFindBypart() {
		List<Cft> elem =cftservice.findBypart("ARR");
		assertTrue(elem.size()>0) ;
		System.out.println(elem);
	}

	@Test
	public void testFindByidf() {
		List<Cft> elem =cftservice.findByidf("test");
		assertTrue(elem.size()>0) ;
		System.out.println(elem);
	}

	@Test
	public void testFindByparm() {
		List<Cft> elem =cftservice.findByparm("&parm");
		assertTrue(elem.size()>0) ;
		System.out.println(elem);
	}

}
