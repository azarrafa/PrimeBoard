package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.ProgramsId;
import manage.appli.patri.awb.modele.RelatDatacom;


@Service("relatdatacomService")
@Transactional
public class RelatDatacomServiceImp implements RelatDatacomService {

	
	@Autowired
	private SessionFactory sessionFactory ; 
	@SuppressWarnings("unchecked")
	@Override
	public List<RelatDatacom> findByPrograms(ProgramsId name) {
		// TODO Auto-generated method stub
		
		
List<RelatDatacom> res= sessionFactory.getCurrentSession().createQuery("from RelatDatacom where programs.id.name='"+name.getName()+"'").list();
		
		if(res!=null){
			Iterator<RelatDatacom> it=res.iterator();
			RelatDatacom current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewDatacom().getTableAwb().getAreaAwb().getDatabaseAwb());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatDatacom> findBydDataview(String name) {
		// TODO Auto-generated method stub
		
		
List<RelatDatacom> res= sessionFactory.getCurrentSession().createQuery("from RelatDatacom where id.dataview='"+name+"'").list();
		
		if(res!=null){
			Iterator<RelatDatacom> it=res.iterator();
			RelatDatacom current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewDatacom().getTableAwb().getAreaAwb().getDatabaseAwb());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelatDatacom> findAll(int page) {
		// TODO Auto-generated method stub
		
List<RelatDatacom> res=(new Page(sessionFactory.getCurrentSession().createQuery("from RelatDatacom"),page,50).getList());
		
		if(res!=null){
			Iterator<RelatDatacom> it=res.iterator();
			RelatDatacom current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewDatacom().getTableAwb().getAreaAwb().getDatabaseAwb());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
		}
	
	@Override
	public List<RelatDatacom> findBydDataviewspi(String name) {
		// TODO Auto-generated method stub
List<RelatDatacom> res= sessionFactory.getCurrentSession().createQuery("from RelatDatacom where id.dataview like '"+name+"%'").list();
		
		if(res!=null){
			Iterator<RelatDatacom> it=res.iterator();
			RelatDatacom current=null ;
			while(it.hasNext()){
				current=it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getDataviewDatacom().getTableAwb().getAreaAwb().getDatabaseAwb());
			Hibernate.initialize(current.getPrograms());
			}
		}
		return  res;
	}
}
