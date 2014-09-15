package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.Sli;

public interface SliService {

	List<Sli> findAll(int page);

	Sli findByjob(String name);
	
	List<Sli> findByjobspi(String name);

	List<Sli> findBynbJob(String name);

	List<Sli> findBylibmemb(String name);

	List<Sli> findByclass_(String name);

	List<Sli> findBysublib(String name);

	List<Sli> findBysysid(String name);

	List<Sli> findByfailCode(String name);
	

	
	int getcount();

}
