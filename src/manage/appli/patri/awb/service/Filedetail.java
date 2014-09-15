package manage.appli.patri.awb.service;

public class Filedetail {
	
	
	
	Filedetail(String name,String taille){
		this.name=name;
		this.taille=taille;
		
		
	}
	
	private String name ;
	private String taille ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+this.taille;
	}

}
