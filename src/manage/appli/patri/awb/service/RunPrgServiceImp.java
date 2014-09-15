package manage.appli.patri.awb.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manage.appli.patri.awb.modele.Cft;
import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.JobAppel;
import manage.appli.patri.awb.modele.Patrimoine;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.modele.RelatSliSched;
import manage.appli.patri.awb.modele.RunPrg;

@Transactional
@Service("runprgService")
public class RunPrgServiceImp implements RunPrgService {

	@Autowired
	SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RunPrg> findAll(int page) {
		// TODO Auto-generated method stub

		List<RunPrg> res = (new Page(sessionfactory.getCurrentSession()
				.createQuery("from RunPrg"), page, 50).getList());

		if (res != null) {
			Iterator<RunPrg> it = res.iterator();
			RunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RunPrg> findByPrograms(String name) {
		// TODO Auto-generated method stub

		List<RunPrg> res = sessionfactory.getCurrentSession()
				.createQuery("from RunPrg where id.programs='" + name + "'")
				.list();

		if (res != null) {
			Iterator<RunPrg> it = res.iterator();
			RunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RunPrg> findByJobAppel(String name) {
		// TODO Auto-generated method stub

		List<RunPrg> res = sessionfactory.getCurrentSession()
				.createQuery("from RunPrg where id.jobAppel='" + name + "'")
				.list();

		if (res != null) {
			Iterator<RunPrg> it = res.iterator();
			RunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RunPrg> findByProgram(Programs name) {
		// TODO Auto-generated method stub
		List<RunPrg> res = sessionfactory.getCurrentSession()
				.createQuery("from RunPrg where programs='" + name + "'")
				.list();

		if (res != null) {
			Iterator<RunPrg> it = res.iterator();
			RunPrg current = null;
			while (it.hasNext()) {
				current = it.next();
				Hibernate.initialize(current.getId());
				Hibernate.initialize(current.getJobAppel());
				Hibernate.initialize(current.getPrograms());

			}
		}
		return res;
	}

	@Override
	public List<RunPrg> findAllDouble() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<String> rest = (List<String>) sessionfactory
				.getCurrentSession()
				.createSQLQuery(
						" ((select PROGRAMS from RUN_PRG where system='$ZA' ) intersect (select PROGRAMS from RUN_PRG where system='$YA' )) union ((select PROGRAMS from RUN_PRG where system='$ZA' ) intersect (select PROGRAMS from RUN_PRG where system='$XA' )) union ((select PROGRAMS from RUN_PRG where system='$ZA' ) intersect (select PROGRAMS from RUN_PRG where system='$IE' )) union ((select PROGRAMS from RUN_PRG where system='$XA' ) intersect (select PROGRAMS from RUN_PRG where system='$IE' )) union ((select PROGRAMS from RUN_PRG where system='$YA' ) intersect (select PROGRAMS from RUN_PRG where system='$IE' )) union ((select PROGRAMS from RUN_PRG where system='$YA' ) intersect (select PROGRAMS from RUN_PRG where system='$XA' )) union ((select PROGRAMS from RUN_PRG where system='$ID' ) intersect (select PROGRAMS from RUN_PRG where system='$IE' )) union ((select PROGRAMS from RUN_PRG where system='$ZA' ) intersect (select PROGRAMS from RUN_PRG where system='$ID' )) union ((select PROGRAMS from RUN_PRG where system='$ID' ) intersect (select PROGRAMS from RUN_PRG where system='$XA' ))union ((select PROGRAMS from RUN_PRG where system='$YA' ) intersect (select PROGRAMS from RUN_PRG where system='$ID' ))  ")
				.list();

		Iterator<String> it = rest.iterator();
		List<RunPrg> res = new LinkedList<RunPrg>();
		List<RunPrg> finals = new LinkedList<RunPrg>();
		String current = null;
		while (it.hasNext()) {
			current = it.next();
			res = RunPrgServiceImp.this.findByPrograms(current);
			if (res != null)
				finals.addAll(res);
		}
		if (finals != null) {
			Iterator<RunPrg> its = finals.iterator();
			RunPrg currents = null;
			while (its.hasNext()) {
				currents = its.next();
				Hibernate.initialize(currents.getId());
				Hibernate.initialize(currents.getJobAppel());
				Hibernate.initialize(currents.getPrograms());

			}
		}
		return finals;
	}

	@Override
	public List<RunPrg> findDoubleNamespi(String PROGRAMS) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<String> rest = (List<String>) sessionfactory
				.getCurrentSession()
				.createSQLQuery(
						" ((select PROGRAMS from RUN_PRG where system='$ZA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$YA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$ZA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$XA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$ZA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$IE' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$XA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$IE' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$YA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$IE' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$YA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$XA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$ID' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$IE' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$ZA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$ID' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') ) union ((select PROGRAMS from RUN_PRG where system='$ID' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$XA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%'))union ((select PROGRAMS from RUN_PRG where system='$YA' and PROGRAMS like '"
								+ PROGRAMS
								+ "%') intersect (select PROGRAMS from RUN_PRG where system='$ID' and PROGRAMS like '"
								+ PROGRAMS + "%'))  ").list();

		Iterator<String> it = rest.iterator();
		List<RunPrg> res = new LinkedList<RunPrg>();
		List<RunPrg> finals = new LinkedList<RunPrg>();
		String current = null;
		while (it.hasNext()) {
			current = it.next();
			res = RunPrgServiceImp.this.findByPrograms(current);
			if (res != null)
				finals.addAll(res);
		}

		if (finals != null) {
			Iterator<RunPrg> its = finals.iterator();
			RunPrg currents = null;
			while (its.hasNext()) {
				currents = its.next();
				Hibernate.initialize(currents.getId());
				Hibernate.initialize(currents.getJobAppel());
				Hibernate.initialize(currents.getPrograms());

			}
		}
		return finals;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patrimoine> findPatrimoine(String name) {
		// TODO Auto-generated method stub
		List<RelatSliSched> res = sessionfactory.getCurrentSession()
				.createQuery("from RelatSliSched where id.job='" + name + "'")
				.list();
		Iterator<RelatSliSched> it = res.iterator();
		RelatSliSched current = null;
		List<Patrimoine> last = new LinkedList<Patrimoine>();
		String sli = null;
		String schedule = null;
		String autoselect = null;
		String jobappel = null;
		String pgm = null;
		String dataview = null;
		String table = null;
		String area = null;
		String dbname = null;
		String dbid = null;
		String database = null;
		String system = null;
		String partenaire = null;
		String idf = null;
		String parametre = null;
		while (it.hasNext()) {

			current = it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getSli());
			Hibernate.initialize(current.getScheduler());
			sli = current.getId().getJob();
			schedule = current.getId().getSchedule();
			autoselect=current.getScheduler().getAutoselect();
			JobAppel jobsap = new JobAppel();
			Hibernate.initialize(current.getSli().getJobAppel());
			jobsap = current.getSli().getJobAppel();
			jobappel = jobsap.getJobAppel();
			Set<RunPrg> runprgs = jobsap.getRunPrgs();
			  Set<Cft> cft=jobsap.getCfts();
			
				Iterator<Cft> itcft=cft.iterator();
				partenaire = "";
				 idf = "";
				 parametre = "";
			if(runprgs.size()==0) 
			{
				pgm = "";
				 dataview = "";
				 table = "";
				 area = "";
				 dbname = "";
				 dbid = "";
				 database = "";
				 system = "";
			}
				 while(itcft.hasNext()){
					Cft cfts = itcft.next();
					parametre=cfts.getId().getParm();
					partenaire=cfts.getId().getPart();
					idf=cfts.getId().getIdf();
					Patrimoine element = new Patrimoine(sli, schedule,autoselect,
							jobappel, "", "", "", "", "", "",
							"", "", partenaire,idf,parametre);
					last.add(element);
					
				}
				
				
				 if(runprgs.size()==0 && cft.size()==0) {
						Patrimoine element = new Patrimoine(sli, schedule,autoselect,
								jobappel, "", "", "", "", "", "",
								"", "", "","","");
						last.add(element);
						
					}

			Iterator<RunPrg> iter = runprgs.iterator();
			
			while (iter.hasNext()) {
				RunPrg elem = iter.next();
				Hibernate.initialize(elem.getPrograms());
				Programs pgms = elem.getPrograms();
				pgm = pgms.getId().getName();
				system = pgms.getId().getSystem();
				Set<RelatDatacom> datacom = pgms.getRelatDatacoms();
				Iterator<RelatDatacom> itdata = datacom.iterator();
				while (itdata.hasNext()) {
					RelatDatacom elemrel = itdata.next();
					Hibernate.initialize(elemrel.getDataviewDatacom());
					DataviewDatacom dcom = elemrel.getDataviewDatacom();
					dataview = dcom.getDataview();
					Hibernate.initialize(dcom.getTableAwb());
					table = dcom.getTableAwb().getName();
					Hibernate.initialize(dcom.getTableAwb().getAreaAwb());
					area = dcom.getTableAwb().getAreaAwb().getName();
					dbname = dcom.getTableAwb().getAreaAwb().getDbname();
					Hibernate.initialize(dcom.getTableAwb().getAreaAwb().getDatabaseAwb());
					dbid = dcom.getTableAwb().getAreaAwb().getDatabaseAwb()
							.getDbid();
					database = dcom.getTableAwb().getAreaAwb().getDatabaseAwb()
							.getName();
					Patrimoine element = new Patrimoine(sli, schedule,autoselect,
							jobappel, pgm, dataview, table, area, dbname, dbid,
							database, system,partenaire,idf,parametre);
					last.add(element);

				}

			}

		}
		return last;
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Patrimoine> findPatrimoinespi(String name) {
		// TODO Auto-generated method stub
		List<RelatSliSched> res = sessionfactory.getCurrentSession()
				.createQuery("from RelatSliSched where id.job like '" + name + "%'")
				.list();
		Iterator<RelatSliSched> it = res.iterator();
		RelatSliSched current = null;
		List<Patrimoine> last = new LinkedList<Patrimoine>();
		String sli = null;
		String schedule = null;
		String autoselect = null;
		String jobappel = null;
		String pgm = null;
		String dataview = null;
		String table = null;
		String area = null;
		String dbname = null;
		String dbid = null;
		String database = null;
		String system = null;
		String partenaire = null;
		String idf = null;
		String parametre = null;
		while (it.hasNext()) {

			current = it.next();
			Hibernate.initialize(current.getId());
			Hibernate.initialize(current.getSli());
			Hibernate.initialize(current.getScheduler());
			sli = current.getId().getJob();
			schedule = current.getId().getSchedule();
			autoselect=current.getScheduler().getAutoselect();
			JobAppel jobsap = new JobAppel();
			Hibernate.initialize(current.getSli().getJobAppel());
			jobsap = current.getSli().getJobAppel();
			jobappel = jobsap.getJobAppel();
			Set<RunPrg> runprgs = jobsap.getRunPrgs();
			  Set<Cft> cft=jobsap.getCfts();
			
				Iterator<Cft> itcft=cft.iterator();
				partenaire = "";
				 idf = "";
				 parametre = "";
			if(runprgs.size()==0) 
			{
				pgm = "";
				 dataview = "";
				 table = "";
				 area = "";
				 dbname = "";
				 dbid = "";
				 database = "";
				 system = "";
			}
				 while(itcft.hasNext()){
					Cft cfts = itcft.next();
					parametre=cfts.getId().getParm();
					partenaire=cfts.getId().getPart();
					idf=cfts.getId().getIdf();
					Patrimoine element = new Patrimoine(sli, schedule,autoselect,
							jobappel, "", "", "", "", "", "",
							"", "", partenaire,idf,parametre);
					last.add(element);
					
				}
				
				
				 if(runprgs.size()==0 && cft.size()==0) {
						Patrimoine element = new Patrimoine(sli, schedule,autoselect,
								jobappel, "", "", "", "", "", "",
								"", "", "","","");
						last.add(element);
						
					}

			Iterator<RunPrg> iter = runprgs.iterator();
			
			while (iter.hasNext()) {
				RunPrg elem = iter.next();
				Hibernate.initialize(elem.getPrograms());
				Programs pgms = elem.getPrograms();
				pgm = pgms.getId().getName();
				system = pgms.getId().getSystem();
				Set<RelatDatacom> datacom = pgms.getRelatDatacoms();
				Iterator<RelatDatacom> itdata = datacom.iterator();
				while (itdata.hasNext()) {
					RelatDatacom elemrel = itdata.next();
					Hibernate.initialize(elemrel.getDataviewDatacom());
					DataviewDatacom dcom = elemrel.getDataviewDatacom();
					dataview = dcom.getDataview();
					Hibernate.initialize(dcom.getTableAwb());
					table = dcom.getTableAwb().getName();
					Hibernate.initialize(dcom.getTableAwb().getAreaAwb());
					area = dcom.getTableAwb().getAreaAwb().getName();
					dbname = dcom.getTableAwb().getAreaAwb().getDbname();
					Hibernate.initialize(dcom.getTableAwb().getAreaAwb().getDatabaseAwb());
					dbid = dcom.getTableAwb().getAreaAwb().getDatabaseAwb()
							.getDbid();
					database = dcom.getTableAwb().getAreaAwb().getDatabaseAwb()
							.getName();
					Patrimoine element = new Patrimoine(sli, schedule,autoselect,
							jobappel, pgm, dataview, table, area, dbname, dbid,
							database, system,partenaire,idf,parametre);
					last.add(element);

				}

			}

		}
		return last;
	
	}

}
