package htw.designpattern.projekt.proxy.bank;

import java.io.IOException;

import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class KontoVerwaltung implements KontoInteraktion{
	private Konto konto;
	
	protected KontoVerwaltung(String blz, int kundenPin) {
		Backend backend = new Backend();
		konto = backend.getKonto(blz, kundenPin);
		
	}
	
	@Override
	public double getKontostand() {
		return konto.getKontostand();
	}

	@Override
	public double einzahlung(double wert) {
		Backend backend = new Backend();
		konto.setKontostand(konto.getKontostand() + wert);
		backend.updateKonto(konto.getBlz(),konto);
		try {
			backend.updateUmzaetze(konto.getBlz(), "Einzahlung ", wert);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return konto.getKontostand() + wert;
	}

	@Override
	public double auszahlung(double wert) {
		Backend backend = new Backend();
		konto.setKontostand(konto.getKontostand() - wert);
		backend.updateKonto(konto.getBlz(),konto);
		try {
			backend.updateUmzaetze(konto.getBlz(), "Auszahlung ", wert);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return konto.getKontostand() - wert;
	}

	@Override
	public void getKontoauszug() {
		Backend backend = new Backend();
		try {
			backend.getUmseatze(konto.getBlz());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void ueberweisung(String blz, String verwendungszweck, double betrag) {
		Backend backend = new Backend();
		Konto begünstigter = backend.getKonto(blz);
		this.auszahlung(betrag);
		begünstigter.setKontostand(begünstigter.getKontostand() + betrag);
		
		try {
			backend.updateUmzaetze(konto.getBlz(), "Ueberweisung an"+begünstigter.getKontoinhaber().fullName()+
					" "+verwendungszweck, betrag);
			backend.updateUmzaetze(begünstigter.getBlz(), "Ueberweisung von"+konto.getKontoinhaber().fullName()+
					" "+verwendungszweck, betrag);
					} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
