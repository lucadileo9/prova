package grafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextField;

import codifica.*;

/**
 * Classe che implementa il panello contenente la tabella, il totale,
 * il menu e i vari bottoni
 * @author Luca Di Leo
 *
 */
public class MyPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	/**
	 * rancio da attaccare alla tabella
	 */
	private cod c; 
	/**
	 * Bottoni
	 */
	private JButton codifica, decodifica; 
	/**
	 * Testo
	 */
	private JTextField inserisciTesto, risultato;
	 /**
	  * Costruttore che copia il rancio, inizalizza tutte le componenti, aggiungendo i vari
	  * ascoltatori, per poi aggiungerli al pannello 
	  * @param r rancio
	  */
	public MyPanel(cod c) {
		super();
		this.c = c;

		
		//inizializzo i bottoni, i testi e aggiungo gli ascoltatori
		 
		codifica= new JButton("Codifica");
        decodifica= new JButton("Decodifica");
        inserisciTesto = new JTextField();
        inserisciTesto.setSize(700,700);
        risultato = new JTextField();
        codifica.addActionListener(this);
		decodifica.addActionListener(this);

		// Pannello principale con layout BorderLayout
        //JPanel mainPanel = new JPanel(new BorderLayout());

        // Pannello per i pulsanti (nord)
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(codifica);
        buttonPanel.add(decodifica);

        // Pannello per l'inserimento del testo (centro)
        JPanel textPanel = new JPanel(new BorderLayout());
        inserisciTesto = new JTextField();
        textPanel.add(new JLabel("Inserisci il testo:"), BorderLayout.NORTH);
        textPanel.add(inserisciTesto, BorderLayout.CENTER);

        // Pannello per il risultato (sud)
        JPanel resultPanel = new JPanel(new BorderLayout());
        risultato = new JTextField();
        risultato.setEditable(false); // Impedisce l'editing del risultato
        resultPanel.add(new JLabel("Risultato:"), BorderLayout.NORTH);
        resultPanel.add(risultato, BorderLayout.CENTER);

        // Aggiungi pannelli al pannello principale
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(textPanel, BorderLayout.CENTER);
        this.add(resultPanel, BorderLayout.SOUTH);
	}
	

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object scelta= e.getSource();
		
		if(scelta==codifica) {
			//rimuovo la voce selezionata
			String stringaOriginale = inserisciTesto.getText();

			// Trasformare la String in un StringBuffer
			StringBuffer stringBuffer = new StringBuffer(stringaOriginale);
			c.cambiaParola(stringBuffer);
			c.codificaParola();
			risultato.setText(c.parolaCodificata.toString());
		}
		
		else  if (scelta==decodifica){
			//rimuovo la voce selezionata
			String stringaOriginale = inserisciTesto.getText();

			// Trasformare la String in un StringBuffer
			StringBuffer stringBuffer = new StringBuffer(stringaOriginale);
			c.cambiaParola(stringBuffer);
			c.decodificaParola();
			risultato.setText(c.parolaDecodificata.toString());
		
		}
	}}
		

