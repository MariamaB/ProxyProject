package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class BankAutomatProxy implements KontoInteraktion {
	
	private String blz;
	
	public BankAutomatProxy(String ecKarte) {
		this.blz = ecKarte;
	}

	@Override
	public double getKontostand() {
		KontoVerwaltung kv = new KontoVerwaltung(blz);
		return kv.getKontostand();
	}

	@Override
	public void einzahlung(double wert) {
		KontoVerwaltung kv = new KontoVerwaltung(blz);
		kv.einzahlung(wert);
	}

	@Override
	public void auszahlung(double wert) {
		KontoVerwaltung kv = new KontoVerwaltung(blz);
		kv.auszahlung(wert);
	}

	@Override
	public boolean pinEingabe(int pin) {
		return false;
	}

	@Override
	public void getKontoauszug() {
		KontoVerwaltung kv = new KontoVerwaltung(blz);
		kv.getKontoauszug(); 
	}

	@Override
	public void ueberweisung() {
		// TODO Auto-generated method stub
		
	}




}
