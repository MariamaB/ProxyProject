package htw.designpattern.projekt.proxy.interfaces;

public interface KontoInteraktion {
	
	public double getKontostand();
	
	public void einzahlung(double wert);
	public void auszahlung(double wert);
	
	public boolean pinEingabe(int pin);
	
	public void getKontoauszug();
	public void ueberweisung();

//	void setKontostand(double wert);
	

}
