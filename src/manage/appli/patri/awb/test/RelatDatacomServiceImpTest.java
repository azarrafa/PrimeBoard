package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.DataviewIdeal;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.ProgramsId;
import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.service.DataviewDatacomService;
import manage.appli.patri.awb.service.ProgramsService;
import manage.appli.patri.awb.service.RelatDatacomService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RelatDatacomServiceImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static RelatDatacomService relatdatacomservice;
	private static ProgramsService programsservice;
	private static DataviewDatacomService dataviewdatacomservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context = new ClassPathXmlApplicationContext("application-context.xml");
		relatdatacomservice = (RelatDatacomService) context.getBean("relatdatacomService");
		programsservice = (ProgramsService) context.getBean("programsService");
		dataviewdatacomservice = (DataviewDatacomService) context.getBean("dataviewdatacomService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindByPrograms() {
	
	}

	@Test
	public void testFindBydDataview() {
	
	}

	@Test
	public void testFindAll() {
		List<RelatDatacom> listarea=relatdatacomservice.findAll(1);
		assertNotNull(listarea);
		assertTrue(listarea.size()>0);
		System.out.println(listarea);
	}

}
