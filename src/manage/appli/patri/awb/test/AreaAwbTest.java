package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.service.AreaAwbService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AreaAwbTest {

	private static ClassPathXmlApplicationContext context ;
	private static AreaAwbService areaawbservice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("application-context.xml");
		areaawbservice = (AreaAwbService) context.getBean("areaawbService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
		
	}

	@Test
	public void testFindAll() {
		List<AreaAwb> listarea=areaawbservice.findAll(1);
		assertNotNull(listarea);
		assertTrue(listarea.size()>0);
		System.out.println(listarea);
	}

	@Test
	public void testFindByName() {
	AreaAwb found = areaawbservice.findByName("ACTIONNAIRE");
	assertNotNull(found);
	System.out.println(found);
	
	}

	@Test
	public void testFindByDatabase() {
		List<AreaAwb> found = areaawbservice.findByDatabase("CLIENT");
		assertNotNull(found);
		System.out.println(found);
	}

	@Test
	public void testFindByDbName() {
		AreaAwb found = areaawbservice.findByDbName("AH2");
		assertNotNull(found);
		System.out.println(found);
	}
	@Test
	public void testcount() {
		
		System.out.println(areaawbservice.getcount());
	}
	

}
