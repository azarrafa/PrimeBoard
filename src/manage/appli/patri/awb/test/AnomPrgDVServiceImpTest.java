package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.AnomPrgDv;
import manage.appli.patri.awb.service.AnomPrgDVService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnomPrgDVServiceImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static AnomPrgDVService anomprgdvservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	context = new ClassPathXmlApplicationContext("application-context.xml");
	anomprgdvservice = (AnomPrgDVService) context.getBean("anomprgdvService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
	List<AnomPrgDv> aprog=anomprgdvservice.findAll();
	assertTrue(aprog.size()>0);
	System.out.println(aprog);
	}

	@Test
	public void testFindByPrograms() {
		List<AnomPrgDv> aprog=anomprgdvservice.findByPrograms("BTGB105");
		assertTrue(aprog.size()>0);
		System.out.println(aprog);
	}

	@Test
	public void testFindByDataview() {
		List<AnomPrgDv> aprog=anomprgdvservice.findByDataview("BTG_COMPTE_TMPM");
		assertTrue(aprog.size()>0);
		System.out.println(aprog);
	}

}
