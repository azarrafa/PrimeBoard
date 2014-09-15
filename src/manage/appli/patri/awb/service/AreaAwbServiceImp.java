package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.modele.TableAwb;

@Service("areaawbService")
@Transactional
public class AreaAwbServiceImp implements AreaAwbService {

	@Autowired
	private SessionFactory sessionfactory ; 
	
	@Override
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from AreaAwb").list().size();
	} 
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AreaAwb> findAll(int page) {
		// TODO Auto-generated method stub
List<AreaAwb> res=sessionfactory.getCurrentSession().createQuery("from AreaAwb").list();
		
		if(res!=null){
			Iterator<AreaAwb> it=res.iterator();
			AreaAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getDatabaseAwb());
			Hibernate.initialize(current.getTableAwbs());
			
			}
		}
		return  res;
		
	}
	
	@Override
	public List<AreaAwb> findByNamespi(String name) {
List<AreaAwb> res=sessionfactory.getCurrentSession().createQuery("from AreaAwb where name like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<AreaAwb> it=res.iterator();
			AreaAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getDatabaseAwb());
			Hibernate.initialize(current.getTableAwbs());
			
			}
		}
		return  res;
	}
	

	@Override
	public AreaAwb findByName(String name) {
		// TODO Auto-generated method stub
		AreaAwb res =(AreaAwb) sessionfactory.getCurrentSession().get(AreaAwb.class, name);
		
		if(res!=null){
			
			Hibernate.initialize(res.getDatabaseAwb());
			Hibernate.initialize(res.getTableAwbs());
			
			
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaAwb> findByDatabase(String name) {
		// TODO Auto-generated method stub
		List<AreaAwb> res= sessionfactory.getCurrentSession().createQuery("from AreaAwb where databas='"+name+"'").list();
	
		if(res!=null){
			Iterator<AreaAwb> it=res.iterator();
			AreaAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getDatabaseAwb());
			Hibernate.initialize(current.getTableAwbs());
			
			}
		}
		return  res;
	}
	
	@Override
	public List<AreaAwb> findByDatabasespi(String name) {
		// TODO Auto-generated method stub
		List<AreaAwb> res= sessionfactory.getCurrentSession().createQuery("from AreaAwb where databas like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<AreaAwb> it=res.iterator();
			AreaAwb current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getDatabaseAwb());
			Hibernate.initialize(current.getTableAwbs());
			
			}
		}
		return  res;
	}

	@Override
	public AreaAwb findByDbName(String name) {
		// TODO Auto-generated method stub
	
AreaAwb res =(AreaAwb) sessionfactory.getCurrentSession().createQuery("from AreaAwb where dbname='"+name+"'").uniqueResult();
		
		if(res!=null){
			
			Hibernate.initialize(res.getDatabaseAwb());
			Hibernate.initialize(res.getTableAwbs());
			
			
		}
		return  res;
	}

}
