package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;



import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import manage.appli.patri.awb.modele.DatabaseAwb;



@Service("databaseawbService")
@Transactional
public class DatabaseAwbServiceImp implements DatabaseAwbService {

	@Autowired
	private SessionFactory sessionFactory ; 
	
	@Override
	public List<Countdetails> getcount(){
		List<Countdetails> res = new LinkedList<Countdetails>();
		String em =sessionFactory.getCurrentSession().createSQLQuery("select count(*) from database_awb").uniqueResult().toString();
		res.add(new Countdetails("DATABASE",em)) ;
		em =sessionFactory.getCurrentSession().createSQLQuery("select count(*) from area_awb").uniqueResult().toString();
		res.add(new Countdetails("AREA",em)) ;
		em=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from table_awb").uniqueResult().toString();
		res.add(new Countdetails("TABLE",em)) ;
		em=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from dataview_datacom").uniqueResult().toString();
		res.add(new Countdetails("DATAVIEW DATACOM",em)) ;
		em=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from programs").uniqueResult().toString();
		res.add(new Countdetails("PROGRAMS",em)) ;
		em=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from DATAVIEW_ideal").uniqueResult().toString();
		res.add(new Countdetails("DATAVIEW IDEAL",em)) ;
		em=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from sli").uniqueResult().toString();
		res.add(new Countdetails("SLI",em)) ;
		em=sessionFactory.getCurrentSession().createSQLQuery("select count(*) from scheduler").uniqueResult().toString();
		res.add(new Countdetails("SCHEDULE",em)) ;
		
		return res ;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DatabaseAwb> findAll(int page) {
		// TODO Auto-generated method stub
List<DatabaseAwb> res=sessionFactory.getCurrentSession().createQuery("from DatabaseAwb").list();
		
		if(res!=null){
			Iterator<DatabaseAwb> it=res.iterator();
			DatabaseAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getAreaAwbs());
		
			
			}
		}
		return  res;
	
	}
	
	@Override
	public List<DatabaseAwb> findByNameSpi(String name) {
		// TODO Auto-generated method stub
List<DatabaseAwb> res=sessionFactory.getCurrentSession().createQuery("from DatabaseAwb where name like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<DatabaseAwb> it=res.iterator();
			DatabaseAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getAreaAwbs());
		
			
			}
		}
		return  res;
	}

	@Override
	public DatabaseAwb findByName(String name) {
		// TODO Auto-generated method stub
		
DatabaseAwb res=(DatabaseAwb) sessionFactory.getCurrentSession().get(DatabaseAwb.class, name);
		
		if(res!=null){
			Hibernate.initialize(res.getAreaAwbs());
		
			
			}
		
		return  res;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DatabaseAwb> findByUserCatalogue(String name) {
		// TODO Auto-generated method stub

List<DatabaseAwb> res=sessionFactory.getCurrentSession().createQuery("from DatabaseAwb where USER_CATALOGUE='"+name+"'").list();
		
		if(res!=null){
			Iterator<DatabaseAwb> it=res.iterator();
			DatabaseAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getAreaAwbs());
		
			
			}
		}
		return  res;
	
	}

	@Override
	public DatabaseAwb findByDbId(String name) {
		// TODO Auto-generated method stub
		
	
DatabaseAwb res=(DatabaseAwb) sessionFactory.getCurrentSession().createQuery("from DatabaseAwb where dbid='"+name+"'").uniqueResult();
		
		if(res!=null){
			Hibernate.initialize(res.getAreaAwbs());
		
			
			}
		
		return  res;
	}

	

}
