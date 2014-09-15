package manage.appli.patri.awb.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import manage.appli.patri.awb.modele.TableAwb;
import manage.appli.patri.awb.service.TableAwbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tableBean")
@ViewScoped
public class TableBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private transient TableAwbService tableservice ;
	
	private List<TableAwb> listtable ;
	private List<TableAwb> listtabletmp ;
	private boolean dataview ;
	private boolean area ;
	private boolean database ;
	private TableAwb table ;
	private String nametable ;
	public List<TableAwb> getListtable() {
		return listtable;
	}
	public void setListtable(List<TableAwb> listtable) {
		this.listtable = listtable;
	}
	public boolean isDataview() {
		return dataview;
	}
	public void setDataview(boolean dataview) {
		this.dataview = dataview;
	}
	public boolean isArea() {
		return area;
	}
	public void setArea(boolean area) {
		this.area = area;
	}
	public boolean isDatabase() {
		return database;
	}
	public void setDatabase(boolean database) {
		this.database = database;
	}
	public String getNametable() {
		return nametable;
	}
	public void setNametable(String nametable) {
		this.nametable = nametable;
	}
	
	public String getAlldata() {

		nametable = nametable.trim();
		if (nametable.equals("")) {

			listtabletmp = tableservice.findAll(1);

			if (listtabletmp.size() == 0) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"Table oracle vide"));
				return "/sections/table/error.jsf?faces-redirect=true";
				
			} else {
				listtable = listtabletmp;
				return "/sections/table/table.jsf?faces-redirect=true";
				

			}

		} else {
			listtable = new LinkedList<TableAwb>();
			
			if(nametable.endsWith("*")){
				
				listtable = tableservice.findByNamespi(nametable.replace("*", "").toUpperCase());
				return "/sections/table/table.jsf?faces-redirect=true";
			}
			else table = tableservice.findByName(nametable.toUpperCase());
			if (table == null) {
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom de table inexistant"));
				return "/sections/table/error.jsf?faces-redirect=true";
			} else{
				listtable.add(table);
				return "/sections/table/table.jsf?faces-redirect=true";
				
		}}

	}
	
	
	

}
