package manage.appli.patri.awb.service;

import java.util.List;


import manage.appli.patri.awb.modele.UsePanel;


public interface UsePanelService {
	
	
	List<UsePanel> findAll(int page);
	
	List<UsePanel> findByName(String name);
	
	List<UsePanel> findByPromgrams(String name);
	
	
	int getcount();
	

}
