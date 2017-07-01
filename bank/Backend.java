package htw.designpattern.projekt.proxy.bank;

import java.util.HashMap;

import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class Backend extends Konto implements KontoAnlegen{
	
	protected HashMap<String, Konto>konten = new HashMap<>();
	private Konto konto = new Konto();

	
	protected Backend() {
	
	}

	@Override
	public void createKonto(String name, String vorname, String blz, int pin, double kontostand) {
		
		
		konto.getKontoinhaber().setVorname(vorname);
		konto.getKontoinhaber().setName(name);
		konto.setBlz(blz);
		konto.setPin(pin);
		konto.getKontostand();
		
		konten.put(konto.getBlz(), konto);
		System.out.println("Kundenkonto "+konto.kontoinhaber + "in DB gespeichert");
		
		
	}
	

}
