package manage.appli.patri.awb.service;

import java.util.List;
import manage.appli.patri.awb.modele.UseReport;

public interface UseReportService {
	
	
	List<UseReport> findAll(int page);
	
	List<UseReport> findByName(String name);
	
	List<UseReport> findByPromgrams(String name);
 
	int getcount();
}
