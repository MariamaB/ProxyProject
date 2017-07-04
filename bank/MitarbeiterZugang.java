package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class MitarbeiterZugang{
	
	private int personalnr;
	private int pwd;
	
	public MitarbeiterZugang() {
		this.personalnr = 123;
		this.pwd = 123;
	}

	public void createKonto(int personalPasswort, String name, String vorname, String blz, int KundenPin, double kontostand) {
		KontoAnlegen bbp = new BankBackendProxy();
		if (this.pwd == personalPasswort) {
			bbp.createKonto(name, vorname, blz, KundenPin, kontostand);
		}
		else{
			System.out.println("Mitarbeiter passwort ist falsch!");
		}
		
	}
	
	

}
