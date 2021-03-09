package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	private List<String> parole;
		
	public Parole() {
		parole=new ArrayList<String>();
		//parole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole, new OrdineAlfabetico());
		return parole;
	}
	
	/**
	 * Resetta l'elenco delle parole
	 */
	public void reset() {
		parole.clear();
	}
	
	/**
	 * elimina elemento passato dalla lista di parole
	 * se non è presente return 'false'
	 * @return
	 */
	public boolean elimina(String p) {
		if(parole.contains(p)==false) {
			return false;
		} else {
			parole.remove(p);
			return true;
		}
	}

}
