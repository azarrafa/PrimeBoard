package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import manage.appli.patri.awb.service.ExecCommandeImp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecCommandeImpTest {

	private static ClassPathXmlApplicationContext context ;
	private static ExecCommandeImp execommandeservice ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		execommandeservice = (ExecCommandeImp) context.getBean("execCommandeService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateBase() {
	execommandeservice.createBase();
	}

	@Test
	public void testDeleteBase() {
		execommandeservice.deleteBase();
	}

	@Test
	public void testLoadData() {
		execommandeservice.exportData();
	}

	@Test
	public void testExportData() {
		execommandeservice.loadData();
	}

}
