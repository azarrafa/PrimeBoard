package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.DatabaseAwb;
import manage.appli.patri.awb.modele.DataviewDatacom;

@Service("dataviewdatacomService")
@Transactional
public class DataviewDatacomServiceImp implements DataviewDatacomService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int getcount() {

		return sessionFactory.getCurrentSession()
				.createQuery("from DataviewDatacom").list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataviewDatacom> findAll(int page) {
		// TODO Auto-generated method stub

		List<DataviewDatacom> res = sessionFactory.getCurrentSession()
				.createQuery("from DataviewDatacom").list();

		if (res != null) {
			Iterator<DataviewDatacom> it = res.iterator();
			DataviewDatacom current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getRelatDatacoms());
				Hibernate.initialize(current.getTableAwb());
				Hibernate.initialize(current.getTableAwb().getAreaAwb()
						.getDatabaseAwb());

			}
		}
		return res;
	}

	@Override
	public List<DataviewDatacom> findByNamespi(String name) {
		List<DataviewDatacom> res = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from DataviewDatacom where dataview like '" + name
								+ "%'").list();

		if (res != null) {
			Iterator<DataviewDatacom> it = res.iterator();
			DataviewDatacom current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getRelatDatacoms());
				Hibernate.initialize(current.getTableAwb());
				Hibernate.initialize(current.getTableAwb().getAreaAwb()
						.getDatabaseAwb());

			}
		}
		return res;
	}

	@Override
	public DataviewDatacom findByName(String name) {
		// TODO Auto-generated method stub

		DataviewDatacom res = (DataviewDatacom) sessionFactory
				.getCurrentSession().get(DataviewDatacom.class, name);

		if (res != null) {

			Hibernate.initialize(res.getRelatDatacoms());
			Hibernate.initialize(res.getTableAwb());
			Hibernate.initialize(res.getTableAwb().getAreaAwb()
					.getDatabaseAwb());

		}

		return res;
	}

	@Override
	public List<DataviewDatacom> findBydatabase(String name) {
		// TODO Auto-generated method stub
		List<DataviewDatacom> res = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from DataviewDatacom where tableAwb.areaAwb.databaseAwb.name='"
								+ name + "'").list();

		if (res != null) {
			Iterator<DataviewDatacom> it = res.iterator();
			DataviewDatacom current = null;
			while (it.hasNext()) {
				current = it.next();
			
				Hibernate.initialize(current.getTableAwb());
				Hibernate.initialize(current.getTableAwb().getAreaAwb()
						.getDatabaseAwb());

			}
		}
		return res;
	}

	@Override
	public List<DataviewDatacom> findBydatabasespi(String name) {
		List<DataviewDatacom> res = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from DataviewDatacom where tableAwb.areaAwb.databaseAwb.name like '"
								+ name + "%'").list();

		if (res != null) {
			Iterator<DataviewDatacom> it = res.iterator();
			DataviewDatacom current = null;
			while (it.hasNext()) {
				current = it.next();
			
				Hibernate.initialize(current.getTableAwb());
				Hibernate.initialize(current.getTableAwb().getAreaAwb()
						.getDatabaseAwb());

			}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataviewDatacom> findByArea(String name) {
		List<DataviewDatacom> res = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from DataviewDatacom where tableAwb.areaAwb.name='"
								+ name + "'").list();

		if (res != null) {
			Iterator<DataviewDatacom> it = res.iterator();
			DataviewDatacom current = null;
			while (it.hasNext()) {
				current = it.next();
			
				Hibernate.initialize(current.getTableAwb());
				Hibernate.initialize(current.getTableAwb().getAreaAwb()
						.getDatabaseAwb());

			}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DataviewDatacom> findByAreaspi(String name) {
		List<DataviewDatacom> res = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from DataviewDatacom where tableAwb.areaAwb.name like '"
								+ name + "%'").list();

		if (res != null) {
			Iterator<DataviewDatacom> it = res.iterator();
			DataviewDatacom current = null;
			while (it.hasNext()) {
				current = it.next();
			
				Hibernate.initialize(current.getTableAwb());
				Hibernate.initialize(current.getTableAwb().getAreaAwb()
						.getDatabaseAwb());

			}
		}
		return res;
	}

}
