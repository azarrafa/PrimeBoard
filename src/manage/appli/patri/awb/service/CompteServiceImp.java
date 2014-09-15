package manage.appli.patri.awb.service;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("compteService")
@Transactional
public class CompteServiceImp implements CompteService {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Countdetails> findcount() {
		// TODO Auto-generated method stub
		Countdetails current = null;
		List<Countdetails> res = new LinkedList<Countdetails>();

		current = new Countdetails("Database", sessionfactory
				.getCurrentSession().createQuery("from DatabaseAwb").list()
				.size());
		res.add(current);
		current = new Countdetails("Area", sessionfactory.getCurrentSession()
				.createQuery("from AreaAwb").list().size());
		res.add(current);
		current = new Countdetails("Table", sessionfactory.getCurrentSession()
				.createQuery("from TableAwb").list().size());
		res.add(current);
		current = new Countdetails("Dataview datacom", sessionfactory
				.getCurrentSession().createQuery("from DataviewDatacom").list()
				.size());
		res.add(current);
		current = new Countdetails("Dataview Ideal", sessionfactory
				.getCurrentSession().createQuery("from DataviewIdeal").list()
				.size());
		res.add(current);
		current = new Countdetails("Programs", sessionfactory
				.getCurrentSession().createQuery("from Programs").list().size());
		res.add(current);
		current = new Countdetails("Sli", sessionfactory.getCurrentSession()
				.createQuery("from Sli").list().size());
		res.add(current);
		current = new Countdetails("Schedule", sessionfactory
				.getCurrentSession().createQuery("from Scheduler").list()
				.size());
		res.add(current);

		return res;

	}
}
