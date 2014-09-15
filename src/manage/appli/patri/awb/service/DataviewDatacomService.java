package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.DataviewDatacom;

public interface DataviewDatacomService {
	
	
	List<DataviewDatacom> findAll(int page);
	
	DataviewDatacom findByName(String name);
	
	List<DataviewDatacom> findByNamespi(String name);
	
	List<DataviewDatacom> findBydatabase(String name);
	
	List<DataviewDatacom> findBydatabasespi(String name);
	
	List<DataviewDatacom> findByArea(String name);
	
	List<DataviewDatacom> findByAreaspi(String name);
	
	int getcount();

}
