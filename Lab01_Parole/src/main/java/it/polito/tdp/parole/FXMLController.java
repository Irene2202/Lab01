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
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
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
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.setText("");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
