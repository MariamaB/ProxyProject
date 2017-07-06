package htw.designpattern.projekt.proxy.interfaces;

public interface KontoAnlegen {
	
	public boolean createKonto(String name, String vorname, String blz, int pin, double kontostand);
	public boolean deleteKonto(String blz);
}
