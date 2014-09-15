package manage.appli.patri.awb.web;

import java.io.Serializable;
import manage.appli.patri.awb.service.ExecCommandeImp;
import manage.appli.patri.awb.service.ExtractData;


import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("loadBean")
@ViewScoped
public class LoadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient ExecCommandeImp seviceexec;
	@Autowired
	private transient ExtractData extractservice ;

	public void runload() {

		seviceexec.loadData();
	}

	public void rundelete() {

		seviceexec.deleteBase();
		
	}

	public void runcreate() {

		seviceexec.createBase();
	}

	public void runexport() {

		seviceexec.exportData();
	}

	public void runtransform() {
		
		extractservice.extractDataCom("E:\\input\\BTG");
		extractservice.extractPrograms("E:\\input\\EXPPGM");
		extractservice.extractSLI("E:\\input\\SPRBA.BATCH");
		extractservice.extractSched("E:\\input\\SCHDLIST");

		
	}

}
