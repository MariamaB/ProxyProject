package htw.designpattern.projekt.proxy.bank;

import java.util.HashMap;

public class Konto{
	
	protected Kontoinhaber kontoinhaber;
	protected String blz;
	protected int pin;
	protected double kontostand;
	protected HashMap<String, Integer> ums�tze;
	
	protected Konto(){ 
		kontoinhaber = new Kontoinhaber();
		ums�tze = new HashMap<>();
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







	
	
	

}
