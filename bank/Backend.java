package htw.designpattern.projekt.proxy.bank;

import java.util.HashMap;

import htw.designpattern.projekt.proxy.bank.model.Konto;
import htw.designpattern.projekt.proxy.bank.model.Kontoinhaber;
import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class Backend implements KontoAnlegen{
	
	protected HashMap<String, Konto>konten;
	private Konto konto;
	private Kontoinhaber kontoinhaber;
	
	public Backend() {
		konten = new HashMap<>();
		konto = new Konto();
		kontoinhaber = new Kontoinhaber();
	
	}

	@Override
	public void createKonto(String name, String vorname, String blz, int pin, double kontostand) {
		kontoinhaber.setVorname(vorname);
		kontoinhaber.setName(name);
		konto.setKontoinhaber(kontoinhaber);
		konto.setBlz(blz);
		konto.setPin(pin);
		konto.getKontostand();
		
		konten.put(konto.getBlz(), konto);
		
		
	}
	

}
