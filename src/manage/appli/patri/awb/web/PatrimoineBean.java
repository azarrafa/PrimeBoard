package manage.appli.patri.awb.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


import javax.faces.bean.ViewScoped;

import manage.appli.patri.awb.modele.Patrimoine;
import manage.appli.patri.awb.service.RunPrgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("patrimoineBean")
@ViewScoped
public class PatrimoineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private transient RunPrgService patrimservice;

	private String patrimoinname;
	private List<Patrimoine> listpatrimoine;
	private List<Patrimoine> listpatrimoinetmp;

	public String getPatrimoinname() {
		return patrimoinname;
	}

	public void setPatrimoinname(String patrimoinname) {
		this.patrimoinname = patrimoinname;
	}

	public List<Patrimoine> getListpatrimoine() {
		return listpatrimoine;
	}

	public void setListpatrimoine(List<Patrimoine> listpatrimoine) {
		this.listpatrimoine = listpatrimoine;
	}

	public String getAlldata() {
		patrimoinname = patrimoinname.trim();

		if (patrimoinname.equals(""))

			return "/sections/patrimoine/error.jsf?faces-redirect=true";

		else {
			listpatrimoine = new LinkedList<Patrimoine>();
			if (patrimoinname.endsWith("*")) {
				listpatrimoinetmp = patrimservice
						.findPatrimoinespi(patrimoinname.replace("*", "")
								.toUpperCase());

				if (listpatrimoinetmp.size()==0) {
					return "/sections/patrimoine/error.jsf?faces-redirect=true";
				} else {
					listpatrimoine = listpatrimoinetmp;
					return "/sections/patrimoine/patrimoine.jsf?faces-redirect=true";
				}
			} else
				listpatrimoinetmp = patrimservice.findPatrimoine(patrimoinname
						.toUpperCase());
			if (listpatrimoinetmp.size()==0) {
				return "/sections/patrimoine/error.jsf?faces-redirect=true";
			} else {
				listpatrimoine = listpatrimoinetmp;
				return "/sections/patrimoine/patrimoine.jsf?faces-redirect=true";
			}

		}

	}

}
