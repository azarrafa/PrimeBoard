package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.JobAppel;

public interface JobAppelService {
	
	
	List<JobAppel> findAll(int page);
	
	List<JobAppel> findByJob(String job);
	
	JobAppel findByJobappel(String jobappel);
	
	//List<JobAppel> findByNotPrgCft();
	
	int getcount();

}
