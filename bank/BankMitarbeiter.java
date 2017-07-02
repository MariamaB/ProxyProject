package htw.designpattern.projekt.proxy.bank;

public class BankMitarbeiter{
	
	private int personalnr;
	private int pwd;
	
	public BankMitarbeiter() {
		this.personalnr = 123;
		this.pwd = 123;
	}

	public void createKonto(int personalPasswort, String name, String vorname, String blz, int KundenPin, double kontostand) {
		BankBackendProxy bbp = new BankBackendProxy();
		if (this.pwd == personalPasswort) {
			bbp.createKonto(name, vorname, blz, KundenPin, kontostand);
		}
		else{
			System.out.println("Mitarbeiter passwort ist falsch!");
		}
		
	}
	
	

}
