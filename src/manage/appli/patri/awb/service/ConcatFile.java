package manage.appli.patri.awb.service;

import java.util.List;

public interface ConcatFile {
	
	boolean concat( String[] infile, String outfile) ;
	
	List<Filedetail> listfile();
	List<Filedetail> listfilein();
	public boolean deletefiles() ;

}
