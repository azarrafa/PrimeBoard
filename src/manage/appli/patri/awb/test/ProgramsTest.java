package manage.appli.patri.awb.test;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.ProgramsId;
import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.service.ProgramsService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramsTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static ProgramsService programsservice;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		programsservice = (ProgramsService) context.getBean("programsService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindAll() {
//		List<Programs> listarea=programsservice.findAll(1);
//		assertNotNull(listarea);
//		assertTrue(listarea.size()>0);
//		System.out.println(listarea);
	}

	@Test
	public void testFindById() {
//		ProgramsId id= new ProgramsId("BTGB125","002","$ZA");
//		
//		Programs found = programsservice.findById(id);
//		assertNotNull(found);
//		
//		Set<RelatDatacom> i= found.getRelatDatacoms(); 
//		if(i.size()==0) System.out.println("failur");
//		else{
//		Iterator<RelatDatacom> it=i.iterator();
//		RelatDatacom current=new RelatDatacom();
//		while(it.hasNext())
//			current=it.next();
//			System.out.println(found+"+++++++++= "+current.getDataviewDatacom().getDataview());
//		}
		
		
	}

	@Test
	public void testFindByName() {
		List<Programs> found = programsservice.getDoublant();
		assertNotNull(found);
		assertTrue(found.size()>0);
		
		System.out.println(found);
	}

	@Test
	public void testFindBySystem() {
		List<Programs> found = programsservice.findBySystem("$ZA");
		assertNotNull(found);
		assertTrue(found.size()>0);
		System.out.println(found);
	}

	@Test
	public void testFindByStatus() {
		List<Programs> found = programsservice.findByStatus("PROD");
		assertNotNull(found);
		assertTrue(found.size()>0);
		System.out.println(found);
	}

	@Test
	public void testFindByDate() {
		List<Programs> found = programsservice.findByDate("120110");
		assertNotNull(found);
		assertTrue(found.size()>0);
		System.out.println(found);
	}

}
