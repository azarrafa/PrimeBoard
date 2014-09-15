package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.RelatSliSched;

public interface RelatSliSchedService {
	
	List<RelatSliSched> findAll(int page);
	
	List<RelatSliSched> findByJob(String name);
	
	List<RelatSliSched> findBySched(String name);
	
	
	

}
