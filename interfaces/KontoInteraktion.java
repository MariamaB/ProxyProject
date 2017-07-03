package htw.designpattern.projekt.proxy.interfaces;

public interface KontoInteraktion {
	
	public double getKontostand();
	
	public double einzahlung(double wert);
	public double auszahlung(double wert);
	
//	public boolean pinEingabe(int pin);
	
	public void getKontoauszug();
	public void ueberweisung(String blz, String verwendungszweck, double betrag);

//	void setKontostand(double wert);
	

}
