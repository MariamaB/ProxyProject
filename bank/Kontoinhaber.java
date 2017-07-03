package htw.designpattern.projekt.proxy.bank;

 public class Kontoinhaber {
	
	
	protected Kontoinhaber(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", vorname=" + vorname + "]";
	}

	
	public String fullName() {
		return vorname + " " + name;
	}

	protected Kontoinhaber() {
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
