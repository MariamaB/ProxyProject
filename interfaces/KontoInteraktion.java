package htw.designpattern.projekt.proxy.interfaces;

public interface KontoInteraktion {
	
	public double getKontostand();
	
	public double einzahlung(double betrag);
	public double auszahlung(double betrag);
	public void getKontoauszug();
	public void ueberweisung(String blz, String verwendungszweck, double betrag);
	

}
