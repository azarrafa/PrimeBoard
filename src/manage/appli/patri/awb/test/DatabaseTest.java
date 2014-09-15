package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.modele.DatabaseAwb;
import manage.appli.patri.awb.service.DatabaseAwbService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseTest {

	private static ClassPathXmlApplicationContext context ;
	private static DatabaseAwbService databaseawbservice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		databaseawbservice = (DatabaseAwbService) context.getBean("databaseawbService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<DatabaseAwb> listarea=databaseawbservice.findAll(1);
		assertNotNull(listarea);
		assertTrue(listarea.size()>0);
		System.out.println(listarea);
	}

	@Test
	public void testFindByName() {
		DatabaseAwb found = databaseawbservice.findByName("CLIENT");
		assertNotNull(found);
		System.out.println(found);
	}

	@Test
	public void testFindByUserCatalogue() {
		List<DatabaseAwb> found = databaseawbservice.findByUserCatalogue("ET29");
		assertNotNull(found);
		System.out.println(found);
	}

	@Test
	public void testFindByDbId() {
		DatabaseAwb found = databaseawbservice.findByDbId("00102");
		assertNotNull(found);
		System.out.println(found);
	}

}
