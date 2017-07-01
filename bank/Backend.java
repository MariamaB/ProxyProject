package htw.designpattern.projekt.proxy.bank;

import htw.designpattern.projekt.proxy.bank.model.Konto;

public class Backend{
	
	protected Konto [] konten;
	private Konto konto;
	
	public Backend() {
		konten = new Konto [2];
		konto = new Konto();
		
		konten[0] = konto.createKonto("Lischke", "Miriam", "DE82 1005 0000 6011 9838 88", 
				1234, 30.000);
		konten[1] = konto.createKonto("Nan Danke", "Felix", "DE84 1005 0000 6012 9878 24", 
				4321, 30.000);
	}

}
