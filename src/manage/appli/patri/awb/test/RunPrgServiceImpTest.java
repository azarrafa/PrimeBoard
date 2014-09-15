package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.service.RunPrgService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunPrgServiceImpTest {

	private static ClassPathXmlApplicationContext context ;
	private static RunPrgService runprgservice ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		runprgservice = (RunPrgService) context.getBean("runprgService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		
//		List<RunPrg> elem = runprgservice.findAll();
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
		
	}

	@Test
	public void testFindByPrograms() {
		List<RunPrg> elem = runprgservice.findByJobAppel("TI11002.S");
		assertTrue(elem.size() > 0);
		System.out.println(elem);
	}

	@Test
	public void testFindByJobAppel() {
		List<RunPrg> elem = runprgservice.findByPrograms("CRCT041");
		assertTrue(elem.size() > 0);
		System.out.println(elem);
	
	}

}
