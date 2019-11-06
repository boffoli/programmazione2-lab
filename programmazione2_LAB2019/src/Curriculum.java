import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: Curriculum</p>
 * <p>Description: classe dedicata al curriculm di un corso universitario indicando nome del corso di laurea, i corsi presenti al suo interno e il numero minimo di cfu necessari per il conseguimento di tale curriculum </p>
 * <p>Company: Dipartimento di Informatica, Universit� degli studi di Bari</p>
 * <p>Class description: Curriculum </p>
 * Curriculum per gli studenti di Programmazione 2
 * @author Eleonora Totaro
 * @version 1.0
 */




public class Curriculum {
	private String nome;
	private HashSet corsi = new HashSet() ;
	private final int minCfu;
	
	/**
	 * Costruttore
	 * @param nome
	 * @param minCfu
	 * @param corsi
	 */
	public Curriculum(String nome, int minCfu, HashSet corsi){
		this.nome = nome;
		this.minCfu = minCfu;
		this.corsi = corsi;
		
	}
	
	/**
	 * Questo metodo aggiunge un corso al Curriculum
	 * @param corso
	 */
	
	
	public void add(Corso corso){
		corsi.add(corso);
	}
	
	
	/**
	 * Questo metodo il conseguimento di un numero minimo di crediti per lo studente
	 * @param corsi
	 * @return ok
	 */
	public boolean verificaConseguimento(Corso[] corsi){
		boolean ok = false;
		// se this.minCfu � <= del totale dei cfu all'interno di corsi[] allora ok = true
		
		return ok;
	}
	
	/**
	 * Questo metodo itera attraverso un ciclo FOR sul vettore dei corsi per visualizzare quelli a scelta
	 * utilizzato da un metodo definito nella classe Corso chiamato isAscelta()
	 * @return
	 */
	
	public Corso[] getCorsiAScelta() {
		// TODO Auto-generated method stub
		//FOR sul vettori corsi per scegliere quelli a scelta e darli come return 
		// facendo uso di corso.isAscelta()
		return null;
	}


}
