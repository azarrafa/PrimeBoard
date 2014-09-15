package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.Urt;

public interface UrtService {
	
	
	List<Urt> findAll(int page) ;
	
	List<Urt> findByUrt(String urt);
	
	List<Urt> findByJobappel(String jobappel);
	
	

}
