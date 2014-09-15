package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.UsePanel;
import manage.appli.patri.awb.modele.UsePgm;



@Transactional
@Service("usepgmService")
public class UsePgmServiceImp implements UsePgmService {

	@Autowired
	SessionFactory sessionfactory ;
	
	@Override
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from UsePgm").list().size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsePgm> findAll(int page) {
		// TODO Auto-generated method stub

		List<UsePgm> res = sessionfactory.getCurrentSession().createQuery("from UsePgm").list(); 

		if (res != null) {
			Iterator<UsePgm> it = res.iterator();
			UsePgm current = null;
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
	public List<UsePgm> findByName(String name) {
		// TODO Auto-generated method stub
		
		List<UsePgm> res = sessionfactory.getCurrentSession().createQuery("from UsePgm where id.name='"+name+"'").list(); 

		if (res != null) {
			Iterator<UsePgm> it = res.iterator();
			UsePgm current = null;
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
	public List<UsePgm> findByPrograms(String name) {
		// TODO Auto-generated method stub
	
		List<UsePgm> res = sessionfactory.getCurrentSession().createQuery("from UsePgm where programs.id.name='"+name+"'").list(); 

		if (res != null) {
			Iterator<UsePgm> it = res.iterator();
			UsePgm current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;

	}

}
