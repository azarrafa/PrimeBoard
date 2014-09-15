package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.TableAwb;
import manage.appli.patri.awb.modele.Urt;

@Transactional
@Service("urtService")
public class UrtServiceImp implements UrtService {

	@Autowired
	SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Urt> findAll(int page) {
		// TODO Auto-generated method stub

		List<Urt> res =sessionfactory.getCurrentSession()
				.createQuery("from Urt ").list();

		if (res != null) {
			Iterator<Urt> it = res.iterator();
			Urt current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getId());

			}
		}
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Urt> findByUrt(String urt) {
		// TODO Auto-generated method stub

		List<Urt> res = sessionfactory.getCurrentSession()
				.createQuery("from Urt where id.urt='" + urt + "'").list();

		if (res != null) {
			Iterator<Urt> it = res.iterator();
			Urt current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getId());

			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Urt> findByJobappel(String jobappel) {
		// TODO Auto-generated method stub

		List<Urt> res = sessionfactory.getCurrentSession()
				.createQuery("from Urt where id.jobAppel='" + jobappel + "'")
				.list();

		if (res != null) {
			Iterator<Urt> it = res.iterator();
			Urt current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getId());

			}
		}
		return res;
	}

}
