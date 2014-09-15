package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import manage.appli.patri.awb.service.CftService;
import manage.appli.patri.awb.service.CompteService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompteServiceImpTest {

	
	private static ClassPathXmlApplicationContext context ;
	private static CompteService servicecpmte ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		servicecpmte = (CompteService) context.getBean("CompteService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testGetNBbase() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBarea() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBtable() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBdataviewdc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBdataviewid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBprograms() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBsli() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBsched() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBpanel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNBreport() {
		fail("Not yet implemented");
	}

}
