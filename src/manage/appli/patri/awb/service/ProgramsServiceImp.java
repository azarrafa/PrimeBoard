package manage.appli.patri.awb.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.ProgramModele;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.ProgramsId;
import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.modele.RelatIdeal;
import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.modele.UsePanel;
import manage.appli.patri.awb.modele.UsePgm;
import manage.appli.patri.awb.modele.UseReport;

@Service("programsService")
@Transactional
public class ProgramsServiceImp implements ProgramsService {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findAll(int page) {
		// TODO Auto-generated method stub

		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession().createQuery("from Programs").list();

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());

				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramModele> findAlls(String name) {
		// TODO Auto-generated method stub

		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery("from Programs where id.name like '" + name + "%'")
				.list();

		List<ProgramModele> finals = new LinkedList<ProgramModele>();
		String program = "";

		String rprogram = "";

		String version = "";

		String system = "";

		String panel = "";

		String report = "";

		String dataviewdc = "";

		String dataviewid = "";

		String sli = "";

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				program = "";
				version = "";
				system = "";

				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				program = current.getId().getName();
				system = current.getId().getSystem();
				version = current.getId().getVersion();
				List<Integer> coun = new LinkedList<Integer>();
				Iterator<RelatDatacom> itidc = null;
				Iterator<RelatIdeal> itide = null;
				Iterator<UsePanel> itpnl = null;
				Iterator<UsePgm> itpgm = null;
				Iterator<UseReport> itrprt = null;
				Iterator<RunPrg> itsli = null;

				if (current.getRelatDatacoms() != null) {
					Hibernate.initialize(current.getRelatDatacoms());
					itidc = current.getRelatDatacoms().iterator();
					coun.add(current.getRelatDatacoms().size());
				}
				if (current.getRelatIdeals() != null) {
					Hibernate.initialize(current.getRelatIdeals());
					itide = current.getRelatIdeals().iterator();
					coun.add(current.getRelatIdeals().size());
				}
				if (current.getUsePanels() != null) {
					Hibernate.initialize(current.getUsePanels());
					itpnl = current.getUsePanels().iterator();
				}
				if (current.getUsePgms() != null) {
					Hibernate.initialize(current.getUsePgms());
					itpgm = current.getUsePgms().iterator();
					coun.add(current.getUsePgms().size());
				}
				if (current.getUseReports() != null) {
					Hibernate.initialize(current.getUseReports());
					itrprt = current.getUseReports().iterator();
					coun.add(current.getUseReports().size());
				}
				if (current.getRunPrgs() != null) {

					Hibernate.initialize(current.getRunPrgs());
					itsli = current.getRunPrgs().iterator();
					coun.add(current.getRunPrgs().size());

				}
				panel = "";
				report = "";
				dataviewdc = "";
				dataviewid = "";
				sli = "";
				for (int i = 0; i < Collections.max(coun); i++) {
					

					if (itidc == null)
						dataviewdc = "";
					else if (itidc.hasNext())
						dataviewdc = itidc.next().getId().getDataview();
					if (itide == null)
						dataviewid = "";
					else if (itide.hasNext())
						dataviewid = itide.next().getId().getDataview();
					if (itpnl == null)
						panel = "";
					else if (itpnl.hasNext())
						panel = itpnl.next().getId().getPanel();
					if (itrprt == null)
						report = "";
					else if (itrprt.hasNext())
						report = itrprt.next().getId().getReport();
					if (itpgm == null)
						rprogram = "";
					else if (itpgm.hasNext())
						rprogram = itpgm.next().getId().getName();
					if (itsli == null)
						sli = "";
					else if (itsli.hasNext()) {
						RunPrg machakil = itsli.next();
						Hibernate.initialize(machakil.getJobAppel().getJob());
						sli = machakil.getJobAppel().getJob();
					}

					ProgramModele progm = new ProgramModele(program, version,
							system, panel, report, dataviewdc, dataviewid, sli,
							rprogram);
					finals.add(progm);
				}
				coun.clear();
			}
		}
		return finals;
	}

	@Override
	public Programs findById(ProgramsId id) {
		// TODO Auto-generated method stub

		Programs current = (Programs) sessionFactory.getCurrentSession().get(
				Programs.class, id);

		if (current != null) {

			if (current.getId() != null)
				Hibernate.initialize(current.getId());
			if (current.getRelatDatacoms() != null)
				Hibernate.initialize(current.getRelatDatacoms());
			if (current.getRelatIdeals() != null)
				Hibernate.initialize(current.getRelatIdeals());
			if (current.getUsePanels() != null)
				Hibernate.initialize(current.getUsePanels());
			if (current.getUsePgms() != null)
				Hibernate.initialize(current.getUsePgms());
			if (current.getUseReports() != null)
				Hibernate.initialize(current.getUseReports());
			if (current.getRunPrgs() != null)
				Hibernate.initialize(current.getRunPrgs());

		}
		return current;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findByName(String name) {
		// TODO Auto-generated method stub

		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery("from Programs where id.name='" + name + "'")
				.list();

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findByNamespi(String name) {
		// TODO Auto-generated method stub
		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery("from Programs where id.name like '" + name + "%'")
				.list();

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findBySystem(String system) {
		// TODO Auto-generated method stub

		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery("from Programs where id.system='" + system + "'")
				.list();

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findByStatus(String status) {
		// TODO Auto-generated method stub

		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery("from Programs where status='" + status + "'")
				.list();

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findByDate(String date) {
		// TODO Auto-generated method stub

		List<Programs> res = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery("from Programs where dateModified='" + date + "'")
				.list();

		if (res != null) {
			Iterator<Programs> it = res.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> getDoublant() {
		// TODO Auto-generated method stub
		List<String> res = (List<String>) sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						" ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$YA' )) union ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$XA' )) union ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$XA' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$YA' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$YA' ) intersect (select name from PROGRAMS where system='$XA' )) union ((select name from PROGRAMS where system='$ID' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$ID' )) union ((select name from PROGRAMS where system='$ID' ) intersect (select name from PROGRAMS where system='$XA' ))union ((select name from PROGRAMS where system='$YA' ) intersect (select name from PROGRAMS where system='$ID' ))  ")
				.list();
		List<Programs> prog = new LinkedList<Programs>();
		List<Programs> tmp = new LinkedList<Programs>();
		Iterator<String> its = res.iterator();
		// Programs current=null;

		while (its.hasNext()) {

			tmp = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Programs where id.name='" + its.next() + "'")
					.list();
			prog.addAll(tmp);

		}

		if (prog != null) {
			Iterator<Programs> it = prog.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}
		return prog;
	}

	@Override
	public List<Programs> doublantname(String name) {
		@SuppressWarnings("unchecked")
		List<String> res = (List<String>) sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						" ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$YA' )) union ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$XA' )) union ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$XA' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$YA' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$YA' ) intersect (select name from PROGRAMS where system='$XA' )) union ((select name from PROGRAMS where system='$ID' ) intersect (select name from PROGRAMS where system='$IE' )) union ((select name from PROGRAMS where system='$ZA' ) intersect (select name from PROGRAMS where system='$ID' )) union ((select name from PROGRAMS where system='$ID' ) intersect (select name from PROGRAMS where system='$XA' ))union ((select name from PROGRAMS where system='$YA' ) intersect (select name from PROGRAMS where system='$ID' ))  ")
				.list();
		List<Programs> resultat = new LinkedList<Programs>();
		if (res.contains(name))
			resultat = ProgramsServiceImp.this.findByName(name);
		if (resultat != null) {
			Iterator<Programs> it = resultat.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}

		return resultat;
	}

	@Override
	public List<Programs> doublantnamespi(String name) {
		@SuppressWarnings("unchecked")
		List<String> res = (List<String>) sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						" ( (select name from PROGRAMS where system='$ZA' and name like '"
								+ name
								+ "%' ) intersect (select name from PROGRAMS where system='$YA' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$ZA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$XA' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$ZA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$IE' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$XA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$IE' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$YA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$IE' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$YA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$XA' and name like '"
								+ name
								+ "%' )) union ((select name from PROGRAMS where system='$ID' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$IE' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$ZA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$ID' and name like '"
								+ name
								+ "%')) union ((select name from PROGRAMS where system='$ID' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$XA' and name like '"
								+ name
								+ "%'))union ((select name from PROGRAMS where system='$YA' and name like '"
								+ name
								+ "%') intersect (select name from PROGRAMS where system='$ID' and name like '"
								+ name + "%'))  ").list();
		List<Programs> resultat = new LinkedList<Programs>();

		Iterator<String> its = res.iterator();
		while (its.hasNext()) {

			resultat.addAll(this.findByName(its.next()));
		}
		if (resultat != null) {
			Iterator<Programs> it = resultat.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}

		return resultat;
	}

	@Override
	public List<Programs> Doublantnotrun() {
		// TODO Auto-generated method stub
		List<Programs> finals = new LinkedList<Programs>();
		List<Programs> res = new LinkedList<Programs>();
		res = this.getDoublant();
		Iterator<Programs> its = res.iterator();

		while (its.hasNext()) {
			Programs current = its.next();
			if (!this.isrunning(current.getId().getName())){
				finals.add(current);
			
			}
		}
		
		

		return finals;

	}

	@Override
	public List<Programs> Doublantrun() {
		// TODO Auto-generated method stub
		List<Programs> finals = new LinkedList<Programs>();
		List<Programs> res = new LinkedList<Programs>();
		res = this.getDoublant();
		Iterator<Programs> its = res.iterator();

		while (its.hasNext()) {
			Programs current = its.next();
			if (!this.isrunning(current.getId().getName())){
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());
				finals.add(current);
				
				
			}
				

		}
	

		return finals;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findNotrunning(String name) {
		// TODO Auto-generated method stub

		List<Programs> rest = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Programs where runPrgs.size=0 and id.name like '"
								+ name + "%'").list();
		if (rest != null) {
			Iterator<Programs> it = rest.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}

		return rest;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Programs> findrunning(String name) {
		// TODO Auto-generated method stub
		List<Programs> rest = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Programs where runPrgs.size!=0 and id.name like '"
								+ name + "%'").list();
		if (rest != null) {
			Iterator<Programs> it = rest.iterator();
			Programs current = null;
			while (it.hasNext()) {
				current = it.next();
				if (current.getId() != null)
					Hibernate.initialize(current.getId());
				if (current.getRelatDatacoms() != null)
					Hibernate.initialize(current.getRelatDatacoms());
				if (current.getRelatIdeals() != null)
					Hibernate.initialize(current.getRelatIdeals());
				if (current.getUsePanels() != null)
					Hibernate.initialize(current.getUsePanels());
				if (current.getUsePgms() != null)
					Hibernate.initialize(current.getUsePgms());
				if (current.getUseReports() != null)
					Hibernate.initialize(current.getUseReports());
				if (current.getRunPrgs() != null)
					Hibernate.initialize(current.getRunPrgs());

			}
		}

		return rest;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isrunning(String name) {
		// TODO Auto-generated method stub
		List<Programs> rest = (List<Programs>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Programs where runPrgs.size!=0 and id.name='"
								+ name + "'").list();
		if (rest.size() == 0)
			return false;
		else
			return true;

	}

}
