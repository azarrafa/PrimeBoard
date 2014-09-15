package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.Patrimoine;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.RunPrg;

public interface RunPrgService {
	
	List<RunPrg> findAll(int page);
	
	List<RunPrg> findByPrograms(String name) ;
	
	List<RunPrg> findByProgram(Programs name) ;
	
	List<RunPrg> findByJobAppel(String name) ;
	
	List<RunPrg> findAllDouble() ;
	
	List<RunPrg> findDoubleNamespi(String name);
	
	List<Patrimoine> findPatrimoine(String name) ;
	
	List<Patrimoine> findPatrimoinespi(String name) ;
	
	

}
