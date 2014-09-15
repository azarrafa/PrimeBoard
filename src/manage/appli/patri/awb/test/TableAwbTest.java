package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.DatabaseAwb;
import manage.appli.patri.awb.modele.TableAwb;
import manage.appli.patri.awb.service.TableAwbService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableAwbTest {

	
	private static ClassPathXmlApplicationContext context ;
	private static TableAwbService tableawbservice;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		tableawbservice = (TableAwbService) context.getBean("tableawbService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<TableAwb> listarea=tableawbservice.findAll(1);
		assertNotNull(listarea);
		assertTrue(listarea.size()>0);
		System.out.println(listarea);
	}

	@Test
	public void testFindByName() {
		TableAwb found = tableawbservice.findByName("BIEN");
		assertNotNull(found);
		System.out.println(found+" "+found.getAreaAwb().getName());
	}

}
