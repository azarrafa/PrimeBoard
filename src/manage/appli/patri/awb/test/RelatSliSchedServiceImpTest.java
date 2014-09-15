package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;



import manage.appli.patri.awb.modele.RelatSliSched;
import manage.appli.patri.awb.service.RelatSliSchedService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RelatSliSchedServiceImpTest {

	private static ClassPathXmlApplicationContext context ;
	private static RelatSliSchedService relatslischedservice ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		relatslischedservice = (RelatSliSchedService) context.getBean("relatslischedService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
//		List<RelatSliSched> elem = relatslischedservice.findAll();
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
	}

	@Test
	public void testFindByJob() {
		List<RelatSliSched> elem = relatslischedservice.findByJob("TI10011");
		assertTrue(elem.size()>0);
		System.out.println(elem);
		
	}

	@Test
	public void testFindBySched() {
		List<RelatSliSched> elem = relatslischedservice.findBySched("TI100");
		assertTrue(elem.size()>0);
		System.out.println(elem);
	}

}
