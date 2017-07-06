package htw.designpattern.projekt.proxy;

import htw.designpattern.projekt.proxy.bank.BankAutomatProxy;
import htw.designpattern.projekt.proxy.bank.KontoVerwaltung;
import htw.designpattern.projekt.proxy.bank.MitarbeiterZugang;
import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class Frontend {

	public static void main(String[] args) {
			
		
		MitarbeiterZugang bMA = new MitarbeiterZugang();
		bMA.createKonto(123,"Lischke", "Miriam", "DE82 1005 0000 6011 9838 88", 
				1234, 30.000);

		bMA.createKonto(123,"Nan Danke", "Felix", "DE84 1005 0000 6012 9878 24", 
				4321, 50.000);
		
		MitarbeiterZugang bMA3 = new MitarbeiterZugang();
		bMA.createKonto(123,"Mustermann", "Will", "DE82 1005 0000 6511 3338 77", 
				5678, 90.000);
		
		KontoInteraktion bA = new BankAutomatProxy("DE82 1005 0000 6011 9838 88",1234);
		KontoInteraktion bA2 = new BankAutomatProxy("DE84 1005 0000 6012 9878 24",4321);
//		bA.auszahlung(20.0);
//		bA.einzahlung(200.0);
//		bA.getKontoauszug();
//		bA2.getKontoauszug();
		
		System.out.println(bMA.deleteKonto(123,"DE82 1005 0000 6011 9838 88"));
		
		bA.getKontoauszug();
		bA2.getKontoauszug();
		System.out.println("Miriam: "+bA.getKontostand()+"  Felix: "+bA2.getKontostand());
	}

}
