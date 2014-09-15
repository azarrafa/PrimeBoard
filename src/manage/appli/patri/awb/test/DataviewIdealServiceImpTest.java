package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import manage.appli.patri.awb.modele.DataviewIdeal;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.RelatIdeal;
import manage.appli.patri.awb.service.DataviewIdealService;
import manage.appli.patri.awb.service.ProgramsService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataviewIdealServiceImpTest {
	
	
	private static ClassPathXmlApplicationContext context ;
	private static DataviewIdealService dataviewidealservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		dataviewidealservice = (DataviewIdealService) context.getBean("dataviewidealService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
		
	}

	@Test
	public void testFindAll() {
		List<DataviewIdeal> listarea=dataviewidealservice.findAll(1);
		assertNotNull(listarea);
		assertTrue(listarea.size()>0);
		System.out.println(listarea);
	}

	@Test
	public void testFindByName() {
		DataviewIdeal found = dataviewidealservice.findByName("BTGS125");
		assertNotNull(found);
		
		//List<RelatIdeal> id=(List<RelatIdeal>) found.getRelatIdeals();
		Set<RelatIdeal> i = found.getRelatIdeals();
		Iterator<RelatIdeal> it=i.iterator();
		while(it.hasNext()) 
			System.out.println("$$"+it.next());
		//assertTrue(found.size()>0);
		System.out.println(found);
	}

}
