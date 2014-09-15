package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.Urt;
import manage.appli.patri.awb.service.UrtService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UrtServiceTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static UrtService urtservice ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		urtservice = (UrtService) context.getBean("urtService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<Urt> elem = urtservice.findAll(1) ;
		assertTrue(elem.size()>0);
		System.out.println(elem);
		
	}

	@Test
	public void testFindByUrt() {
		List<Urt> elem = urtservice.findByUrt("RENUR055") ;
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

	@Test
	public void testFindByJobappel() {
		List<Urt> elem = urtservice.findByJobappel("NC41017.S") ;
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

}
