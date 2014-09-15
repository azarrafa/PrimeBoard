package manage.appli.patri.awb.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.modele.Scheduler;


@Transactional
@Service("schedulerService")
public class SchedulerServiceImp implements SchedulerService {

	@Autowired
	SessionFactory sessionfactory ;
	@Override
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from Scheduler").list().size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Scheduler> findAll(int page) {
		// TODO Auto-generated method stub
		
List<Scheduler> res= sessionfactory.getCurrentSession().createQuery("from Scheduler").list();

		
		if(res!=null){
			Iterator<Scheduler> it=res.iterator();
			Scheduler current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getRelatSliScheds());
			
			
			}
		}
		return  res;
		
	}
	
	
	@Override
	public List<Scheduler> findBySchedulespi(String name) {
		// TODO Auto-generated method stub
List<Scheduler> res= sessionfactory.getCurrentSession().createQuery("from Scheduler where schedule like '"+name+"%'").list();

		
		if(res!=null){
			Iterator<Scheduler> it=res.iterator();
			Scheduler current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getRelatSliScheds());
			
			
			}
		}
		return  res;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Scheduler> findByBombresJobs(BigDecimal nb) {
		// TODO Auto-generated method stub
		
List<Scheduler> res= sessionfactory.getCurrentSession().createQuery("from Scheduler where nombresJobs="+nb).list();

		
		if(res!=null){
			Iterator<Scheduler> it=res.iterator();
			Scheduler current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getRelatSliScheds());
			
			
			}
		}
		return  res;
		
	}
	
	@Override
	public Scheduler findBySchedule(String name) {
		// TODO Auto-generated method stub
	 
   Scheduler res= (Scheduler) sessionfactory.getCurrentSession().createQuery("from Scheduler where schedule='"+name+"'").uniqueResult();

		
		if(res!=null){
	
			Hibernate.initialize(res.getRelatSliScheds());
			
			
			}
		
		return  res;
		
	}

}
