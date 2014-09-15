package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.AnomRunPrg;

public interface AnomRunPrgService {
	
	List<AnomRunPrg> findAll();
	
	List<AnomRunPrg> findByJobAppel(String name);
	
	List<AnomRunPrg> findByPrograms(String name);
	
	List<AnomRunPrg> findByProgramspi(String name);
	
	List<AnomRunPrg> findByJob(String name);
	
	List<AnomRunPrg> findByJobspi(String name);
	
	
	

}
