package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Espandi {
	
	private List<Schedina> soluzioni;
	
	public List<Schedina> espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN()) ;
		
		this.soluzioni = new ArrayList<Schedina>(); //vuota
		
		espandi(p, parziale, 0) ; 
		
		//non pi� vuota
		
		return soluzioni;
	}
	
	
	// Livello della ricorsione = singola partita
	// livello = 0 -> schedina con 0 risultati
	// livello = 1 -> schedina con 1 risultato ...
	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		
		// parziale contiene già (livello) valori 
		//		nelle posizioni 0...livello-1
		// io devo determinare parziale[livello]
		//		(cioè la livello+1 esima riga)
		// sulla base della previsione in p[livello]
		
		
		if(livello==p.getN()) {
			
			this.soluzioni.add(new Schedina(parziale));
			return ;
		}
		
		
		Previsione prev = p.get(livello) ;
		
		// prova le varie alternative
		for(Risultato r: prev.getValori()) {
			// provo ad aggiungere 'r'
			parziale.add(r);
			
			espandi(p, parziale, livello+1) ;
			
			// backtrack
			parziale.removeLast();
			
		}
		
	}
	

}
