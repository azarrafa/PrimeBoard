package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.UseReport;
import manage.appli.patri.awb.service.UseReportService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseReportImpTest {
	
	private static ClassPathXmlApplicationContext context;
	private static UseReportService usereportservice ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		usereportservice = (UseReportService) context.getBean("usereportService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<UseReport> elem = usereportservice.findAll(1);
		assertTrue(elem.size()>0);
		System.out.println(elem);
		
	}

	@Test
	public void testFindByName() {
		List<UseReport> elem = usereportservice.findByName("CRCR041");
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

	@Test
	public void testFindByPromgrams() {
		List<UseReport> elem = usereportservice.findByName("RATR072");
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

}
