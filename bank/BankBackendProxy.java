package htw.designpattern.projekt.proxy.bank;

import java.util.List;

import htw.designpattern.projekt.proxy.bank.model.Konto;
import htw.designpattern.projekt.proxy.bank.model.Kontoinhaber;
import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class BankBackendProxy implements KontoAnlegen{
	
	
	@Override
	public void createKonto(String name, String vormane, String blz, int pin, double kontostand) {	
		Backend b = new Backend();
		b.createKonto(name, vormane, blz, pin, kontostand);
	}
	

}
