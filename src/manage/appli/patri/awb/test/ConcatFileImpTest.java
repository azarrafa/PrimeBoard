package manage.appli.patri.awb.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import manage.appli.patri.awb.service.ConcatFile;
import manage.appli.patri.awb.service.Filedetail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConcatFileImpTest {

	private static ClassPathXmlApplicationContext context ;
	private static ConcatFile concatfile ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		concatfile = (ConcatFile) context.getBean("concatfileService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testConcat() {
	
	}
	@Test
	public void testList() {
		//String[] files={"INPUT\\EXPGMID","INPUT\\EXPGMIF"};
		List<Filedetail> tr = concatfile.listfilein();
		assertNotNull(tr);
		Iterator<Filedetail> it=tr.iterator();
		Filedetail cu=null;
		while(it.hasNext()){
			cu=it.next() ;
		System.out.println(tr.size()+cu.getName()+" "+cu.getTaille());
	}}
}
