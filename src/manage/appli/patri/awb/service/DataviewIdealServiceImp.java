package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.DataviewIdeal;
import manage.appli.patri.awb.modele.JobAppel;


@Transactional
@Service("dataviewidealService")
public class DataviewIdealServiceImp implements DataviewIdealService {
	
	@Autowired
	private SessionFactory sessionFactory ; 

	
	@Override
	public int getcount(){
		
		
		return sessionFactory.getCurrentSession().createQuery("from DataviewIdeal").list().size();
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataviewIdeal> findAll(int page) {
		
		List<DataviewIdeal> res=sessionFactory.getCurrentSession().createQuery("from DataviewIdeal").list();
		
		if(res!=null){
			Iterator<DataviewIdeal> it=res.iterator();
			DataviewIdeal current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getRelatIdeals());
		
			
			}
		}
		return  res;
	}
	
	@Override
	public List<DataviewIdeal> findByNamespi(String name) {
		// TODO Auto-generated method stub
	List<DataviewIdeal> res=sessionFactory.getCurrentSession().createQuery("from DataviewIdeal where dataview like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<DataviewIdeal> it=res.iterator();
			DataviewIdeal current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getRelatIdeals());
		
			
			}
		}
		return  res;
	}

	@Override
	public DataviewIdeal findByName(String name) {
		// TODO Auto-generated method stub
		
    DataviewIdeal res= (DataviewIdeal) sessionFactory.getCurrentSession().get(DataviewIdeal.class, name);
		
		if(res!=null){
	
			Hibernate.initialize(res.getRelatIdeals());
		
			
			
		}
		return  res;
	}

}
