package htw.designpattern.projekt.proxy.bank.model;

public class Kontoinhaber {
	
	
	public Kontoinhaber(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}
	
	public Kontoinhaber() {

	}

	private String name;
	private String vorname;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	

}
