package manage.appli.patri.awb.service;

import java.math.BigDecimal;
import java.util.List;

import manage.appli.patri.awb.modele.Scheduler;

public interface SchedulerService {
	
	List<Scheduler> findAll(int page);
	
	List<Scheduler> findByBombresJobs(BigDecimal nb);
	
	Scheduler findBySchedule(String name) ;
	
	List<Scheduler> findBySchedulespi(String name) ;
	int getcount();
}
