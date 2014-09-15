package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.AnomPrgDv;

public interface AnomPrgDVService {
	
	
	List<AnomPrgDv> findAll();
	
	List<AnomPrgDv> findByPrograms(String name);
	
	List<AnomPrgDv> findByDataview(String name) ;

}
