package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.UsePgm;

public interface UsePgmService {
	
	List<UsePgm> findAll(int page);
	
	List<UsePgm> findByName(String name);
	
	List<UsePgm> findByPrograms(String name);
	int getcount();

}
