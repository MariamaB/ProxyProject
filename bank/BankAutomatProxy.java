package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class BankAutomatProxy implements KontoInteraktion {
	
	public BankAutomatProxy() {
		BankBackendProxy backend = new BankBackendProxy();
	}

	@Override
	public double getKontostand() {
		Konto konto = new Konto();
		return konto.getKontostand();
	}

	@Override
	public void einzahlung(double wert) {
		Konto konto = new Konto();
		konto.einzahlung(wert);
	}

	@Override
	public void auszahlung(double wert) {
		Konto konto = new Konto();
		konto.auszahlung(wert);
	}

	@Override
	public boolean pinEingabe(int pin) {
		return false;
	}

	@Override
	public void getKontoauszug() {
		Konto konto = new Konto();
		konto.getKontoauszug(); 
	}

	@Override
	public void ueberweisung() {
		// TODO Auto-generated method stub
		
	}




}
