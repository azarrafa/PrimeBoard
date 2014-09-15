package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.AnomRunPrg;
import manage.appli.patri.awb.service.AnomRunPrgService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnomRunPrgServiceImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static AnomRunPrgService anomrunprgservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		anomrunprgservice = (AnomRunPrgService) context.getBean("anomrunprgService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test	public void testFindAll() {
	List<AnomRunPrg> run = anomrunprgservice.findAll();
	assertTrue(run.size()>0);
	System.out.println(run);
	}

	@Test
	public void testFindByJobAppel() {
		List<AnomRunPrg> run = anomrunprgservice.findByJobAppel("XE43002.S");
		assertTrue(run.size()>0);
		System.out.println(run);
	}

	@Test
	public void testFindByPrograms() {
		List<AnomRunPrg> run = anomrunprgservice.findByPrograms("EXTB301");
		assertTrue(run.size()>0);
		System.out.println(run);
	}

}
