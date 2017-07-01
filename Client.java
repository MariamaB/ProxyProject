package htw.designpattern.projekt.proxy;

import htw.designpattern.projekt.proxy.bank.BankAutomatProxy;
import htw.designpattern.projekt.proxy.bank.BankMitarbeiter;

public class Client {

	public static void main(String[] args) {
			
		
		BankMitarbeiter bMA = new BankMitarbeiter();
		bMA.createKonto(123,"Lischke", "Miriam", "DE82 1005 0000 6011 9838 88", 
				1234, 30.000);
		
		bMA.createKonto(123,"Nan Danke", "Felix", "DE84 1005 0000 6012 9878 24", 
				4321, 50.000);
		
		BankAutomatProxy bA = new BankAutomatProxy("DE82 1005 0000 6011 9838 88");
		BankAutomatProxy bA2 = new BankAutomatProxy("DE84 1005 0000 6012 9878 24");
		System.out.println("MIriam: "+bA.getKontostand()+"  Felix: "+bA2.getKontostand());
		
		
		
	}

}
