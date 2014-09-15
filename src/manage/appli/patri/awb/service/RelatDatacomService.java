package manage.appli.patri.awb.service;

import java.util.List;


import manage.appli.patri.awb.modele.DataviewDatacom;
import manage.appli.patri.awb.modele.ProgramsId;
import manage.appli.patri.awb.modele.RelatDatacom;

public interface RelatDatacomService {
	
  List<RelatDatacom>	findByPrograms(ProgramsId name);
  
  List<RelatDatacom> findAll(int page);
  
  List<RelatDatacom> findBydDataview(String name);
  
  List<RelatDatacom> findBydDataviewspi(String name);
  
  
	

}
