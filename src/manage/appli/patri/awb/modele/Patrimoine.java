package manage.appli.patri.awb.modele;

public class Patrimoine {

	private String sli;

	private String schedule;
	private String autoselect ;
	private String jobappel;

	private String pgm;

	private String dataview;

	private String table;

	private String area;

	private String dbname;

	private String dbid;

	private String database;

	private String system;

	private String partenaire;

	private String idf;

	private String parametre;

	public Patrimoine(String sli, String schedule,String autoselect, String jobappel, String pgm,
			String dataview, String table, String area, String dbname,
			String dbid, String database, String system, String partenaire, String idf, String parametre) {
		super();
		this.sli = sli;
		this.autoselect=autoselect ;
		this.schedule = schedule;
		this.jobappel = jobappel;
		this.pgm = pgm;
		this.dataview = dataview;
		this.table = table;
		this.area = area;
		this.dbname = dbname;
		this.dbid = dbid;
		this.database = database;
		this.system = system;
		this.partenaire = partenaire;
		this.parametre = parametre;
		this.idf = idf;
	}

	public String getSli() {
		return sli;
	}

	public void setSli(String sli) {
		this.sli = sli;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getJobappel() {
		return jobappel;
	}

	public void setJobappel(String jobappel) {
		this.jobappel = jobappel;
	}

	public String getPgm() {
		return pgm;
	}

	public void setPgm(String pgm) {
		this.pgm = pgm;
	}

	public String getDataview() {
		return dataview;
	}

	public void setDataview(String dataview) {
		this.dataview = dataview;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbid() {
		return dbid;
	}

	public void setDbid(String dbid) {
		this.dbid = dbid;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(String partenaire) {
		this.partenaire = partenaire;
	}

	public String getIdf() {
		return idf;
	}

	public void setIdf(String idf) {
		this.idf = idf;
	}

	public String getParametre() {
		return parametre;
	}

	public void setParametre(String parametre) {
		this.parametre = parametre;
	}

	public String getAutoselect() {
		return autoselect;
	}

	public void setAutoselect(String autoselect) {
		this.autoselect = autoselect;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.area + " " + this.database + " " + this.dataview + " "
				+ this.dbid + " " + this.dbname + " " + this.pgm + " "
				+ this.system + " " + this.jobappel + " " + this.sli + " "
				+ this.schedule +" "+ this.parametre + " " + this.partenaire + " "
						+ this.idf + "\n";
	}

}
