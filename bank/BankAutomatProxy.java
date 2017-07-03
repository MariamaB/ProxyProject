package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class BankAutomatProxy implements KontoInteraktion {
	
	private String blz;
	private int pin;
	
	public BankAutomatProxy(String ecKarte, int kundenPin) {
		this.blz = ecKarte;
		this.pin = kundenPin;
	}

	@Override
	public double getKontostand() {
		KontoVerwaltung kv = new KontoVerwaltung(blz, pin);
		return kv.getKontostand();
	}

	@Override
	public double einzahlung(double wert) {
		KontoVerwaltung kv = new KontoVerwaltung(blz, pin);
		return kv.einzahlung(wert);
	}

	@Override
	public double auszahlung(double wert) {
		KontoVerwaltung kv = new KontoVerwaltung(blz, pin);
		
		return kv.auszahlung(wert);
	}

	@Override
	public void getKontoauszug() {
		KontoVerwaltung kv = new KontoVerwaltung(blz,pin);
		kv.getKontoauszug(); 
	}

	@Override
	public void ueberweisung(String blz, String verwendungszweck, double betrag) {
		// TODO Auto-generated method stub
		
	}




}
