package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.Cft;

public interface CftService {
	
	List<Cft> findAll(int page);
	
	List<Cft> findByjobAppel(String name);
	
	List<Cft> findBypart(String name);
	
	List<Cft> findBypartspi(String name);
	
	List<Cft>	findByidf(String name);
	
	List<Cft>	findByidfspi(String name);
	
	List<Cft> findByparm(String name) ;

}
