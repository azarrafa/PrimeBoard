package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.AnomRunPrg;

@Transactional
@Service("anomrunprgService")
public class AnomRunPrgServiceImp implements AnomRunPrgService {

	@Autowired
	private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<AnomRunPrg> findAll() {
		// TODO Auto-generated method stub
		List<AnomRunPrg> res = sessionfactory.getCurrentSession()
				.createQuery("from AnomRunPrg").list();
		if (res != null) {
			Iterator<AnomRunPrg> it = res.iterator();
			AnomRunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());

			}

		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnomRunPrg> findByJobAppel(String name) {
		// TODO Auto-generated method stub
		return sessionfactory
				.getCurrentSession()
				.createQuery("from AnomRunPrg where id.jobAppel='" + name + "'")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnomRunPrg> findByPrograms(String name) {
		// TODO Auto-generated method stub

		List<AnomRunPrg> res = sessionfactory
				.getCurrentSession()
				.createQuery("from AnomRunPrg where id.programs='" + name + "'")
				.list();
		if (res != null) {
			Iterator<AnomRunPrg> it = res.iterator();
			AnomRunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());

			}

		}
		return res;
	}

	@Override
	public List<AnomRunPrg> findByJob(String name) {
		// TODO Auto-generated method stub
		List<AnomRunPrg> res = sessionfactory
				.getCurrentSession()
				.createQuery(
						"from AnomRunPrg where jobAppel.job='" + name + "'")
				.list();
		if (res != null) {
			Iterator<AnomRunPrg> it = res.iterator();
			AnomRunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());

			}

		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnomRunPrg> findByJobspi(String name) {
		// TODO Auto-generated method stub
		List<AnomRunPrg> res = sessionfactory
				.getCurrentSession()
				.createQuery(
						"from AnomRunPrg where jobAppel.job like '" + name
								+ "%'").list();
		if (res != null) {
			Iterator<AnomRunPrg> it = res.iterator();
			AnomRunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());

			}

		}
		return res;
	}

	@Override
	public List<AnomRunPrg> findByProgramspi(String name) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<AnomRunPrg> res = sessionfactory
				.getCurrentSession()
				.createQuery(
						"from AnomRunPrg where id.programs like '" + name
								+ "%'").list();
		if (res != null) {
			Iterator<AnomRunPrg> it = res.iterator();
			AnomRunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());

			}

		}
		return res;
	}

}
