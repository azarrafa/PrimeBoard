package manage.appli.patri.awb.web;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manage.appli.patri.awb.modele.AnomRunPrg;

import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.modele.Sli;
import manage.appli.patri.awb.service.AnomRunPrgService;

import manage.appli.patri.awb.service.RunPrgService;
import manage.appli.patri.awb.service.SliService;

@Component("sliBean")
@ViewScoped
public class SliBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private transient SliService sliservice;
	@Autowired
	private transient RunPrgService runservice;
	@Autowired
	private transient AnomRunPrgService anomalieservice;
	private List<Sli> listsli;
	private List<Sli> listslitmp;
	private List<RunPrg> listprog;
	private List<RunPrg> listprogtmp;
	private List<AnomRunPrg> listanom;
	private List<AnomRunPrg> listanomtmp;
	private Sli sli;
	private AnomRunPrg slianom;
	private List<String> selected;
	private Map<String, String> proprity;
	private String namesli;
	private String nameslianom;
	private String nameslianoms;
	private boolean nbjob;
	private boolean libmemb;
	private boolean class_;
	private boolean sublib;
	private boolean sysid;
	private boolean failcode;
	private boolean jobappel;
	private boolean runprog;
	private String progname;

	public String getNameslianoms() {
		return nameslianoms;
	}

	public void setNameslianoms(String nameslianoms) {
		this.nameslianoms = nameslianoms;
	}

	public List<RunPrg> getListprog() {
		return listprog;
	}

	public void setListprog(List<RunPrg> listprog) {
		this.listprog = listprog;
	}

	public String getProgname() {
		return progname;
	}

	public void setProgname(String progname) {
		this.progname = progname;
	}

	public String getNameslianom() {
		return nameslianom;
	}

	public void setNameslianom(String nameslianom) {
		this.nameslianom = nameslianom;
	}

	public List<AnomRunPrg> getListanom() {
		return listanom;
	}

	public void setListanom(List<AnomRunPrg> listanom) {
		this.listanom = listanom;
	}

	public boolean isJobappel() {
		return jobappel;
	}

	public void setJobappel(boolean jobappel) {
		this.jobappel = jobappel;
	}

	public boolean isRunprog() {
		return runprog;
	}

	public void setRunprog(boolean runprog) {
		this.runprog = runprog;
	}

	public boolean isLibmemb() {
		return libmemb;
	}

	public void setLibmemb(boolean libmemb) {
		this.libmemb = libmemb;
	}

	public boolean isClass_() {
		return class_;
	}

	public void setClass_(boolean class_) {
		this.class_ = class_;
	}

	public boolean isSublib() {
		return sublib;
	}

	public void setSublib(boolean sublib) {
		this.sublib = sublib;
	}

	public boolean isSysid() {
		return sysid;
	}

	public void setSysid(boolean sysid) {
		this.sysid = sysid;
	}

	public boolean isFailcode() {
		return failcode;
	}

	public void setFailcode(boolean failcode) {
		this.failcode = failcode;
	}

	public boolean isNbjob() {
		return nbjob;
	}

	public void setNbjob(boolean nbjob) {
		this.nbjob = nbjob;
	}

	public List<Sli> getListsli() {
		return listsli;
	}

	public void setListsli(List<Sli> listsli) {
		this.listsli = listsli;
	}

	public List<String> getSelected() {
		return selected;
	}

	public void setSelected(List<String> selected) {
		this.selected = selected;
	}

	public Map<String, String> getProprity() {
		return proprity;
	}

	public String getNamesli() {
		return namesli;
	}

	public void setNamesli(String namesli) {
		this.namesli = namesli;
	}

	public String getAlldata() {

		namesli = namesli.trim();
		if (namesli.equals("")) {

			listslitmp = sliservice.findAll(1);

			if (listslitmp.size() == 0) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/sli/error.jsf?faces-redirect=true";
			} else {
				listsli = listslitmp;
				return "/sections/sli/sli.jsf?faces-redirect=true";

			}

		} else {
			listsli = new LinkedList<Sli>();
			if (namesli.endsWith("*")) {
				listsli = sliservice.findByjobspi(namesli.replace("*", "")
						.toUpperCase());
				return "/sections/sli/sli.jsf?faces-redirect=true";
			} else
				sli = sliservice.findByjob(namesli.toUpperCase());
			if (sli == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"SLI inexistant"));
				return "/sections/sli/error.jsf?faces-redirect=true";
			} else {
				listsli.add(sli);
				return "/sections/sli/sli.jsf?faces-redirect=true";

			}
		}

	}

	public String getanomalie() {

		nameslianom = nameslianom.trim();
		if (nameslianom.equals("")) {

			listanomtmp = anomalieservice.findAll();

			if (listanomtmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/slianomalie/anomerror.jsf?faces-redirect=true";
			} else {
				listanom = listanomtmp;
				return "/sections/slianomalie/slianomalie.jsf?faces-redirect=true";

			}

		} else {
			listanom = new LinkedList<AnomRunPrg>();
			if (nameslianom.endsWith("*")) {
				listanomtmp = anomalieservice.findByProgramspi(nameslianom
						.replace("*", "").toUpperCase());
				if (listanomtmp == null)
					return "/sections/slianomalie/anomerror.jsf?faces-redirect=true";
				else {
					listanom = listanomtmp;
					return "/sections/slianomalie/slianomalie.jsf?faces-redirect=true";
				}
			} else
				listanomtmp = anomalieservice.findByPrograms(nameslianom
						.toUpperCase());
			if (listanomtmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"SLI inexistant"));
				return "/sections/slianomalie/anomerror.jsf?faces-redirect=true";
			} else {
				listanom = listanomtmp;
				return "/sections/slianomalie/slianomalie.jsf?faces-redirect=true";

			}
		}
	}

	public String getanomalies() {

		nameslianoms = nameslianoms.trim();
		if (nameslianoms.equals("")) {

			listanomtmp = anomalieservice.findAll();

			if (listanomtmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/slianomalie/anomerror.jsf?faces-redirect=true";
			} else {
				listanom = listanomtmp;
				return "/sections/slianomalie/slianomalie.jsf?faces-redirect=true";

			}

		} else {
			listanom = new LinkedList<AnomRunPrg>();
			
			if (nameslianoms.endsWith("*")) {
				listanomtmp = anomalieservice.findByJobspi(nameslianoms
						.replace("*", "").toUpperCase());
				if (listanomtmp == null)
					return "/sections/slianomalie/anomerror.jsf?faces-redirect=true";
				else {
					listanom = listanomtmp;
					return "/sections/slianomalie/slianomalie.jsf?faces-redirect=true";
				}
			} else
			listanomtmp = anomalieservice.findByJob(nameslianoms.toUpperCase());
			if (listanomtmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"SLI inexistant"));
				return "/sections/slianomalie/anomerror.jsf?faces-redirect=true";
			} else {
				listanom = listanomtmp;
				return "/sections/slianomalie/slianomalie.jsf?faces-redirect=true";

			}
		}
	}

	public String getprogram() {

		progname = progname.trim();
		if (progname.equals("")) {

			listprogtmp = runservice.findAll(1);

			if (listprogtmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/sli/error.jsf?faces-redirect=true";
			} else {
				listprog = listprogtmp;
				return "/sections/sli/sliprog.jsf?faces-redirect=true";

			}

		} else {
			listprog = new LinkedList<RunPrg>();
			listprogtmp = runservice.findByPrograms(progname.toUpperCase());
			if (listprogtmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"SLI inexistant"));
				return "/sections/sli/error.jsf?faces-redirect=true";
			} else {
				listprog = listprogtmp;
				return "/sections/sli/sliprog.jsf?faces-redirect=true";

			}
		}

	}

}
