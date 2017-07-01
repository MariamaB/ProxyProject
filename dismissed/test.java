package htw.designpattern.projekt.proxy.dismissed;

import htw.designpattern.projekt.proxy.bank.model.Konto;

public class test {
	public static void main(String[] args) {
		klasse2 k2 = new klasse2();
		
		System.out.println(k2.test[0][0]);
		System.out.println(k2.test[1][0]);
		
		

		@Override
		public Konto createKonto(String name, String vormane, String blz, int pin, double kontostand) {
			Konto k = new Konto();
			k.kontoinhaber.setVorname("Miriam");
			k.kontoinhaber.setName("Lischke");
			k.blz = blz;
			k.pin = pin;
			k.kontostand = kontostand;
			return k;
		}
	}

}
