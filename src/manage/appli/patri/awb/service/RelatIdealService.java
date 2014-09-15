package manage.appli.patri.awb.service;

import java.util.List;



import manage.appli.patri.awb.modele.RelatIdeal;

public interface RelatIdealService {
	
	 List<RelatIdeal>	findByPrograms(String name);
	  
	  List<RelatIdeal> findAll(int page);
	  
	  List<RelatIdeal> findBydDataview(String name);
	  
	  List<RelatIdeal> findBydDataviewspi(String name);

}
