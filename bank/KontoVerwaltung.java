package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class KontoVerwaltung implements KontoInteraktion{
	private Konto konto;
	
	protected KontoVerwaltung(String blz) {
		Backend backend = new Backend();
		konto = backend.getKonto(blz);
		
	}
	
	@Override
	public double getKontostand() {
		return konto.getKontostand();
	}

	@Override
	public void einzahlung(double wert) {
		konto.setKontostand(konto.getKontostand() + wert);
		
	}

	@Override
	public void auszahlung(double wert) {
		konto.setKontostand(konto.getKontostand() - wert);
		
	}

	@Override
	public boolean pinEingabe(int pin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getKontoauszug() {
		System.out.println("Konto [umsätze=" + konto.getUmsätze() + "]");	
	}

	@Override
	public void ueberweisung() {
			
	}

}
