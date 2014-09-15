package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import manage.appli.patri.awb.service.ExtractData;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtractDataImpTest {
	
	private static ClassPathXmlApplicationContext context ;
	private static ExtractData extractdata ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	context = new ClassPathXmlApplicationContext("application-context.xml");
	extractdata = (ExtractData) context.getBean("extractdataService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testExtractDataCom() {
		extractdata.extractDataCom("INPUT\\BTG");
		
	}
	@Test
	public void testExtractPrograms() {
		extractdata.extractPrograms("INPUT\\EXPPGM");
	}
	@Test
	public void testExtractSLI() {
		extractdata.extractSLI("INPUT\\SPRBA.BATCH");
	}

	@Test
	public void testExtractSched() {
		extractdata.extractSched("INPUT\\SCHDLIST");
	}

	

	

}
