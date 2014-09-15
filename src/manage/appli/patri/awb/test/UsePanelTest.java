package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.List;

import manage.appli.patri.awb.modele.UsePanel;
import manage.appli.patri.awb.service.UsePanelService;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsePanelTest {

	private static ClassPathXmlApplicationContext context;
	private static UsePanelService usepanelservice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		usepanelservice = (UsePanelService) context.getBean("unsepanelService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close() ;
	}

	@Test
	public void testFindAll() {
	   List<UsePanel> elem = usepanelservice.findAll(1);
	   assertTrue(elem.size()>0);
	   System.out.println(elem);
	}

	@Test
	public void testFindByName() {
		List<UsePanel> elem = usepanelservice.findByName("CRCE041");
		   assertTrue(elem.size()>0);
		   System.out.println(elem);
	}

	@Test
	public void testFindByPromgrams() {
		
		List<UsePanel> elem = usepanelservice.findByPromgrams("CRCT036");
		   assertTrue(elem.size()>0);
		   System.out.println(elem);
	}

}
