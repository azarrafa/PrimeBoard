package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.UsePgm;
import manage.appli.patri.awb.modele.UseReport;


@Transactional
@Service("usereportService")
public class UseReportServiceImp implements UseReportService {

	@Autowired
	SessionFactory sessionfactory ;
	
	@Override
	public int getcount(){
		
		
		return sessionfactory.getCurrentSession().createQuery("from UseReport").list().size();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UseReport> findAll(int page) {
		// TODO Auto-generated method stub
		
		List<UseReport> res =sessionfactory.getCurrentSession().createQuery("from UseReport").list(); 

		if (res != null) {
			Iterator<UseReport> it = res.iterator();
			UseReport current = null;
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
	public List<UseReport> findByName(String name) {
		// TODO Auto-generated method stub
		
	List<UseReport> res =(List<UseReport>) sessionfactory.getCurrentSession().createQuery("from UseReport where id.report='"+name+"'").list(); 

		if (res != null) {
			Iterator<UseReport> it = res.iterator();
			UseReport current = null;
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
	public List<UseReport> findByPromgrams(String name) {
		// TODO Auto-generated method stub
	
		List<UseReport> res =(List<UseReport>) sessionfactory.getCurrentSession().createQuery("from UseReport where programs.id.name='"+name+"'").list(); 

		if (res != null) {
			Iterator<UseReport> it = res.iterator();
			UseReport current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;
	}

}
