package htw.designpattern.projekt.proxy.bank;

import java.util.HashMap;
import java.util.List;

import htw.designpattern.projekt.proxy.bank.model.Kontoinhaber;
import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;
import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class Konto implements KontoInteraktion, KontoAnlegen{
	

	private String blz;
	private int pin;
	private Kontoinhaber kontoinhaber;
	
	private double kontostand;
	private HashMap<String, Integer> umsätze;


	protected Konto(){ 
	
	}

	
//
//	@Override
//	public void setName() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setVorname() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setPin() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setBlz() {
//		this.blz = blz;
//		
//	}
//
//	@Override
//	public void setKontostand() {
//		this.kontostand = this.kontostand;
//		
//	}

	@Override
	public double getKontostand() {
		return this.kontostand;
	}

	@Override
	public void einzahlung(double wert) {
		this.kontostand = this.kontostand + wert;
		
	}

	@Override
	public void auszahlung(double wert) {
		this.kontostand = this.kontostand - wert;
		
	}

	@Override
	public boolean pinEingabe(int pin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getKontoauszug() {
		System.out.println("Konto [umsätze=" + umsätze + "]");	
	}

	@Override
	public void ueberweisung() {
			
	}


	@Override
	public Konto createKonto(String name, String vormane, String blz, int pin, double kontostand) {
		Konto k = new Konto();
		k.kontoinhaber.setVorname("Miriam");
		k.kontoinhaber.setName("Lischke");
		k.blz = blz;
		k.pin = pin;
		k.kontostand = kontostand;
		return k;
	}

	
	
	

}
