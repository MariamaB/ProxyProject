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
	
	protected HashMap<String, Konto>konten = new HashMap<>();
	private Konto konto = new Konto();

	
	protected Backend() {
	
	}

	@Override
	public void createKonto(String name, String vorname, String blz, int pin, double kontostand) {
		
		String csv = "C:\\Users\\mlisc\\IKT\\IKTuebung\\src\\htw\\designpattern\\projekt\\proxy\\csv\\DB.csv";
      
		try {
			CSVReader reader = new CSVReader(new FileReader(csv), ',');
	       
			
			List <String[]>dbList = reader.readAll();
			reader.close();
			
			
			Kontoinhaber kontoinhaber = new Kontoinhaber(name,vorname);
			konto = new Konto(kontoinhaber, blz, pin, kontostand);
			String[] kA = new String[5];
			
		    for (int i=0; i< dbList.size(); i++) {
		    	System.out.println("was los??"+dbList.get(i));
			}
			
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
				}else{
					writer.writeAll(dbList);
				}
				System.out.println("hat geklappt! List");
			}else{
				writer.writeNext(kA);
				System.out.println("hat geklappt! Array");
			}
		
//	        System.out.println("CSV File written successfully line by line");
	        writer.close();
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	
	

}
