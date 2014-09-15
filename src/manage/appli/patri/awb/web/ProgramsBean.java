package manage.appli.patri.awb.web;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manage.appli.patri.awb.modele.AnomPrgDv;
import manage.appli.patri.awb.modele.ProgramModele;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.service.AnomPrgDVService;
import manage.appli.patri.awb.service.ProgramsService;
import manage.appli.patri.awb.service.RunPrgService;

@Component("programsBean")
@ViewScoped
public class ProgramsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient ProgramsService programsservice;
	@Autowired
	private transient AnomPrgDVService anomalieprg;
	@Autowired
	private transient RunPrgService runprg ;
	private List<ProgramModele> listprograms;
	private List<ProgramModele> listprogramstmp;
	private List<Programs> listdoublant;
	private List<Programs> listdoublanttmp;
	private List<AnomPrgDv> listprogramsanom;
	private List<AnomPrgDv> listprogramstmpanom;
	private List<RunPrg> listdoublerun;
	private List<RunPrg> listdoubleruntmp;
	private List<Programs> listdoublenotrun;
	private List<Programs> listdoublenotruntmp;
	private Programs progtmp;
	private String nameprograms;
	private String nameprograma;
	private String nameprogramstmp;
	private boolean panel;
	private boolean report;
	private boolean dataviewdc;
	private boolean dataviewid;
	private boolean prg;
	private boolean sli;
	

	public boolean isSli() {
		return sli;
	}

	public void setSli(boolean sli) {
		this.sli = sli;
	}

	public List<RunPrg> getListdoublerun() {
		return listdoublerun;
	}

	public void setListdoublerun(List<RunPrg> listdoublerun) {
		this.listdoublerun = listdoublerun;
	}

	public List<Programs> getListdoublenotrun() {
		return listdoublenotrun;
	}

	public void setListdoublenotrun(List<Programs> listdoublenotrun) {
		this.listdoublenotrun = listdoublenotrun;
	}

	public String getNameprograma() {
		return nameprograma;
	}

	public void setNameprograma(String nameprograma) {
		this.nameprograma = nameprograma;
	}

	public List<Programs> getListdoublant() {
		return listdoublant;
	}

	public void setListdoublant(List<Programs> listdoublant) {
		this.listdoublant = listdoublant;
	}

	public List<AnomPrgDv> getListprogramsanom() {
		return listprogramsanom;
	}

	public void setListprogramsanom(List<AnomPrgDv> listprogramsanom) {
		this.listprogramsanom = listprogramsanom;
	}

	public boolean isPrg() {
		return prg;
	}

	public void setPrg(boolean prg) {
		this.prg = prg;
	}

	public boolean isPanel() {
		return panel;
	}

	public void setPanel(boolean panel) {
		this.panel = panel;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public boolean isDataviewdc() {
		return dataviewdc;
	}

	public void setDataviewdc(boolean dataviewdc) {
		this.dataviewdc = dataviewdc;
	}

	public boolean isDataviewid() {
		return dataviewid;
	}

	public void setDataviewid(boolean dataviewid) {
		this.dataviewid = dataviewid;
	}

	public String getAlldata() {
		nameprograms = nameprograms.trim();

		if (nameprograms.equals("")) {
			listprogramstmp = programsservice.findAlls("");
			if (listprogramstmp.size()==0) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning",
								"la base est vide"));
				return "/sections/programs/error.jsf?faces-redirect=true";
			} else {
				listprograms = listprogramstmp;
				return "/sections/programs/programs.jsf?faces-redirect=true";
			}
		} else {
			listprograms = new LinkedList<ProgramModele>();
			if(nameprograms.endsWith("*")){
				listprogramstmp = programsservice.findAlls(nameprograms.replace("*", "").toUpperCase());
			}
			else
			listprogramstmp = programsservice.findAlls(nameprograms.toUpperCase());
			if (listprogramstmp.size()==0) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning",
								"Program inexistant"));
				return "/sections/programs/error.jsf?faces-redirect=true";
			} else {
				listprograms.clear();
				listprograms = listprogramstmp;
				return "/sections/programs/programs.jsf?faces-redirect=true";

			}

		}

	}

	public String getanomalie() {

		listprogramstmpanom = anomalieprg.findAll();

		if (listprogramstmpanom == null)
			return "/sections/programs/erroranom.jsf?faces-redirect=true";
		else {
			listprogramsanom = listprogramstmpanom;
			return "/sections/programs/anomalie.jsf?faces-redirect=true";
		}

	}

	public String getdoublant() {

		nameprograma = nameprograma.trim();

		if (nameprograma.equals("")) {
			listdoublanttmp = programsservice.getDoublant();
			if (listdoublanttmp == null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning",
								"la base est vide"));
				return "/sections/progdoublons/errordouble.jsf?faces-redirect=true";
			} else {
				listdoublant = listdoublanttmp;
				return "/sections/progdoublons/doublant.jsf?faces-redirect=true";
			}
		} else {
			listdoublant = new LinkedList<Programs>();
			
			if(nameprograma.endsWith("*")){
				listdoublanttmp = programsservice.doublantnamespi(nameprograma.replace("*", "").toUpperCase());
			}
			else
			listdoublanttmp = programsservice.doublantname(nameprograma.toUpperCase());
			

			if (listdoublanttmp==null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning",
								"Program inexistant"));
				return "/sections/progdoublons/errordouble.jsf?faces-redirect=true";
			} else {
				listdoublant.clear();

				listdoublant=listdoublanttmp;

				return "/sections/progdoublons/doublant.jsf?faces-redirect=true";

			}

		}
	}

	public String doublantrun() {

		listdoubleruntmp = runprg.findAllDouble();

		if (listdoubleruntmp != null) {
			listdoublerun = listdoubleruntmp;
			return "/sections/progdoublons/doublantrun.jsf?faces-redirect=true";

		} else
			return "/sections/progdoublons/errordouble.jsf?faces-redirect=true";
	}

	public String doublantnotrun() {
		listdoublenotrun = new LinkedList<Programs>();
		listdoublenotruntmp = programsservice.Doublantnotrun();

		if (listdoublenotruntmp != null) {
			listdoublenotrun = listdoublenotruntmp;
			return "/sections/progdoublons/doublantnotrun.jsf?faces-redirect=true";

		} else
			return "/sections/progdoublons/errordouble.jsf?faces-redirect=true";
	}

	public String getNameprograms() {
		return nameprograms;
	}

	public void setNameprograms(String nameprograms) {
		this.nameprograms = nameprograms;
	}

	public List<ProgramModele> getListprograms() {
		return listprograms;
	}

	public void setListprograms(List<ProgramModele> listprograms) {
		this.listprograms = listprograms;
	}

}
