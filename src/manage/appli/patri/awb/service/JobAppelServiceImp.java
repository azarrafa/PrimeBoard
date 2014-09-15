package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.AnomRunPrg;
import manage.appli.patri.awb.modele.Cft;
import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.JobAppel;
import manage.appli.patri.awb.modele.RunPrg;

@Transactional
@Service("jobappelService")
public class JobAppelServiceImp implements JobAppelService {

	@Autowired
	SessionFactory sessionfactory ;
	
	
	@Override
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from JobAppel").list().size();
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<JobAppel> findAll(int page) {
		// TODO Auto-generated method stub
		
		 List<JobAppel> res=sessionfactory.getCurrentSession().createQuery("from JobAppel").list();
			
			if(res!=null){
				Iterator<JobAppel> it=res.iterator();
				JobAppel current=null ;
				while(it.hasNext()){
					current=it.next();
				Hibernate.initialize(current.getAnomRunPrgs());
				Hibernate.initialize(current.getCfts());
				Hibernate.initialize(current.getRunPrgs());
				Hibernate.initialize(current.getUrts());
				Hibernate.initialize(current.getSlis());
			
				
				}
			}
			return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobAppel> findByJob(String job) {
		// TODO Auto-generated method stub
		 
		List<JobAppel> res= sessionfactory.getCurrentSession().createQuery("from JobAppel where job='"+job+"'").list();
			
			if(res!=null){
				Iterator<JobAppel> it=res.iterator();
				JobAppel current=null ;
				while(it.hasNext()){
					current=it.next();
				Hibernate.initialize(current.getAnomRunPrgs());
				Hibernate.initialize(current.getCfts());
				Hibernate.initialize(current.getRunPrgs());
				Hibernate.initialize(current.getUrts());
			
				
				}
			}
			return  res;
		
	}

	@Override
	public JobAppel findByJobappel(String jobappel) {
		// TODO Auto-generated method stub
	
		JobAppel res=(JobAppel) sessionfactory.getCurrentSession().get(JobAppel.class, jobappel);
		
		if(res!=null){
			Hibernate.initialize(res.getAnomRunPrgs());
			Hibernate.initialize(res.getCfts());
			Hibernate.initialize(res.getRunPrgs());
			Hibernate.initialize(res.getUrts());
		
			
			
		}
		return  res;
	
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<JobAppel> findByNotPrgCft() {
//		List<JobAppel> job=sessionfactory.getCurrentSession().createQuery("from JobAppel").list(),retu=null;
////		List<JobAppel> notprgcft = new LinkedList<JobAppel>();
////		List<AnomRunPrg> anom=sessionfactory.getCurrentSession().createQuery("from AnomRunPrg").list();
////		List<Cft> cft=sessionfactory.getCurrentSession().createQuery("from Cft").list();
////		List<RunPrg> runprg=sessionfactory.getCurrentSession().createQuery("from RunPrg").list();
//	//	boolean tcft=false,trun=false,tanom=false;
//		Iterator<JobAppel> it=job.iterator();
//		JobAppel current,rt=null;
//		rt.setJob("test");
//		rt.setJobAppel("test");
//		
//		if(job.size()==0) {retu.add(rt); return retu;}
//		else
//		while(it.hasNext())
//		{
//			current=it.next();
//			
//			if(current.getCfts().size()==0 && current.getRunPrgs().size()==0) retu.add(rt); 
//			System.out.println(current);
//			
//		}
//		
//		return retu;
//	}
}
