package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import manage.appli.patri.awb.modele.Scheduler;
import manage.appli.patri.awb.service.SchedulerService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchedulerServiceImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static SchedulerService schedulerservice ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	context = new ClassPathXmlApplicationContext("application-context.xml");
	schedulerservice = (SchedulerService) context.getBean("schedulerService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
		List<Scheduler> elem = schedulerservice.findAll(1);
		assertTrue(elem.size()>0);
		System.out.println(elem);
		
	}

	@Test
	public void testFindByBombresJobs() {
		
		List<Scheduler> elem = schedulerservice.findByBombresJobs(new BigDecimal(0));
		assertTrue(elem.size()>0);
		System.out.println(elem);
		
	}

	@Test
	public void testFindBySchedule() {
		Scheduler elem = schedulerservice.findBySchedule("WH400");
		assertNotNull(elem);
		System.out.println(elem);
		
		
	}

}
