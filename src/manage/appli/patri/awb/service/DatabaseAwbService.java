package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.DatabaseAwb;

public interface DatabaseAwbService {
	
	
	List<DatabaseAwb> findAll(int page);
	
	DatabaseAwb findByName(String name) ;
	
	List<DatabaseAwb> findByUserCatalogue(String name) ;
	
	List<DatabaseAwb> findByNameSpi(String name) ;
	
	DatabaseAwb findByDbId(String name) ;
	
	
	List<Countdetails> getcount();

}
