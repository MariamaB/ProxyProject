package htw.designpattern.projekt.proxy;

import htw.designpattern.projekt.proxy.bank.model.Konto;

public class Client {

	public static void main(String[] args) {
		
		Konto k = new Konto();
		
		k.setBlz("wewa");
		System.out.println(k.getBlz());
		
	}

}
