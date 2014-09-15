package manage.appli.patri.awb.modele;

import java.io.Serializable;

public class ProgramModele implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String program ;
	
	private String rprogram ;
	
	private String version ;
	
	private String system ;
	
	private String panel;
	
	private String report ;
	
	private String dataviewdc;
	
	private String dataviewid;
	
	private String sli ;
	
	public ProgramModele(String program, String version, String system,
			String panel, String report, String dataviewdc, String dataviewid,
			String sli,String rprogram) {
		super();
		this.program = program;
		this.version = version;
		this.system = system;
		this.panel = panel;
		this.report = report;
		this.dataviewdc = dataviewdc;
		this.dataviewid = dataviewid;
		this.sli = sli;
		this.rprogram=rprogram ;
	}
	

	public String getRprogram() {
		return rprogram;
	}


	public void setRprogram(String rprogram) {
		this.rprogram = rprogram;
	}


	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getPanel() {
		return panel;
	}

	public void setPanel(String panel) {
		this.panel = panel;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getDataviewdc() {
		return dataviewdc;
	}

	public void setDataviewdc(String dataviewdc) {
		this.dataviewdc = dataviewdc;
	}

	public String getDataviewid() {
		return dataviewid;
	}

	public void setDataviewid(String dataviewid) {
		this.dataviewid = dataviewid;
	}

	public String getSli() {
		return sli;
	}

	public void setSli(String sli) {
		this.sli = sli;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.program+" "+this.version+" "+this.system+" "+this.dataviewdc+" "+this.dataviewid+" "+this.panel+" "+this.report+" "+this.sli+" "+this.rprogram+"\n";
	}
	
	
	

}
