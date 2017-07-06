package htw.designpattern.projekt.proxy.bank;

public class Konto{
	
	private Kontoinhaber kontoinhaber;
	private String blz;
	private int pin;
	private double kontostand;
	
	protected Konto(){ 
		kontoinhaber = new Kontoinhaber();
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

	public double setKontostand(double kontostand) {
		this.kontostand = kontostand;
		return kontostand;
	}

	@Override
	public String toString() {
		return "Konto [kontoinhaber=" + kontoinhaber + ", blz=" + blz + ", pin=" + pin + ", kontostand=" + kontostand
				+ "]";
	}





	
	
	

}
