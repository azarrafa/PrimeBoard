package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.AreaAwb;



public interface AreaAwbService {
	
	
	List<AreaAwb> findAll(int page);
	
	AreaAwb findByName(String name) ;
	
	List<AreaAwb> findByDatabase(String name) ;
	List<AreaAwb> findByNamespi(String name) ;
	List<AreaAwb> findByDatabasespi(String name) ;
	AreaAwb findByDbName(String name) ;
	
	int getcount();
	
	
	
	


}
