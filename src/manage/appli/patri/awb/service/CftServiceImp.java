package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.Cft;
import manage.appli.patri.awb.modele.TableAwb;

@Transactional
@Service("cftService")
public class CftServiceImp implements CftService {

	@Autowired
	SessionFactory sessionfactory ;
	
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from Cft").list().size();
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cft> findAll(int page) {
		// TODO Auto-generated method stub
		
List<Cft> res=(new Page(sessionfactory.getCurrentSession().createQuery("from Cft"),page,50).getList());
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
		
	}
	
	@Override
	public List<Cft> findByidfspi(String name) {
List<Cft> res=sessionfactory.getCurrentSession().createQuery("from Cft where id.idf like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cft> findByjobAppel(String name) {
		// TODO Auto-generated method stub
		
List<Cft> res=sessionfactory.getCurrentSession().createQuery("from Cft where jobAppel.jobAppel='"+name+"'").list();
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
		
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cft> findBypart(String name) {
		// TODO Auto-generated method stub
		
List<Cft> res=sessionfactory.getCurrentSession().createQuery("from Cft where id.part='"+name+"'").list();
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
	}
	
	
	@Override
	public List<Cft> findBypartspi(String name) {
List<Cft> res=sessionfactory.getCurrentSession().createQuery("from Cft where id.part like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cft> findByidf(String name) {
		// TODO Auto-generated method stub
		
List<Cft> res= sessionfactory.getCurrentSession().createQuery("from Cft where id.idf='"+name+"'").list();
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cft> findByparm(String name) {
		// TODO Auto-generated method stub
		
List<Cft> res= sessionfactory.getCurrentSession().createQuery("from Cft where id.parm='"+name+"'").list();
		
		if(res!=null){
			Iterator<Cft> it=res.iterator();
			Cft current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getJobAppel());
		
			
			}
		}
		return  res;
	}

}
