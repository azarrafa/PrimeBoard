package manage.appli.patri.awb.service;

import java.util.List;

import manage.appli.patri.awb.modele.ProgramModele;
import manage.appli.patri.awb.modele.Programs;
import manage.appli.patri.awb.modele.ProgramsId;


public interface ProgramsService {

	List<Programs> findAll(int page);

	List<ProgramModele> findAlls(String name);

	Programs findById(ProgramsId id);

	List<Programs> findByName(String name);

	List<Programs> findByNamespi(String name);

	List<Programs> findBySystem(String system);

	List<Programs> findByStatus(String status);

	List<Programs> findByDate(String date);

	List<Programs> getDoublant();

	

	List<Programs> Doublantnotrun();

	List<Programs> doublantname(String name);

	List<Programs> doublantnamespi(String name);
	
	List<Programs> findNotrunning(String name);
	
	List<Programs> findrunning(String name);
	
	List<Programs> Doublantrun() ;
	
	boolean isrunning(String name);



}
