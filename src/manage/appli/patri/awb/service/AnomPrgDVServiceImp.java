package manage.appli.patri.awb.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.AnomPrgDv;

@Transactional
@Service("anomprgdvService")
public class AnomPrgDVServiceImp implements AnomPrgDVService {

	@Autowired
	private SessionFactory sessionfactory ; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AnomPrgDv> findAll() {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createQuery("from AnomPrgDv").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnomPrgDv> findByPrograms(String name) {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createQuery("from AnomPrgDv where id.programs='"+name+"'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnomPrgDv> findByDataview(String name) {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createQuery("from AnomPrgDv where id.dataview='"+name+"'").list();
	}
	
	

}
