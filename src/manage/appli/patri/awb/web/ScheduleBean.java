package manage.appli.patri.awb.web; 

import java.io.Serializable; 
import java.util.LinkedList;
import java.util.List; 

import javax.faces.application.FacesMessage; 

import javax.faces.bean.ViewScoped; 
import javax.faces.context.FacesContext; 


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 



import manage.appli.patri.awb.modele.Scheduler; 
import manage.appli.patri.awb.service.SchedulerService; 

@Component("scheduleBean") 
@ViewScoped
public class ScheduleBean implements Serializable{ 

        /** 
         * 
         */ 
        private static final long serialVersionUID = 1L; 
        @Autowired 
        private transient SchedulerService scheduleservice ; 
        
        private String nameschedule ; 
        private List<Scheduler> listschedule ; 
        private List<Scheduler> listscheduletmp ; 
        private Scheduler scheduletmp ; 
        private boolean job ; 
        
        
        public String getNameschedule() { 
                return nameschedule; 
        } 
        public void setNameschedule(String nameschedule) { 
                this.nameschedule = nameschedule; 
        } 
        public List<Scheduler> getListschedule() { 
                return listschedule; 
        } 
        public void setListschedule(List<Scheduler> listschedule) { 
                this.listschedule = listschedule; 
        } 
        public boolean isJob() { 
                return job; 
        } 
        public void setJob(boolean job) { 
                this.job = job; 
        } 
        
        public String getAlldata(){ 
                nameschedule = nameschedule.trim(); 
                if (nameschedule.equals("")) { 

                        listscheduletmp = scheduleservice.findAll(1); 

                        if (listscheduletmp.size() == 0) { 
                                
                                FacesContext.getCurrentInstance().addMessage( 
                                                null, 
                                                new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", 
                                                                "base de donnee vide")); 
                                return "/sections/schedule/error.jsf?faces-redirect=true";
                        } else { 
                                listschedule = listscheduletmp; 
                                return "/sections/schedule/schedule.jsf?faces-redirect=true";           

                        } 

                } else { 
                        listschedule = new LinkedList<Scheduler>(); 
                        if(nameschedule.endsWith("*")){
                        	
                        	listschedule =  scheduleservice.findBySchedulespi(nameschedule.replace("*", "").toUpperCase());
                        	return "/sections/schedule/schedule.jsf?faces-redirect=true";
                        }
                        else  scheduletmp = scheduleservice.findBySchedule(nameschedule.toUpperCase()); 
                        if (scheduletmp == null) { 
                                
                                FacesContext.getCurrentInstance().addMessage( 
                                                null, 
                                                new FacesMessage(FacesMessage.SEVERITY_WARN, "WARNING", 
                                                                "nom de base inexistant"));
                                return "/sections/schedule/error.jsf?faces-redirect=true";
                        } else{ 
                                listschedule.add(scheduletmp); 
                                return "/sections/schedule/schedule.jsf?faces-redirect=true";
                                
                }} 
                
                
                
        } 
        
        

} 