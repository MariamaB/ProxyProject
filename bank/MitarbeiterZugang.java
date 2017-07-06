package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class MitarbeiterZugang{
	
	private int authPwd;
	
	public MitarbeiterZugang() {
		this.authPwd = 123;
	}

	public void createKonto(int personalPasswort, String name, String vorname, String blz, int KundenPin, double kontostand) {
		KontoAnlegen bbp = new BankBackendProxy();
		if (this.authPwd == personalPasswort) {
			bbp.createKonto(name, vorname, blz, KundenPin, kontostand);
		}
		else{
			System.out.println("Mitarbeiter passwort ist falsch!");
		}
		
	}
	
	public boolean deleteKonto(int personalPasswort,String blz) {
		KontoAnlegen bbp = new BankBackendProxy();
		if (this.authPwd == personalPasswort) {
			return bbp.deleteKonto(blz);
		}
		System.out.println("Mitarbeiter passwort ist falsch!");
		return false;
	}
}
