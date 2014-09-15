package manage.appli.patri.awb.web;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import javax.faces.bean.ViewScoped;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.modele.RelatIdeal;
import manage.appli.patri.awb.modele.RelatSliSched;
import manage.appli.patri.awb.modele.RunPrg;
import manage.appli.patri.awb.modele.TableAwb;
import manage.appli.patri.awb.modele.UsePanel;
import manage.appli.patri.awb.modele.UseReport;
import manage.appli.patri.awb.service.CompteService;
import manage.appli.patri.awb.service.ConcatFile;
import manage.appli.patri.awb.service.Countdetails;
import manage.appli.patri.awb.service.DatabaseAwbService;
import manage.appli.patri.awb.service.ExecCommande;
import manage.appli.patri.awb.service.Filedetail;

@Component("backinBean")
@ViewScoped
public class BackinBean implements Serializable {

	private boolean filelistout;
	private boolean dataviewdcvisible;
	private boolean tablevisible;
	private boolean areavisible;
	private boolean programsvisible;
	private boolean filelistin;
	private boolean loadvisible;
	private boolean schedulevisible;
	private List<Countdetails> listcount;

	private List<Filedetail> listfile;
	private List<String> listtable;
	private List<Filedetail> listfilein;
	@Autowired
	private transient ConcatFile concat;
	@Autowired
	private transient CompteService compte;
@Autowired
private transient DatabaseAwbService exec ;
	@PostConstruct
	public void init()  {
		listtable = new LinkedList<String>();
		listtable.add("DATABASE_AWB");
		listtable.add("AREA_AWB");
		listtable.add("TABLE_AWB");
		listtable.add("DATAVIEW_DATACOM");
		listtable.add("DATAVIEW_IDEAL");
		listtable.add("RELAT_DATACOM");
		listtable.add("RELAT_IDEAL");
		listtable.add("PROGRAMS");
		listtable.add("USE_PGM");
		listtable.add("USE_REPORT");
		listtable.add("USE_PANEL");
		listtable.add("JOB_APPEL");
		listtable.add("RUN_PRG");
		listtable.add("URT");
		listtable.add("CFT");
		listtable.add("SLI");
		listtable.add("RELAT_SLI_SCHED");
		listtable.add("SCHEDULER");
		listtable.add("ANOM_PRG_DV");
		listtable.add("ANOM_RUN_PRG");
		listfile = concat.listfile();
		listfilein = concat.listfilein();

		

	}
public boolean count(){

	listcount=exec.getcount();
	if(listcount!=null) return true;
	
	else return false;
	
}
	

	public List<Countdetails> getListcount() {
	return listcount;
}
public void setListcount(List<Countdetails> listcount) {
	this.listcount = listcount;
}
	public boolean listerfile() {

		listfile = concat.listfile();
		if (listfile != null) {
			filelistout = true;
			return true;
		} else {
			filelistout = false;
			return false;
		}
	}

	public boolean listerfilein() {

		listfilein = concat.listfilein();
		if (listfilein != null) {
			filelistin = true;
			return true;
		} else {
			filelistin = false;
			return false;
		}
	}

	public String deletefiles() {

		if (concat.deletefiles())

			return "/views/load.jsf?faces-redirect=true";

		else
			return "/sections/home/error.jsf?faces-redirect=true";

	}

	public List<Filedetail> getListfilein() {
		return listfilein;
	}

	public void setListfilein(List<Filedetail> listfilein) {
		this.listfilein = listfilein;
	}

	public List<String> getListtable() {
		return listtable;
	}

	public void setListtable(List<String> listtable) {
		this.listtable = listtable;
	}

	public boolean isSchedulevisible() {
		return schedulevisible;
	}

	public void setSchedulevisible(boolean schedulevisible) {
		this.schedulevisible = schedulevisible;
	}

	public List<Filedetail> getListfile() {
		return listfile;
	}

	public void setListfile(List<Filedetail> listfile) {
		this.listfile = listfile;
	}

	public boolean isLoadvisible() {
		return loadvisible;
	}

	public void setLoadvisible(boolean loadvisible) {
		this.loadvisible = loadvisible;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean isFilelistin() {
		return filelistin;
	}

	public void setFilelistin(boolean filelistin) {
		this.filelistin = filelistin;
	}

	public boolean isFilelistout() {
		return filelistout;
	}

	public void setFilelistout(boolean basevisible) {
		this.filelistout = basevisible;
	}

	public boolean isDataviewdcvisible() {
		return dataviewdcvisible;
	}

	public void setDataviewdcvisible(boolean dataviewdcvisible) {
		this.dataviewdcvisible = dataviewdcvisible;
	}

	public boolean isTablevisible() {
		return tablevisible;
	}

	public void setTablevisible(boolean tablevisible) {
		this.tablevisible = tablevisible;
	}

	public boolean isAreavisible() {
		return areavisible;
	}

	public void setAreavisible(boolean areavisible) {
		this.areavisible = areavisible;
	}

	public boolean isProgramsvisible() {
		return programsvisible;
	}

	public void setProgramsvisible(boolean programsvisible) {
		this.programsvisible = programsvisible;
	}

	public List<AreaAwb> tolistArea(Set<AreaAwb> in) {

		return in != null ? (new LinkedList<AreaAwb>(in)) : null;
	}

	public List<RelatDatacom> tolistRealatdc(Set<RelatDatacom> in) {

		return in != null ? (new LinkedList<RelatDatacom>(in)) : null;
	}

	public List<RelatSliSched> tolistsched(Set<RelatSliSched> in) {

		return in != null ? (new LinkedList<RelatSliSched>(in)) : null;
	}

	public List<TableAwb> tolisttable(Set<TableAwb> in) {

		return in != null ? (new LinkedList<TableAwb>(in)) : null;
	}

	public List<DataviewDatacom> tolistdataviewdc(Set<DataviewDatacom> in) {

		return in != null ? (new LinkedList<DataviewDatacom>(in)) : null;
	}

	public List<RunPrg> tolistrunprg(Set<RunPrg> in) {

		return in != null ? (new LinkedList<RunPrg>(in)) : null;
	}

	public List<RelatIdeal> tolistideal(Set<RelatIdeal> in) {

		return in != null ? (new LinkedList<RelatIdeal>(in)) : null;
	}

	public List<UsePanel> tolistpanel(Set<UsePanel> in) {

		return in != null ? (new LinkedList<UsePanel>(in)) : null;
	}

	public List<UseReport> tolistreport(Set<UseReport> in) {

		return in != null ? (new LinkedList<UseReport>(in)) : null;
	}
}
