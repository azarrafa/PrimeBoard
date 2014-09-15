package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.TableAwb;

@Service("tableawbService")
@Transactional
public class TableAwbServiceImp implements TableAwbService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int getcount() {

		return sessionFactory.getCurrentSession().createQuery("from TableAwb")
				.list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TableAwb> findAll(int page) {
		// TODO Auto-generated method stub

		List<TableAwb> res = sessionFactory.getCurrentSession()
				.createQuery("from TableAwb").list();

		if (res != null) {
			Iterator<TableAwb> it = res.iterator();
			TableAwb current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getAreaAwb());
				Hibernate.initialize(current.getDataviewDatacoms());
				Hibernate.initialize(current.getAreaAwb().getDatabaseAwb());

			}
		}
		return res;
	}

	@Override
	public List<TableAwb> findByNamespi(String name) {
		// TODO Auto-generated method stub
		List<TableAwb> res = sessionFactory.getCurrentSession()
				.createQuery("from TableAwb where name like '" + name + "%'")
				.list();

		if (res != null) {
			Iterator<TableAwb> it = res.iterator();
			TableAwb current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getAreaAwb());
				Hibernate.initialize(current.getDataviewDatacoms());

			}
		}
		return res;
	}

	@Override
	public TableAwb findByName(String name) {
		// TODO Auto-generated method stub

		TableAwb res = (TableAwb) sessionFactory.getCurrentSession().get(
				TableAwb.class, name);
		;

		if (res != null) {

			Hibernate.initialize(res.getAreaAwb());
			Hibernate.initialize(res.getDataviewDatacoms());

		}

		return res;
	}

	@Override
	public List<TableAwb> findBydatabase(String name) {
		List<TableAwb> result = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TableAwb where areaAwb.databaseAwb.name ='"
								+ name + "'").list();

		if (result != null) {
			Iterator<TableAwb> it = result.iterator();
			TableAwb current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getAreaAwb());
				Hibernate.initialize(current.getAreaAwb().getDatabaseAwb());

			}
		}
		return result;
	}

	@Override
	public List<TableAwb> findBydatabasespi(String name) {
		List<TableAwb> result = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TableAwb where areaAwb.databaseAwb.name like'"
								+ name + "%'").list();

		if (result != null) {
			Iterator<TableAwb> it = result.iterator();
			TableAwb current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getAreaAwb());
				Hibernate.initialize(current.getAreaAwb().getDatabaseAwb());

			}
		}
		return result;
	}
	
	
	@Override
	public List<TableAwb> findByArea(String name) {

		@SuppressWarnings("unchecked")
		List<TableAwb> result = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TableAwb where areaAwb.name ='"
								+ name + "'").list();

		if (result != null) {
			Iterator<TableAwb> it = result.iterator();
			TableAwb current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getAreaAwb());
				Hibernate.initialize(current.getAreaAwb().getDatabaseAwb());

			}
		}
		return result;
		
	}
	
	@Override
	public List<TableAwb> findByAreaspi(String name) {
		@SuppressWarnings("unchecked")
		List<TableAwb> result = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from TableAwb where areaAwb.name like '"
								+ name + "%'").list();

		if (result != null) {
			Iterator<TableAwb> it = result.iterator();
			TableAwb current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getAreaAwb());
				Hibernate.initialize(current.getAreaAwb().getDatabaseAwb());

			}
		}
		return result;
	}

}
