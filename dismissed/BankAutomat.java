//package htw.designpattern.projekt.proxy.dismissed;
//
//import java.util.HashMap;
//import java.util.List;
//
//import htw.designpattern.projekt.proxy.bank.Konto;
//import htw.designpattern.projekt.proxy.bank.model.Kontoinhaber;
//import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;
//
//public class BankAutomat implements KontoInteraktion{
//	
//	private List<Konto> konten;
//	Konto konto;
//
//	
//	protected BankAutomat(String ecKarte){ 
//		
//		for (Konto konto : konten) {
//			if (konto.getBlz().equals(ecKarte)) {
//				this.konto = konto;
//			} else {
//				System.out.println("Dieses Konto existiert nicht");
//			}
//		}
//	}
//	
//	
//
//	@Override
//	public double getKontostand() {
//		return konto.getKontostand();
//	}
//
//	@Override
//	public void einzahlung(double wert) {
//		konto.setKontostand(this.getKontostand() + wert); 
//	}
//
//	@Override
//	public void auszahlung(double wert) {
//		konto.setKontostand(this.getKontostand() - wert); 
//	}
//
//	@Override
//	public boolean pinEingabe(int pin) {
//		
//		return false;
//	}
//
//	@Override
//	public void getKontoauszug() {
//		konto.getKontoauszug();
//		
//	}
//
//	@Override
//	public void ueberweisung() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
