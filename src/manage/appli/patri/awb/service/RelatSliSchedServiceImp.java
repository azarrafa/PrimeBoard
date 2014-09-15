package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.RelatIdeal;
import manage.appli.patri.awb.modele.RelatSliSched;

@Transactional
@Service("relatslischedService")
public class RelatSliSchedServiceImp implements RelatSliSchedService {

	@Autowired
	SessionFactory sessionfactory ;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelatSliSched> findAll(int page) {
		// TODO Auto-generated method stub
		
List<RelatSliSched> res= (new Page( sessionfactory.getCurrentSession().createQuery("from RelatSliSched"),page,50).getList());

		
		if(res!=null){
			Iterator<RelatSliSched> it=res.iterator();
			RelatSliSched current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getScheduler());
			Hibernate.initialize(current.getSli());
			}
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatSliSched> findByJob(String name) {
		// TODO Auto-generated method stub
	
List<RelatSliSched> res=  sessionfactory.getCurrentSession().createQuery("from RelatSliSched where id.job='"+name+"'").list();

		
		if(res!=null){
			Iterator<RelatSliSched> it=res.iterator();
			RelatSliSched current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getScheduler());
			Hibernate.initialize(current.getSli());
			}
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatSliSched> findBySched(String name) {
		// TODO Auto-generated method stub
		
List<RelatSliSched> res=  sessionfactory.getCurrentSession().createQuery("from RelatSliSched where id.schedule='"+name+"'").list();

		
		if(res!=null){
			Iterator<RelatSliSched> it=res.iterator();
			RelatSliSched current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getScheduler());
			Hibernate.initialize(current.getSli());
			}
		}
		return  res;
	}

}
