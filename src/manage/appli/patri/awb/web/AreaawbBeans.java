package manage.appli.patri.awb.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;


import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.TableAwb;
import manage.appli.patri.awb.service.AreaAwbService;
import manage.appli.patri.awb.service.DataviewDatacomService;
import manage.appli.patri.awb.service.TableAwbService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;



@Component("areaawbBean")
@ViewScoped
public class AreaawbBeans implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4894149807173613084L;

	/**
	 * 
	 */
	

	@Autowired
	private transient AreaAwbService areaservice;
	
	@Autowired
	private transient TableAwbService tableservice;

	@Autowired
	private transient DataviewDatacomService dataviewservice;
	
	private List<AreaAwb> listarea;
	private boolean dataview ;
	private boolean table ;
	private boolean database ;
	private String nameareaawb ;
	private AreaAwb area ;
	private List<AreaAwb> listareatmp ;
	private List<DataviewDatacom> listdataview ;
	private List<DataviewDatacom> listdataviewtmp ;
	
	private List<TableAwb> listtable;
	private List<TableAwb> listtabletmp;
	
	
	

	public List<DataviewDatacom> getListdataview() {
		return listdataview;
	}




	public void setListdataview(List<DataviewDatacom> listdataview) {
		this.listdataview = listdataview;
	}




	public List<TableAwb> getListtable() {
		return listtable;
	}




	public void setListtable(List<TableAwb> listtable) {
		this.listtable = listtable;
	}




	public String getNameareaawb() {
		return nameareaawb;
	}




	public void setNameareaawb(String nameareaawb) {
		this.nameareaawb = nameareaawb;
	}




	public String getAlldata() {
       if(!table && !dataview){
		nameareaawb = nameareaawb.trim();
		if (nameareaawb.equals("")) {

			listareatmp = areaservice.findAll(1);

			if (listareatmp.size() == 0) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/area/error.jsf?faces-redirect=true";
			} else {
				listarea = listareatmp;
				return "/sections/area/area.jsf?faces-redirect=true";

			}

		} else {
			listarea = new LinkedList<AreaAwb>();
			if(nameareaawb.endsWith("*")){
				listarea = areaservice.findByNamespi(nameareaawb.replace("*", "").toUpperCase());
				if(listarea.size()==0) return "/sections/area/error.jsf?faces-redirect=true";
				else
				return "/sections/area/area.jsf?faces-redirect=true";
			}
			else area = areaservice.findByName(nameareaawb.toUpperCase());
			if (area == null) {
			
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom d'area inexistant"));
				return "/sections/area/error.jsf?faces-redirect=true";
			} else{
				listarea.add(area);
				return "/sections/area/area.jsf?faces-redirect=true";
				
		}}
       }
		if(!dataview && table){
			nameareaawb = nameareaawb.trim();
			if (nameareaawb.equals("")) {

				listtabletmp = tableservice.findAll(1);

				if (listtabletmp.size() == 0) {

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
									"base de donnee vide"));
					return "/sections/area/error.jsf?faces-redirect=true";
				} else {
					listtable = listtabletmp;

					return "/sections/area/tarea.jsf?faces-redirect=true";
				}

			} else {
				listtable = new LinkedList<TableAwb>();
				if (nameareaawb.endsWith("*")) {
					listtabletmp = tableservice.findByAreaspi(nameareaawb
							.replace("*", "").toUpperCase());
					if(listtabletmp==null) return "/sections/area/error.jsf?faces-redirect=true";
					
					else {
						listtable = listtabletmp ;
						return "/sections/area/tarea.jsf?faces-redirect=true";	
					}
					
					

				} else
					listtabletmp = tableservice.findByArea(nameareaawb
							.toUpperCase());
				if (listtabletmp== null) {

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
									"nom de base inexistant"));
					return "/sections/area/error.jsf?faces-redirect=true";
				} else {
					listtable=listtabletmp;
					return "/sections/area/tarea.jsf?faces-redirect=true";
				}	
			
		}
		
		}
		
		if(dataview){
			nameareaawb = nameareaawb.trim();
			if (nameareaawb.equals("")) {

				listdataviewtmp = dataviewservice.findAll(1);

				if (listdataviewtmp.size() == 0) {

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
									"base de donnee vide"));
					return "/sections/area/error.jsf?faces-redirect=true";
				} else {
					listdataview = listdataviewtmp;

					return "/sections/area/dvarea.jsf?faces-redirect=true";
				}

			} else {
				listdataview = new LinkedList<DataviewDatacom>();
				if (nameareaawb.endsWith("*")) {
					listdataviewtmp = dataviewservice.findByAreaspi(nameareaawb
							.replace("*", "").toUpperCase());
					if(listdataviewtmp==null) 
						return "/sections/area/error.jsf?faces-redirect=true";
					else{
						listdataview = listdataviewtmp;	
					return "/sections/area/dvarea.jsf?faces-redirect=true";
					}
				} else
					listdataviewtmp = dataviewservice.findByArea(nameareaawb
							.toUpperCase());
				if (listdataviewtmp== null) {

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
									"nom de base inexistant"));
					return "/sections/area/error.jsf?faces-redirect=true";
				} else {
					listdataview=listdataviewtmp;
					return "/sections/area/dvarea.jsf?faces-redirect=true";
				}	
			
		}

	}
	return null ;	
	}
	
	
	

	public boolean isDataview() {
		return dataview;
	}

	public void setDataview(boolean dataview) {
		this.dataview = dataview;
	}

	public boolean isTable() {
		return table;
	}

	public void setTable(boolean table) {
		this.table = table;
	}

	public boolean isDatabase() {
		return database;
	}

	public void setDatabase(boolean database) {
		this.database = database;
	}

	public List<AreaAwb> getListarea() {
		return listarea;
	}

	public void setListarea(List<AreaAwb> listarea) {
		this.listarea = listarea;
	}

	
	
	
	

	
	
}
