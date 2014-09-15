package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import manage.appli.patri.awb.modele.JobAppel;
import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.modele.Sli;
import manage.appli.patri.awb.service.SliService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SliServiceImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static SliService sliservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	context = new ClassPathXmlApplicationContext("application-context.xml");
	sliservice = (SliService) context.getBean("sliService") ;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close() ;
	}

	@Test
	public void testFindAll() {
//		List<Sli> elem = sliservice.findAll(1);
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
		
	}

	@Test
	public void testFindByjob() {
		Sli elem = sliservice.findByjob("AB10001");
		assertNotNull(elem);
		JobAppel jo=elem.getJobAppel();
		Set<RunPrg> j=jo.getRunPrgs() ;
		Iterator<RunPrg> it=j.iterator();
		System.out.println("nc");
		while(it.hasNext()) System.out.println(elem+";"+it.next());
		
	}

	@Test
	public void testFindBynbJob() {
//		List<Sli> elem =  sliservice.findBynbJob("01");
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
		
	}

	@Test
	public void testFindBylibmemb() {
//		List<Sli> elem = sliservice.findBylibmemb("NC56004");
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
	}

	@Test
	public void testFindByclass_() {
//		List<Sli> elem = sliservice.findByclass_("H");
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
	}

	@Test
	public void testFindBysublib() {
//		List<Sli> elem = sliservice.findBysublib("S");
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
	}

	@Test
	public void testFindBysysid() {
//		List<Sli> elem = sliservice.findBysysid("2");
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
	}

	@Test
	public void testFindByfailCode() {
//		List<Sli> elem = sliservice.findByfailCode("00009");
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
	}

}
