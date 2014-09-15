package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import manage.appli.patri.awb.modele.Cft;
import manage.appli.patri.awb.modele.JobAppel;
import manage.appli.patri.awb.modele.Urt;
import manage.appli.patri.awb.service.JobAppelService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JobAppelServiceImpTest {

	private static ClassPathXmlApplicationContext context ;
	private static JobAppelService jobappelservice ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml") ;
		jobappelservice = (JobAppelService) context.getBean("jobappelService") ;
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
//	List<JobAppel> elem = jobappelservice.findAll();
//	assertTrue(elem.size()>0);
//	System.out.println(elem);
	}

	@Test
	public void testFindByJob() {
		List<JobAppel> elem = jobappelservice.findByJob("CP22080");
		assertTrue(elem.size()>0);
		System.out.println(elem);	
		
	}

	@Test
	public void testFindByJobappel() throws FileNotFoundException {
		PrintWriter out= new PrintWriter(new File("NOTHING"));
		List<JobAppel> elem = jobappelservice.findAll(1);
		Iterator<JobAppel> it = elem.iterator();
		JobAppel current ;
		while(it.hasNext()){
			current =it.next();
			if(current.getCfts().size()==0 && current.getRunPrgs().size()==0 && current.getAnomRunPrgs().size()==0) out.println(current);
			
		}
		
	}
	
//	@Test
//	public void testfindByNotPrgCft() {
//		List<JobAppel> elem =  jobappelservice.findByNotPrgCft();
//		//Set<Cft> urt=elem.getCfts();
//		//Iterator<Cft> it=urt.iterator();
//		
//		assertTrue(elem.size()>0);
//		System.out.println(elem);
//		
//	}

	
}
