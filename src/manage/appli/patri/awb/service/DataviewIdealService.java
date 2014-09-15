package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.DataviewIdeal;

public interface DataviewIdealService {



    List<DataviewIdeal> findAll(int page);
    
    DataviewIdeal findByName(String name);
    
    List<DataviewIdeal> findByNamespi(String name);
    
	int getcount();



}
