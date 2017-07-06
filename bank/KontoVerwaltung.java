package htw.designpattern.projekt.proxy.bank;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import htw.designpattern.projekt.proxy.interfaces.KontoAnlegen;
import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class KontoVerwaltung implements KontoInteraktion,KontoAnlegen{
	private Konto konto;
	private String kontenCsv = "DB.csv";
	protected KontoVerwaltung(){
	
	}
	protected KontoVerwaltung(String blz, int kundenPin) {
		konto = this.getKonto(blz, kundenPin);	
	}
	
	@Override
	public double getKontostand() {
		return konto.getKontostand();
	}

	@Override
	public double einzahlung(double betrag) {
		konto.setKontostand(konto.getKontostand() + betrag);
		this.updateKonto(konto.getBlz(),konto);
		try {
			this.updateUmzaetze(konto.getBlz(), "Einzahlung ", betrag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return konto.getKontostand() + betrag;
	}

	@Override
	public double auszahlung(double betrag) {
		konto.setKontostand(konto.getKontostand() - betrag);
		this.updateKonto(konto.getBlz(),konto);
		try {
			this.updateUmzaetze(konto.getBlz(), "Auszahlung ", betrag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return konto.getKontostand() - betrag;
	}

	@Override
	public void getKontoauszug() {
		try {
			this.getUmseatze(konto.getBlz());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void ueberweisung(String blz, String verwendungszweck, double betrag) {
		
		Konto begünstigter = this.getKonto(blz);
		begünstigter.setKontostand(begünstigter.getKontostand() + betrag);
		this.updateKonto(begünstigter.getBlz(),begünstigter);
		
		konto.setKontostand(konto.getKontostand() - betrag);
		this.updateKonto(konto.getBlz(),konto);
		
		begünstigter.setKontostand(begünstigter.getKontostand() + betrag);
		
		try {
			this.updateUmzaetze(konto.getBlz(), "Ueberweisung an "+begünstigter.getKontoinhaber().fullName()+
					" "+verwendungszweck, betrag);
			this.updateUmzaetze(begünstigter.getBlz(), "Ueberweisung von "+konto.getKontoinhaber().fullName()+
					" "+verwendungszweck, betrag);
					} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean createKonto(String name, String vorname, String blz, int pin, double kontostand) {
		
		try {
			if(!new File(kontenCsv).exists()){
				FileWriter fileWriter = new FileWriter(kontenCsv);
				fileWriter.flush();
				fileWriter.close();
			}
			
			
			List <String[]>dbList = this.getKontoList();
			String[] kA = new String[5];
			
		    kA[0] = name;
		    kA[1] = vorname;
		    kA[2] = blz;
		    kA[3] = ""+pin;
		    kA[4] = ""+kontostand;
		    
		   
		    CSVWriter writer = new CSVWriter(new FileWriter(kontenCsv));
	        boolean isInsideOf = false; 
			if(!dbList.isEmpty()){
				for (int i = 0; i < dbList.size(); i++) {
					for (String string : dbList.get(i)) {
						
						if (string.equals(kA[2])) {
							isInsideOf = true;
						}
					}
				}
				if (!isInsideOf) {
					dbList.add(kA);
					writer.writeAll(dbList);
			        System.out.println("Konto wurde erfolgreich angelegt!");
			        writer.close();
			        	return true;
				}else{
					writer.writeAll(dbList);
					System.out.println("Konto existiert bereits!");
			        writer.close();
					return false;
				}
			}else{
				writer.writeNext(kA);
				 System.out.println("Konto wurde erfolgreich angelegt!");
			        writer.close();
				 return true;
			}
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Konto getKonto(String blz, int kundenPin){
		Konto k = new Konto();
		String kP = kundenPin+"";
		try {
			List <String[]>dbList = this.getKontoList();
			for (String[] strings : dbList) {
				if (strings[2].equals(blz)){
					if (strings[3].equals(kP)){
						k.getKontoinhaber().setName(strings[0]);
						k.getKontoinhaber().setVorname(strings[1]);
						k.setBlz(strings[2]);
						k.setPin(Integer.parseInt(strings[3]));
						k.setKontostand((Double.parseDouble(strings[4])));
					}else{System.out.println("Pin Eingabe falsch! "+kundenPin+"   "+blz);}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;	
	}
	
	protected Konto getKonto(String blz){
		Konto k = new Konto();
		try {
			List <String[]>dbList = this.getKontoList();
			for (String[] strings : dbList) {
				if (strings[2].equals(blz)){
					k.getKontoinhaber().setName(strings[0]);
					k.getKontoinhaber().setVorname(strings[1]);
					k.setBlz(strings[2]);
					k.setPin(Integer.parseInt(strings[3]));
					k.setKontostand((Double.parseDouble(strings[4])));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;	
	}
	
	private List<String[]> getKontoList() throws IOException{
		CSVReader reader = new CSVReader(new FileReader(kontenCsv), ',');
		List <String[]>dbList = reader.readAll();
		reader.close();
		return dbList;
		
	}
	
	public void updateKonto(String blz, Konto k){
	
			
		try {
			List<String[]> dbList = this.getKontoList();
			CSVWriter writer = new CSVWriter(new FileWriter(kontenCsv));
			
			for (String[] strings : dbList) {
				if (strings[2].equals(blz)){
					strings[0] = k.getKontoinhaber().getName();
					strings[1] = k.getKontoinhaber().getVorname();
					strings[2] = k.getBlz();
					strings[3] = k.getPin()+"";
					strings[4] = k.getKontostand()+"";
				}
			}
			writer.writeAll(dbList);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateUmzaetze(String blz, String umsatz, double betrag) throws IOException{
	    String umseatzeCsv = ""+blz+"_Umseatze.csv";
		System.out.println(!new File(umseatzeCsv).exists());
	    if (!new File(umseatzeCsv).exists()) {

			 FileWriter fileWriter = new FileWriter(umseatzeCsv);
			 fileWriter.flush();
			 fileWriter.close();
		}
	   
			
		java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		
			CSVReader readerCsv = new CSVReader(new FileReader(umseatzeCsv), ',');
			List <String[]> umsatzList = readerCsv.readAll();
			readerCsv.close();
			
			String[] kUmsaetze = new String [3];
			
			kUmsaetze[0] = sdf.format(timestamp);
			kUmsaetze[1] = umsatz;
			kUmsaetze[2] = betrag+" €";
			
			CSVWriter writer = new CSVWriter(new FileWriter(umseatzeCsv));
			if (!umsatzList.isEmpty()) {
				umsatzList.add(kUmsaetze);
				writer.writeAll(umsatzList);
			}else {
				writer.writeNext(kUmsaetze);
			}
		
		writer.close();
 	}
	
	public void getUmseatze(String blz) throws IOException{
		String umseatzeCsv = ""+blz+"_Umseatze.csv";
	    if (!new File(umseatzeCsv).exists()) {

			 FileWriter fileWriter = new FileWriter(umseatzeCsv);
			 fileWriter.flush();
			 fileWriter.close();
		}

		CSVReader reader = new CSVReader(new FileReader(umseatzeCsv), ',');
		List <String[]> umsatzList = reader.readAll();
		reader.close();
		System.out.println(blz+" Umseatze: [ ");
		for (String[] strings : umsatzList) {
			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
		}
		System.out.println(" ]");
	}
	@Override
	public boolean deleteKonto(String blz) {
		
		try {
			List<String[]> dbList = this.getKontoList();
			CSVWriter writer = new CSVWriter(new FileWriter(kontenCsv));
			
			for(int i=0; i<dbList.size();i++){
				if (dbList.get(i)[2].equals(blz)){
					dbList.remove(i);
					System.out.println("Konto wurde erfolgreich gelöscht!");
				}
			}
			writer.writeAll(dbList);
			writer.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
