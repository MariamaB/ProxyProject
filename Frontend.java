package htw.designpattern.projekt.proxy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import htw.designpattern.projekt.proxy.bank.BankAutomatProxy;
import htw.designpattern.projekt.proxy.bank.MitarbeiterZugang;
import htw.designpattern.projekt.proxy.interfaces.KontoInteraktion;

public class Frontend {
	JFrame window;
	JPanel panel,buttonPanel;
	JLabel derText;
	JButton auszahlung,einzahlung,kontostand, kontoauszug;
	public Frontend() {
		window = new JFrame("BankAutomat");
		panel = new JPanel();
		
		window.setSize(500, 500);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(new GridLayout(2, 1));

		derText = new JLabel("Nachts ist es k‰lter als Drauﬂen!");
		buttonPanel = this.initButtonPanel();
		
		panel.add(derText);
		panel.add(buttonPanel);
		
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}




	private JPanel initButtonPanel() {
		JPanel panel = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.orange);
		panelWest.setLayout(new GridLayout(1, 2));
		panelEast.setLayout(new GridLayout(1, 2));
		
		auszahlung = new JButton("Auszahlung");
		einzahlung = new JButton("Einzahlung");
		kontostand = new JButton("Kontostand");
		kontoauszug = new JButton("Kontoauszug");
		
		panelWest.add(auszahlung);
		panelWest.add(einzahlung);
		
		panelEast.add(kontostand);
		panelEast.add(kontoauszug);
		
		panel.add(panelWest,BorderLayout.WEST);
		panel.add(panelEast,BorderLayout.EAST);
		
		return panel;
	}




	public static void main(String[] args) {
		new Frontend();	

		MitarbeiterZugang bMA = new MitarbeiterZugang();
		bMA.createKonto(123,"Lischke", "Miriam", "DE82 1005 0000 6011 9838 77", 
				1234, 30.000);

		bMA.createKonto(123,"Nan Danke", "Felix", "DE84 1005 0000 6012 9878 24", 
				4321, 50.000);

		bMA.createKonto(123,"Mustermann", "Will", "DE82 1005 0000 6511 3338 77", 
				5678, 90.000);



		KontoInteraktion miriam = new BankAutomatProxy("DE82 1005 0000 6011 9838 77",1234);
		KontoInteraktion felix = new BankAutomatProxy("DE84 1005 0000 6012 9878 24",4321);

		miriam.auszahlung(10.0);
		miriam.einzahlung(200.0);


		miriam.ueberweisung("DE84 1005 0000 6012 9878 24", "Miete", 150);

		miriam.getKontoauszug();
		felix.getKontoauszug();
		System.out.println("Miriam: "+miriam.getKontostand()+"  Felix: "+felix.getKontostand());

		bMA.deleteKonto(123,"DE82 1005 0000 6011 9838 77");

	}

}
