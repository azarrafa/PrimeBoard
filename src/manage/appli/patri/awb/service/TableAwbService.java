package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.TableAwb;

public interface TableAwbService {
	
	
	
	
	List<TableAwb> findAll(int page);
	
	TableAwb findByName(String name);
	
	List<TableAwb> findByNamespi(String name);
	
	List<TableAwb> findBydatabase(String name );
	
	List<TableAwb> findBydatabasespi(String name );
	
	List<TableAwb> findByArea(String name );
	
	List<TableAwb> findByAreaspi(String name );
	
	int getcount();
	
	

}
