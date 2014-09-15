package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.DatabaseAwb;
import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.service.DataviewDatacomService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataviewTest {

	
	private static ClassPathXmlApplicationContext context ;
	private static DataviewDatacomService dataviewdatacomservice;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("application-context.xml");
		dataviewdatacomservice = (DataviewDatacomService) context.getBean("dataviewdatacomService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<DataviewDatacom> listarea=dataviewdatacomservice.findAll(1);
		assertNotNull(listarea);
		assertTrue(listarea.size()>0);
		System.out.println(listarea);
	}

	@Test
	public void testFindByName() {
		DataviewDatacom found = dataviewdatacomservice.findByName("CLIENT");
		assertNotNull(found);
		System.out.println(found);
	}

}
