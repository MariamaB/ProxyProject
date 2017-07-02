package htw.designpattern.projekt.proxy.bank;

import java.util.HashMap;

public class Konto{
	
	private Kontoinhaber kontoinhaber;
	private String blz;
	private int pin;
	private double kontostand;
	private HashMap<String, Integer> umsätze = new HashMap<>();;
	
	protected Konto(){ 
		kontoinhaber = new Kontoinhaber();
		umsätze = new HashMap<>();
	}
	
	protected Konto(Kontoinhaber kontoinhaber, String blz, int pin, double kontostand) {
		super();
		this.kontoinhaber = kontoinhaber;
		this.blz = blz;
		this.pin = pin;
		this.kontostand = kontostand;
	}

	
	public String getBlz() {
		return blz;
	}

	public void setBlz(String blz) {
		this.blz = blz;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Kontoinhaber getKontoinhaber() {
		return kontoinhaber;
	}

	public void setKontoinhaber(Kontoinhaber kontoinhaber) {
		this.kontoinhaber = kontoinhaber;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}

	public HashMap<String, Integer> getUmsätze() {
		return umsätze;
	}

	public void setUmsätze(HashMap<String, Integer> umsätze) {
		this.umsätze = umsätze;
	}


	@Override
	public String toString() {
		return "Konto [kontoinhaber=" + kontoinhaber + ", blz=" + blz + ", pin=" + pin + ", kontostand=" + kontostand
				+ ", umsätze=" + umsätze + "]";
	}





	
	
	

}
