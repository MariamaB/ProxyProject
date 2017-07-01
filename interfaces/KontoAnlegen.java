package htw.designpattern.projekt.proxy.interfaces;

import htw.designpattern.projekt.proxy.bank.model.Konto;

public interface KontoAnlegen {
	
	public Konto createKonto(String name, String vormane, String blz, int pin, double kontostand);
//	public void setName(String name);
//	public void setVorname(String vorname);
//	public void setPin();
//	public void setBlz();
//	public void setKontostand();
	
	
	
}
