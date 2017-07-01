package htw.designpattern.projekt.proxy.bank;

import java.util.List;

import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;

public class Backend implements KontoAnlegen {
	
	private List<Konto> konten;
	
	public Backend() {
		konten.add(this.createKonto("Lischke", "Miriam", "DE82 1005 0000 6011 9838 88", 
				1234, 30.000));
		konten.add(this.createKonto("Nan Danke", "Felix", "DE84 1005 0000 6012 9878 24", 
				4321, 30.000));
	}

	@Override
	public Konto createKonto(String name, String vormane, String blz, int pin, double kontostand) {
		Konto k = new Konto();
		return k.createKonto(name, vormane, blz, pin, kontostand);
	}

}
