package htw.designpattern.projekt.proxy.bank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
	public void createKonto(String name, String vorname, String blz, int pin, double kontostand) {
		
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
				}else{
					writer.writeAll(dbList);
					System.out.println("Konto existiert bereits!");
				}
			}else{
				writer.writeNext(kA);
				 System.out.println("Konto wurde erfolgreich angelegt!");
			}
	        writer.close();
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Konto getKonto(String blz){
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
	
	

}
