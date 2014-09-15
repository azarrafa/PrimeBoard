package manage.appli.patri.awb.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manage.appli.patri.awb.modele.DataviewIdeal;
import manage.appli.patri.awb.modele.RelatIdeal;
import manage.appli.patri.awb.service.DataviewIdealService;
import manage.appli.patri.awb.service.RelatIdealService;
@Component("dataviewidealBean")
@ViewScoped
public class DataviewIdealBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient DataviewIdealService datavieawid;
	@Autowired
	private transient RelatIdealService serviceideal ;
	private String dataviewidname ;
	private boolean prog ;
	private List<DataviewIdeal> listdataviewid ;
	private List<DataviewIdeal> listdataviewidtmp ;
	private List<RelatIdeal> listdataviewidp ;
	private List<RelatIdeal> listdataviewidtmpp ;
	private DataviewIdeal dvideal;
	
	
	
	
	
	public List<RelatIdeal> getListdataviewidp() {
		return listdataviewidp;
	}
	public void setListdataviewidp(List<RelatIdeal> listdataviewidp) {
		this.listdataviewidp = listdataviewidp;
	}
	public List<DataviewIdeal> getListdataviewid() {
		return listdataviewid;
	}
	public void setListdataviewid(List<DataviewIdeal> listdataviewid) {
		this.listdataviewid = listdataviewid;
	}
	public DataviewIdealService getDatavieawid() {
		return datavieawid;
	}
	public void setDatavieawid(DataviewIdealService datavieawid) {
		this.datavieawid = datavieawid;
	}
	public String getDataviewidname() {
		return dataviewidname;
	}
	public void setDataviewidname(String dataviewidname) {
		this.dataviewidname = dataviewidname;
	}
	public boolean isProg() {
		return prog;
	}
	public void setProg(boolean prog) {
		this.prog = prog;
	}
	
	
	public String getAlldata() {
		if(!prog){
		dataviewidname = dataviewidname.trim();

		if (dataviewidname.equals("")) {
			listdataviewidtmp= datavieawid.findAll(1);
			if (listdataviewidtmp == null){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Warning", "la base est vide"));
			return "/sections/dataviewid/error.jsf?faces-redirect=true";
			}
			else {
				listdataviewid=listdataviewidtmp ;
			
			return "/sections/dataviewid/dataviewid.jsf?faces-redirect=true";
			}
			}
		 else {
			 listdataviewid = new LinkedList<DataviewIdeal>();
			 if(dataviewidname.endsWith("*"))
			 {
				 listdataviewid= datavieawid.findByNamespi(dataviewidname.replace("*", "").toUpperCase());
				 
				 if(listdataviewid.size()==0)
					 return "/sections/dataviewid/error.jsf?faces-redirect=true";
					 else
				 return "/sections/dataviewid/dataviewid.jsf?faces-redirect=true";
			 }
			 else  dvideal=datavieawid.findByName(dataviewidname.toUpperCase());
			if(dvideal==null) 
				{FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Warning", "dataview "+dataviewidname+" inexistante"));
			return "/sections/dataviewid/error.jsf?faces-redirect=true";
				}
			else {
				listdataviewid.clear();
				listdataviewid.add(dvideal);
				return "/sections/dataviewid/dataviewid.jsf?faces-redirect=true";
				
			}

		}
		}
	else{
		dataviewidname = dataviewidname.trim();

		if (dataviewidname.equals("")) {
			listdataviewidtmpp= serviceideal.findAll(1);
			if (listdataviewidtmpp == null){
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Warning", "la base est vide"));
			return "/sections/dataviewid/error.jsf?faces-redirect=true";
			}
			else {
				listdataviewidp=listdataviewidtmpp ;
			
			return "/sections/dataviewid/dataviewidp.jsf?faces-redirect=true";
			}
			}
		 else {
			 listdataviewidp = new LinkedList<RelatIdeal>();
			 if(dataviewidname.endsWith("*"))
			 {
				 listdataviewidp= serviceideal.findBydDataviewspi(dataviewidname.replace("*", "").toUpperCase());
				 return "/sections/dataviewid/dataviewidp.jsf?faces-redirect=true";
			 }
			 else  
			 {
				 listdataviewidtmpp=serviceideal.findBydDataview(dataviewidname.toUpperCase());
			 }
				 if(listdataviewidtmpp==null) 
				{FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Warning", "dataview "+dataviewidname+" inexistante"));
			return "/sections/dataviewid/error.jsf?faces-redirect=true";
				}
			else {
				listdataviewidp=listdataviewidtmpp;
				return "/sections/dataviewid/dataviewidp.jsf?faces-redirect=true";
				
			}

		}
		
		}

	}
public int getcount(){
		
		return datavieawid.getcount();
	}
}
