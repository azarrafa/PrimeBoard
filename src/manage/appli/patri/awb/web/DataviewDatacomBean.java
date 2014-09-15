package manage.appli.patri.awb.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;


import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.RelatDatacom;
import manage.appli.patri.awb.service.DataviewDatacomService;
import manage.appli.patri.awb.service.RelatDatacomService;


@Component("dataviewdatacomBean")
@ViewScoped
public class DataviewDatacomBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private transient DataviewDatacomService dataviewdatacomservice;
	@Autowired
	private transient RelatDatacomService relatservice ;

	private List<DataviewDatacom> listdataview;
	private List<DataviewDatacom> listdataviewtmp;
	private List<RelatDatacom> listdataviews;
	private List<RelatDatacom> listdataviewtmps;
	private String namedataview;
	private boolean area;
	private boolean table;
	private boolean prog;
	private boolean database;
	private DataviewDatacom dataviewtmp;

	

	public List<RelatDatacom> getListdataviews() {
		return listdataviews;
	}

	public void setListdataviews(List<RelatDatacom> listdataviews) {
		this.listdataviews = listdataviews;
	}

	public List<RelatDatacom> getListdataviewtmps() {
		return listdataviewtmps;
	}

	public void setListdataviewtmps(List<RelatDatacom> listdataviewtmps) {
		this.listdataviewtmps = listdataviewtmps;
	}

	public String getNamedataview() {
		return namedataview;
	}

	public void setNamedataview(String namedataview) {
		this.namedataview = namedataview;
	}

	public List<DataviewDatacom> getListdataview() {
		return listdataview;
	}

	public void setListdataview(List<DataviewDatacom> listdataview) {
		this.listdataview = listdataview;
	}
	
	public boolean isArea() {
		return area;
	}

	public void setArea(boolean area) {
		this.area = area;
	}

	public boolean isTable() {
		return table;
	}

	public void setTable(boolean table) {
		this.table = table;
	}

	public boolean isProg() {
		return prog;
	}

	public void setProg(boolean prog) {
		this.prog = prog;
	}

	public boolean isDatabase() {
		return database;
	}

	public void setDatabase(boolean database) {
		this.database = database;
	}

	public String getAlldata() {
 if(!prog){
		namedataview = namedataview.trim();
		if (namedataview.equals("")) {

			listdataviewtmp = dataviewdatacomservice.findAll(1);

			if (listdataviewtmp.size() == 0) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"Table oracle vide"));
				return "/sections/dataviewdc/error.jsf?faces-redirect=true";
			} else {
				listdataview = listdataviewtmp;
				return "/sections/dataviewdc/dataviewdcs.jsf?faces-redirect=true";

			}

		} else {
			listdataview = new LinkedList<DataviewDatacom>();
			if(namedataview.endsWith("*")) 
			{
				listdataviewtmp = dataviewdatacomservice.findByNamespi(namedataview.replace("*", "").toUpperCase());
				if(listdataviewtmp.size()==0) return "/sections/dataviewdc/error.jsf?faces-redirect=true";
				else{
					listdataview=listdataviewtmp ;
					return "/sections/dataviewdc/dataviewdcs.jsf?faces-redirect=true";
				}
			}
			else
			
			dataviewtmp = dataviewdatacomservice.findByName(namedataview.toUpperCase());
			if (dataviewtmp == null) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom de dataview inexistant"));
				return "/sections/dataviewdc/error.jsf?faces-redirect=true";
			} else{
				listdataview.add(dataviewtmp);
				return "/sections/dataviewdc/dataviewdcs.jsf?faces-redirect=true";
				
		}}
 }
 else 
	 {
	 namedataview = namedataview.trim();
		if (namedataview.equals("")) {

			listdataviewtmps = relatservice.findAll(1);

			if (listdataviewtmps.size() == 0) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"Table oracle vide"));
				return "/sections/area/error.jsf?faces-redirect=true";
			} else {
				listdataviews = listdataviewtmps;
				return "/sections/dataviewdc/dataviewdc.jsf?faces-redirect=true";

			}

		} else {
			listdataviews = new LinkedList<RelatDatacom>();
			if(namedataview.endsWith("*")) 
			{
				listdataviewtmps = relatservice.findBydDataviewspi(namedataview.replace("*", "").toUpperCase());
				if(listdataviewtmps==null) return "/sections/dataviewdc/error.jsf?faces-redirect=true";
				else{
					listdataviews=listdataviewtmps ;
					return "/sections/dataviewdc/dataviewdc.jsf?faces-redirect=true";
				}
			}
			else
			
			listdataviewtmps = relatservice.findBydDataview(namedataview.toUpperCase());
			if (listdataviewtmps == null) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom de dataview inexistant"));
				return "/sections/dataviewdc/error.jsf?faces-redirect=true";
			} else{
				listdataviews=listdataviewtmps;
				return "/sections/dataviewdc/dataviewdc.jsf?faces-redirect=true";
				
		}}
	 }
 
	}
	


}
