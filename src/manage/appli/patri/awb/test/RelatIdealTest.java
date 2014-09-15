package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.RelatIdeal;
import manage.appli.patri.awb.service.RelatIdealService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RelatIdealTest {
	
	private static ClassPathXmlApplicationContext context;
	private static RelatIdealService relatidealservice ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		relatidealservice = (RelatIdealService) context.getBean("relatidealService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindByPrograms() {
		
		List<RelatIdeal> elem = relatidealservice.findByPrograms("CPTB602");
		assertTrue(elem.size()>0);
		System.out.println(elem);
		
	}

	@Test
	public void testFindAll() {
		List<RelatIdeal> elem = relatidealservice.findAll(100);
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

	@Test
	public void testFindBydDataview() {
		List<RelatIdeal> elem = relatidealservice.findBydDataview("CPTS601");
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

}
