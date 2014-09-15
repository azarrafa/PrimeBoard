package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.modele.RelatIdeal;

@Service("relatidealService")
@Transactional
public class RelatIdealServiceImp implements RelatIdealService {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatIdeal> findByPrograms(String name) {
		// TODO Auto-generated method stub
		
List<RelatIdeal> res=  sessionFactory.getCurrentSession().createQuery("from RelatIdeal where id.programs='"+ name+ "'").list();

		
		if(res!=null){
			Iterator<RelatIdeal> it=res.iterator();
			RelatIdeal current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewIdeal());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatIdeal> findAll(int page) {
		// TODO Auto-generated method stub
		
List<RelatIdeal> res= (List<RelatIdeal>) (new Page(sessionFactory.getCurrentSession().createQuery("from RelatIdeal"),page,100)).getList();

		
		if(res!=null){
			Iterator<RelatIdeal> it=res.iterator();
			RelatIdeal current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewIdeal());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatIdeal> findBydDataview(String name) {
		// TODO Auto-generated method stub
		
List<RelatIdeal> res= sessionFactory.getCurrentSession().createQuery("from RelatIdeal where id.dataview='"+name+"'").list();

		
		if(res!=null){
			Iterator<RelatIdeal> it=res.iterator();
			RelatIdeal current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewIdeal());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
				
	}
	@Override
	public List<RelatIdeal> findBydDataviewspi(String name) {
		// TODO Auto-generated method stub
List<RelatIdeal> res= sessionFactory.getCurrentSession().createQuery("from RelatIdeal where id.dataview like '"+name+"%'").list();

		
		if(res!=null){
			Iterator<RelatIdeal> it=res.iterator();
			RelatIdeal current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewIdeal());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
	}

}
