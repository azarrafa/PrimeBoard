package manage.appli.patri.awb.web;

import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manage.appli.patri.awb.modele.UsePanel;

import manage.appli.patri.awb.service.UsePanelService;

@Component("panelBean")
@ViewScoped
public class PanelBean {

	@Autowired
	private transient UsePanelService panelservice;
	
	private List<UsePanel> listpanel;
	private List<UsePanel> listpaneltmp;
	private List<UsePanel> listdoublant;
	private List<UsePanel> listdoublanttmp;
	private UsePanel  panel ;
	
	private String namepanel;
	
	
	

	public String getAlldata() {
		namepanel = namepanel.trim();

		if (namepanel.equals("")) {
			listpaneltmp = panelservice.findAll(1);
			if (listpaneltmp == null)
			{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Warning", "la base est vide"));
				return "/sections/panel/error.jsf?faces-redirect=true";
			}
			else
			{
				listpanel=listpaneltmp ;
				return "/sections/panel/panel.jsf?faces-redirect=true";
			}
		} else {
			listpanel = new LinkedList<UsePanel>();
			listpaneltmp=panelservice.findByName(namepanel);
			if(listpaneltmp==null) 
				{FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Warning", "Program inexistant"));
				return "/sections/programs/error.jsf?faces-redirect=true";
				}else {
					listpanel.clear();
					listpanel=listpaneltmp;
				return "/sections/programs/programs.jsf?faces-redirect=true";
				
			}

		}

	}
	
	

	
		
	}
	
	
	



