package manage.appli.patri.awb.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import manage.appli.patri.awb.modele.Cft;
import manage.appli.patri.awb.service.CftService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("cftBean")
@ViewScoped
public class CftBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private transient CftService cftservice ;
	
	private String idfname ;
	private String parname ;
	private boolean job_appel ;
	private List<Cft> listcftidf ;
	private List<Cft> listcft ;
	private List<Cft> listcftpar ;
	private List<Cft> listcfttmp ;
	
	
	
	
	public List<Cft> getListcft() {
		return listcft;
	}
	public boolean isJob_appel() {
		return job_appel;
	}
	public void setJob_appel(boolean job_appel) {
		this.job_appel = job_appel;
	}
	public List<Cft> getListcftpar() {
		return listcftpar;
	}
	public void setListcftpar(List<Cft> listcftpar) {
		this.listcftpar = listcftpar;
	}
	public List<Cft> getListcftidf() {
		return listcftidf;
	}
	public void setListcft(List<Cft> listcftidf) {
		this.listcftidf = listcftidf;
	}
	
//	  public String getAlldata(){ 
//         
//                  listcfttmp = cftservice.findAll(1); 
//
//                  if (listcfttmp == null) { 
//                          (new BackinBean()).deactiveall(); 
//                          FacesContext.getCurrentInstance().addMessage( 
//                                          null, 
//                                          new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", 
//                                                          "base de donnee vide")); 
//                          return "/sections/cft/error.jsf?faces-redirect=true";
//                  } else { 
//                          listcft = listcfttmp; 
//                          return "/sections/cft/cft.jsf?faces-redirect=true";
//
//                  }
//        
//	             } 
	  
	  public String  getidf(){
		  idfname=idfname.trim();
		  if(!idfname.equals("")){
			  listcft = new LinkedList<Cft>();
			  if(idfname.endsWith("*")) listcfttmp=cftservice.findByidfspi(idfname.replace("*", "").toUpperCase());
			  else listcfttmp=cftservice.findByidf(idfname.toUpperCase());
			  if (listcfttmp==null) {
				  FacesContext.getCurrentInstance().addMessage( 
	                      null, 
	                      new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING "+idfname, 
	                                      "inexistant")); 
				  return "/sections/cft/error.jsf?faces-redirect=true";
			}
			  else{
			
				  listcft=listcfttmp ;
			  return "/sections/cft/cft.jsf?faces-redirect=true";
			  }
		  }
		  else {
			  
			  listcfttmp = cftservice.findAll(1); 
			  
			                    if (listcfttmp == null) { 
			           
			                            FacesContext.getCurrentInstance().addMessage( 
			                                            null, 
			                                            new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", 
			                                                            "base de donnee vide")); 
			                            return "/sections/cft/error.jsf?faces-redirect=true";
			                    } else { 
			                            listcft = listcfttmp; 
			                            return "/sections/cft/cft.jsf?faces-redirect=true";
			  
			                    }
			          
		  }
	  }
	  
	  public String getpar(){
		  parname=parname.trim();
		  if(!parname.equals("")){
			  listcft = new LinkedList<Cft>();
			  if(parname.endsWith("*")) listcfttmp=cftservice.findBypartspi(parname.replace("*", "").toUpperCase());
			  else listcfttmp=cftservice.findBypart(parname.toUpperCase());
			  if (listcfttmp==null) {
				  FacesContext.getCurrentInstance().addMessage( 
	                      null, 
	                      new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING "+parname, 
	                                      "inexistant")); 
				  return "/sections/cft/error.jsf?faces-redirect=true";
			}
			  else listcft=listcfttmp ;
			  return "/sections/cft/cft.jsf?faces-redirect=true";
			  
		  }
		  else 
		  {
			  listcfttmp = cftservice.findAll(1); 
			  
              if (listcfttmp == null) { 
                  
                      FacesContext.getCurrentInstance().addMessage( 
                                      null, 
                                      new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", 
                                                      "base de donnee vide")); 
                      return "/sections/cft/error.jsf?faces-redirect=true";
              } else { 
                      listcft = listcfttmp; 
                      return "/sections/cft/cft.jsf?faces-redirect=true";

              }
		  }
	  }
	public String getIdfname() {
		return idfname;
	}
	public void setIdfname(String idfname) {
		this.idfname = idfname;
	}
	public String getParname() {
		return parname;
	}
	public void setParname(String parname) {
		this.parname = parname;
	}
          
          
          
  
	
	
	
	
	
	

}
