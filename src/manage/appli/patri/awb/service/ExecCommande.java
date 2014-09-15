package manage.appli.patri.awb.service;

import java.util.List;

public interface ExecCommande {
	
	
	void createBase() ;
	
	void deleteBase();
	
	void loadData();
	
	void exportData();
	
	List<Countdetails> count() ;

}
