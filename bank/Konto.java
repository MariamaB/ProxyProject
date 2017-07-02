package htw.designpattern.projekt.proxy.bank;

import java.util.HashMap;

public class Konto{
	
	protected Kontoinhaber kontoinhaber;
	protected String blz;
	protected int pin;
	protected double kontostand;
	protected HashMap<String, Integer> ums�tze = new HashMap<>();;
	
	protected Konto(){ 

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

	public HashMap<String, Integer> getUms�tze() {
		return ums�tze;
	}

	public void setUms�tze(HashMap<String, Integer> ums�tze) {
		this.ums�tze = ums�tze;
	}


	@Override
	public String toString() {
		return "Konto [kontoinhaber=" + kontoinhaber + ", blz=" + blz + ", pin=" + pin + ", kontostand=" + kontostand
				+ ", ums�tze=" + ums�tze + "]";
	}





	
	
	

}
