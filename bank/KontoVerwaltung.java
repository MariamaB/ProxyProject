package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.bank.model.Konto;
import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class KontoVerwaltung extends Backend implements KontoInteraktion{
	private Konto konto;
	
	public KontoVerwaltung(String blz) {
		for (Konto konto : konten) {
			if(konto.getBlz().equals(blz)){
				this.konto = konto;
			}
		}
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
