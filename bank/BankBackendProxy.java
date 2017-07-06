package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class BankBackendProxy implements KontoAnlegen{
	
	
	@Override
	public boolean createKonto(String name, String vormane, String blz, int pin, double kontostand) {	
		KontoAnlegen kv = new KontoVerwaltung();
		return kv.createKonto(name, vormane, blz, pin, kontostand);
	}

	@Override
	public boolean deleteKonto(String blz) {
		KontoAnlegen kv = new KontoVerwaltung();
		return kv.deleteKonto(blz);
	}
	

}
