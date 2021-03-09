package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempi;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;

    /**
     * Inserisce nuova parola all'elenco e me lo stampa in ordine alfabetico
     * @param event
     */
    @FXML
    void doInsert(ActionEvent event) {
    	long tempoIn=System.nanoTime();
    	String parola=txtParola.getText();
    	if(parola.matches(".*\\d.*")) {
    		txtResult.setText("Inserire una parola valida!");
    		txtParola.setText("");
    		return;
    	} else {
    		elenco.addParola(parola);
    		String risultato="";
    		for(String s:this.elenco.getElenco()) {
    			risultato=risultato+s+"\n";
    		}
    		txtResult.setText(risultato);
    		txtParola.setText("");
    	}
    	long tempoFin=System.nanoTime()-tempoIn;
    	txtTempi.setText("Tempo impiegato (in nanosecondi): "+tempoFin);
    }

    /**
     * Svuota l'elenco
     * @param event
     */
    @FXML
    void doReset(ActionEvent event) {
    	long tempo1=System.nanoTime();
    	elenco.reset();
    	txtResult.setText("");
    	long tempo2=System.nanoTime()-tempo1;
    	txtTempi.setText("Tempo impiegato (in nanosecondi): "+tempo2);
    }
    
    /**
     * Cancella dall'elenco la parola inserita in txtParola
     * @param event
     */
    @FXML
    void doCancella(ActionEvent event) {
    	long tempo1=System.nanoTime();
    	String parola=txtParola.getText();
    	if(parola.matches(".*\\d.*")) {
    		txtResult.setText("Inserisci una parola valida!");
    		txtParola.setText("");
    		return;
    	} else {
    		boolean fatto=elenco.elimina(parola);
    		String risultato="";
    		for(String s:this.elenco.getElenco()) {
    			risultato=risultato+s+"\n";
    		}
    		txtResult.setText(risultato);
    		txtParola.setText("");    		
    		if(fatto) {
    			txtResult.appendText("\nParola eliminata con successo");
    		} else {
    			txtResult.appendText("\nParola non presente in elenco");
    		}
    	}
    	long tempo2=System.nanoTime()-tempo1;
    	txtTempi.setText("Tempo impiegato (in nanosecondi): "+tempo2);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
