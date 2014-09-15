package manage.appli.patri.awb.service; 

import java.util.Iterator; 
import java.util.List; 

import org.hibernate.Hibernate; 
import org.hibernate.SessionFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 

import manage.appli.patri.awb.modele.JobAppel; 
import manage.appli.patri.awb.modele.Scheduler; 
import manage.appli.patri.awb.modele.Sli; 

@Transactional 
@Service("sliService") 
public class SliServiceImp implements SliService { 

        @Autowired 
        SessionFactory sessionfactory ; 
        
        @Override
    	public int getcount(){
    		
    		
    		return sessionfactory.getCurrentSession().createQuery("from Sli").list().size();
    	}
        
        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findAll(int page) { 
                // TODO Auto-generated method stub 
                
List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                
                        
                        
                        } 
                } 
                return  res; 
        } 
        
        @Override
        public List<Sli> findByjobspi(String name) {
        	List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli where job like '"+name+"%'").list(); 

            
            if(res!=null){ 
                    Iterator<Sli> it=res.iterator(); 
                    Sli current=null ; 
                    while(it.hasNext()){ 
                            current=it.next(); 
                    Hibernate.initialize(current.getRelatSliScheds()); 
                    Hibernate.initialize(current.getJobAppel()); 
                    if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
            
                    
                    
                    } 
            } 
            return  res; 
        }

        @Override 
        public Sli findByjob(String name) { 
                // TODO Auto-generated method stub 
          
     Sli res= (Sli) sessionfactory.getCurrentSession().get(Sli.class,name); 

                
                if(res!=null){ 
                        Hibernate.initialize(res.getRelatSliScheds()); 
                        Hibernate.initialize(res.getJobAppel()); 
                        if(res.getJobAppel()!=null) Hibernate.initialize(res.getJobAppel().getRunPrgs()); 
                        
        
                } 
                return  res; 

                
        } 

        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findBynbJob(String name) { 
                // TODO Auto-generated method stub 
                
List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli where nbJob='"+name+"'").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                        
                        } 
                } 
                return  res; 
        } 

        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findBylibmemb(String name) { 
                // TODO Auto-generated method stub 
                
List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli where libmemb='"+name+"'").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                        
                        } 
                } 
                return  res; 
        } 

        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findByclass_(String name) { 
                // TODO Auto-generated method stu 

List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli where class_='"+name+"'").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                        
                        
                        } 
                } 
                return  res; 

        } 

        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findBysublib(String name) { 
                // TODO Auto-generated method stub 
                
List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli where sublib='"+name+"'").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                        
                        } 
                } 
                return  res; 
        } 

        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findBysysid(String name) { 
                // TODO Auto-generated method stub 
                
List<Sli> res= sessionfactory.getCurrentSession().createQuery("from Sli where sysid='"+name+"'").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        JobAppel curjob; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                        
                        } 
                } 
                return  res; 
        } 

        @SuppressWarnings("unchecked") 
        @Override 
        public List<Sli> findByfailCode(String name) { 
                // TODO Auto-generated method stub 
                

List<Sli> res=  sessionfactory.getCurrentSession().createQuery("from Sli where failCode='"+name+"'").list(); 

                
                if(res!=null){ 
                        Iterator<Sli> it=res.iterator(); 
                        Sli current=null ; 
                        while(it.hasNext()){ 
                                current=it.next(); 
                        Hibernate.initialize(current.getRelatSliScheds()); 
                        Hibernate.initialize(current.getJobAppel()); 
                        if(current.getJobAppel()!=null) Hibernate.initialize(current.getJobAppel().getRunPrgs()); 
                        
                        } 
                } 
                return  res; 

        } 
        
      

}