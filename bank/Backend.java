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

public class Backend implements KontoAnlegen{
	private Konto konto = new Konto();
	private String csv = "C:\\Users\\mlisc\\IKT\\IKTuebung\\src\\htw\\designpattern\\projekt\\proxy\\csv\\DB.csv";
	
	protected Backend() {
	
	}

	@Override
	public boolean createKonto(String name, String vorname, String blz, int pin, double kontostand) {
		
		try {
			List <String[]>dbList = this.getKontoList();
			String[] kA = new String[5];
			
		    kA[0] = name;
		    kA[1] = vorname;
		    kA[2] = blz;
		    kA[3] = ""+pin;
		    kA[4] = ""+kontostand;
	
		    CSVWriter writer = new CSVWriter(new FileWriter(csv));
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
		String kP = kundenPin+"";
		try {
			List <String[]>dbList = this.getKontoList();
			for (String[] strings : dbList) {
				if (strings[2].equals(blz)){
					if (strings[3].equals(kP)){
						konto.getKontoinhaber().setName(strings[0]);
						konto.getKontoinhaber().setVorname(strings[1]);
						konto.setBlz(strings[2]);
						konto.setPin(Integer.parseInt(strings[3]));
						konto.setKontostand((Double.parseDouble(strings[4])));
					}else{System.out.println("Pin Eingabe falsch! "+kundenPin+"   "+blz);}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return konto;	
	}
	
	protected Konto getKonto(String blz){
		try {
			List <String[]>dbList = this.getKontoList();
			for (String[] strings : dbList) {
				if (strings[2].equals(blz)){
					konto.getKontoinhaber().setName(strings[0]);
					konto.getKontoinhaber().setVorname(strings[1]);
					konto.setBlz(strings[2]);
					konto.setPin(Integer.parseInt(strings[3]));
					konto.setKontostand((Double.parseDouble(strings[4])));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return konto;	
	}
	
	private List<String[]> getKontoList() throws IOException{
		CSVReader reader = new CSVReader(new FileReader(csv), ',');
		List <String[]>dbList = reader.readAll();
		reader.close();
		return dbList;
		
	}
	
	public void updateKonto(String blz, Konto k){
	
			
		try {
			List<String[]> dbList = this.getKontoList();
			CSVWriter writer = new CSVWriter(new FileWriter(csv));
			
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
	    String umseatzeCsv = "C:\\Users\\mlisc\\IKT\\IKTuebung\\src\\htw\\designpattern\\projekt\\proxy\\csv\\"+blz+"Umseatze.csv";
		System.out.println(!new File(umseatzeCsv).exists());
	    if (!new File(umseatzeCsv).exists()) {
	    	System.out.println("ist rein!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			 FileWriter fileWriter = new FileWriter(umseatzeCsv);
			 fileWriter.close();
		}
	   
			
		java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		
			CSVReader readerCsv = new CSVReader(new FileReader(umseatzeCsv), ',');
			List <String[]> umsatzList = readerCsv.readAll();
			readerCsv.close();
			
			for (String[] strings : umsatzList) {
				System.out.println(" was passiert hier?"+strings[1]);
			}
			
			String[] kUmsaetze = new String [3];
			
			kUmsaetze[0] = sdf.format(timestamp);
			kUmsaetze[1] = umsatz;
			kUmsaetze[2] = betrag+" €";
			
			CSVWriter writer = new CSVWriter(new FileWriter(umseatzeCsv));
			if (!umsatzList.isEmpty()) {
				System.out.println("is in!!!ALL");
				umsatzList.add(kUmsaetze);
				writer.writeAll(umsatzList);
			}else {
				System.out.println("is in!!!ONE");
				writer.writeNext(kUmsaetze);
			}
		
		writer.close();
 	}
	
	public void getUmseatze(String blz) throws IOException{
		String umseatzeCsv = "C:\\Users\\mlisc\\IKT\\IKTuebung\\src\\htw\\designpattern\\projekt\\proxy\\csv\\"+blz+"Umseatze.csv";
		
		CSVReader reader = new CSVReader(new FileReader(umseatzeCsv), ',');
		List <String[]> umsatzList = reader.readAll();
		reader.close();
		System.out.println("Umseatze: [ ");
		for (String[] strings : umsatzList) {
			System.out.println(strings[0]+" "+strings[1]+" "+strings[2]);
		}
		System.out.println(" ]");
	}

}
