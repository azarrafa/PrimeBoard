package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import manage.appli.patri.awb.modele.Urt;
import manage.appli.patri.awb.modele.UsePanel;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Service("unsepanelService")
public class UsePanelServiceImp implements UsePanelService {
  
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from UsePanel").list().size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UsePanel> findAll(int page) {
		// TODO Auto-generated method stub
	
		List<UsePanel> res = sessionfactory.getCurrentSession().createQuery("from UsePanel").list(); 

		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsePanel> findByName(String name) {
		// TODO Auto-generated method stub
		
		List<UsePanel> res = (List<UsePanel>) sessionfactory.getCurrentSession().createQuery("from UsePanel where id.panel='"+name+"'").list(); 

		if (res != null) {
			Iterator<UsePanel> it = res.iterator();
			UsePanel current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsePanel> findByPromgrams(String name) {
		// TODO Auto-generated method stub
		
		List<UsePanel> res = (List<UsePanel>) sessionfactory.getCurrentSession().createQuery("from UsePanel where programs.id.name='"+name+"'").list(); 

		if (res != null) {
			Iterator<UsePanel> it = res.iterator();
			UsePanel current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;
	}

}
