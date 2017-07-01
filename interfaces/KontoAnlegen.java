package htw.designpattern.projekt.proxy.interfaces;

import htw.designpattern.projekt.proxy.bank.Konto;

public interface KontoAnlegen {
	
	public void createKonto(String name, String vorname, String blz, int pin, double kontostand);
//	public void setName(String name);
//	public void setVorname(String vorname);
//	public void setPin();
//	public void setBlz();
//	public void setKontostand();
	
	
	
}
