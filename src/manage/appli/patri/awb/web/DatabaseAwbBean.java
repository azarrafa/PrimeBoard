package manage.appli.patri.awb.web;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import manage.appli.patri.awb.modele.AreaAwb;
import manage.appli.patri.awb.modele.DatabaseAwb;
import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.TableAwb;
import manage.appli.patri.awb.service.AreaAwbService;
import manage.appli.patri.awb.service.DatabaseAwbService;
import manage.appli.patri.awb.service.DataviewDatacomService;
import manage.appli.patri.awb.service.TableAwbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("databaseawbBean")
@ViewScoped
public class DatabaseAwbBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private transient DatabaseAwbService databaseservice;
	@Autowired
	private transient AreaAwbService areaservice ;
	@Autowired
	private transient TableAwbService tableservice ;
	@Autowired
	private transient DataviewDatacomService dataviewservice ;

	private List<DatabaseAwb> listdatabases;
	private List<DatabaseAwb> listdatabasestmp;
	
	private List<AreaAwb> listarea ;
	private List<AreaAwb> listareatmp ;
	
	private List<DataviewDatacom> listdataview ;
	private List<DataviewDatacom> listdataviewtmp ;
	
	private List<TableAwb> listtable;
	private List<TableAwb> listtabletmp;

	private String namedatabase;
	private String namedbid;
	private String nameusercatalogue;
	private DatabaseAwb database;
	private DatabaseAwb databasetmp;
	private boolean area;
	private boolean table;
	private boolean datavieaw;

	
	
	
	public List<AreaAwb> getListarea() {
		return listarea;
	}

	public void setListarea(List<AreaAwb> listarea) {
		this.listarea = listarea;
	}

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

	public String getNamedbid() {
		return namedbid;
	}

	public void setNamedbid(String namedbid) {
		this.namedbid = namedbid;
	}

	public String getNameusercatalogue() {
		return nameusercatalogue;
	}

	public void setNameusercatalogue(String nameusercatalogue) {
		this.nameusercatalogue = nameusercatalogue;
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

	public boolean isDatavieaw() {
		return datavieaw;
	}

	public void setDatavieaw(boolean datavieaw) {
		this.datavieaw = datavieaw;
	}

	public String getNamedatabase() {
		return namedatabase;
	}

	public void setNamedatabase(String namedatabase) {
		this.namedatabase = namedatabase;
	}

	public DatabaseAwb getDatabase() {
		return database;
	}

	public void setDatabase(DatabaseAwb database) {
		this.database = database;
	}

	public String getAlldata() {
		if(!area && !datavieaw && !table){
		databasetmp = null;
		listdatabasestmp = null;
		namedatabase = namedatabase.trim();
		if (namedatabase.equals("")) {

			listdatabasestmp = databaseservice.findAll(1);

			if (listdatabasestmp.size() == 0) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/database/error.jsf?faces-redirect=true";
			} else {
				listdatabases = listdatabasestmp;

				return "/sections/database/database.jsf?faces-redirect=true";
			}

		} else {
			listdatabases = new LinkedList<DatabaseAwb>();
			if (namedatabase.endsWith("*")) {
				listdatabases = databaseservice.findByNameSpi(namedatabase
						.replace("*", "").toUpperCase());
				if(listdatabases.size()==0)
					return "/sections/database/error.jsf?faces-redirect=true";
				else
					return "/sections/database/database.jsf?faces-redirect=true";

			} else
				databasetmp = databaseservice.findByName(namedatabase
						.toUpperCase());
			if (databasetmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom de base inexistant"));
				return "/sections/database/error.jsf?faces-redirect=true";
			} else {
				listdatabases.add(databasetmp);
				return "/sections/database/database.jsf?faces-redirect=true";
			}
		}
		}
			if(area && !datavieaw && !table){
				namedatabase = namedatabase.trim();
				if (namedatabase.equals("")) {

					listareatmp = areaservice.findAll(1);

					if (listareatmp.size() == 0) {

						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
										"base de donnee vide"));
						return "/sections/database/error.jsf?faces-redirect=true";
					} else {
						listarea = listareatmp;

						return "/sections/database/databasea.jsf?faces-redirect=true";
					}

				} else {
					listarea = new LinkedList<AreaAwb>();
					if (namedatabase.endsWith("*")) {
						listarea = areaservice.findByDatabasespi(namedatabase
								.replace("*", "").toUpperCase());
						return "/sections/database/databasea.jsf?faces-redirect=true";

					} else
						listareatmp = areaservice.findByDatabase(namedatabase
								.toUpperCase());
					if (listareatmp == null) {

						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
										"nom de base inexistant"));
						return "/sections/database/error.jsf?faces-redirect=true";
					} else {
						listarea=listareatmp;
						return "/sections/database/databasea.jsf?faces-redirect=true";
					}	
				
			}
			
			
		}
			if(!datavieaw && table){
				namedatabase = namedatabase.trim();
				if (namedatabase.equals("")) {

					listtabletmp = tableservice.findAll(1);

					if (listtabletmp.size() == 0) {

						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
										"base de donnee vide"));
						return "/sections/database/error.jsf?faces-redirect=true";
					} else {
						listtable = listtabletmp;

						return "/sections/database/databaset.jsf?faces-redirect=true";
					}

				} else {
					listtable = new LinkedList<TableAwb>();
					if (namedatabase.endsWith("*")) {
						listtable = tableservice.findBydatabasespi(namedatabase
								.replace("*", "").toUpperCase());
						return "/sections/database/databaset.jsf?faces-redirect=true";

					} else
						listtabletmp = tableservice.findBydatabase(namedatabase
								.toUpperCase());
					if (listtabletmp== null) {

						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
										"nom de base inexistant"));
						return "/sections/database/error.jsf?faces-redirect=true";
					} else {
						listtable=listtabletmp;
						return "/sections/database/databaset.jsf?faces-redirect=true";
					}	
				
			}
			}
			
			if(datavieaw){
				namedatabase = namedatabase.trim();
				if (namedatabase.equals("")) {

					listdataviewtmp = dataviewservice.findAll(1);

					if (listdataviewtmp.size() == 0) {

						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
										"base de donnee vide"));
						return "/sections/database/error.jsf?faces-redirect=true";
					} else {
						listdataview = listdataviewtmp;

						return "/sections/database/databased.jsf?faces-redirect=true";
					}

				} else {
					listdataview = new LinkedList<DataviewDatacom>();
					if (namedatabase.endsWith("*")) {
						listdataview = dataviewservice.findBydatabasespi(namedatabase
								.replace("*", "").toUpperCase());
						return "/sections/database/databased.jsf?faces-redirect=true";

					} else
						listdataviewtmp = dataviewservice.findBydatabase(namedatabase
								.toUpperCase());
					if (listdataviewtmp== null) {

						FacesContext.getCurrentInstance().addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
										"nom de base inexistant"));
						return "/sections/database/error.jsf?faces-redirect=true";
					} else {
						listdataview=listdataviewtmp;
						return "/sections/database/databased.jsf?faces-redirect=true";
					}	
				
			}
			}
		
 return null ;
	}

	public String getbydbid() {
		databasetmp = null;
		listdatabasestmp = null;
		namedatabase = namedatabase.trim();
		if (namedatabase.equals("")) {

			listdatabasestmp = databaseservice.findAll(1);

			if (listdatabasestmp.size() == 0) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/database/error.jsf?faces-redirect=true";
			} else {
				listdatabases = listdatabasestmp;

				return "/sections/database/database.jsf?faces-redirect=true";
			}

		} else {
			listdatabases = new LinkedList<DatabaseAwb>();
			databasetmp = databaseservice.findByDbId(namedbid);
			if (databasetmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom de base inexistant"));
				return "/sections/database/error.jsf?faces-redirect=true";
			} else {
				listdatabases.clear();
				listdatabases.add(databasetmp);
				return "/sections/database/database.jsf?faces-redirect=true";
			}
		}

	}

	public String getbyusercatalogue() {
		databasetmp = null;
		listdatabasestmp = null;
		namedatabase = namedatabase.trim();
		if (namedatabase.equals("")) {

			listdatabasestmp = databaseservice.findAll(1);

			if (listdatabasestmp.size() == 0) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"base de donnee vide"));
				return "/sections/database/error.jsf?faces-redirect=true";
			} else {
				listdatabases = listdatabasestmp;

				return "/sections/database/database.jsf?faces-redirect=true";
			}

		} else {
			listdatabases = new LinkedList<DatabaseAwb>();
			listdatabasestmp = databaseservice
					.findByUserCatalogue(nameusercatalogue);
			if (listdatabasestmp == null) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING",
								"nom de base inexistant"));
				return "/sections/database/error.jsf?faces-redirect=true";
			} else {
				listdatabases = listdatabasestmp;
				return "/sections/database/database.jsf?faces-redirect=true";
			}
		}

	}

	public List<DatabaseAwb> getListdatabases() {
		return listdatabases;
	}

	public void setListdatabases(List<DatabaseAwb> listdatabases) {
		this.listdatabases = listdatabases;
	}

}
