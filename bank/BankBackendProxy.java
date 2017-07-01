package htw.designpattern.projekt.proxy.bank;

import java.util.List;

import htw.designpattern.projekt.proxy.bank.model.Konto;
import htw.designpattern.projekt.proxy.bank.model.Kontoinhaber;
import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class BankBackendProxy implements KontoAnlegen{
	


	public BankBackendProxy() {

	}
	
	@Override
	public Konto createKonto(String name, String vormane, String blz, int pin, double kontostand) {	
		return new Konto().createKonto(name, vormane, blz, pin, kontostand);
	}
	
	public List <Konto> getKonten(){
		return konten;
	}



}
