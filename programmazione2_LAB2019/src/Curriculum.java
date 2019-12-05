import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
	private HashSet<Corso> corsi = new HashSet<Corso>() ;
	private final int minCfu;
	
	/**
	 * Costruttore
	 * @param nome
	 * @param minCfu
	 * @param corsi
	 */
	public Curriculum(String nome, int minCfu, HashSet<Corso> corsi){
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
	 * Questo metodo itera attraverso un ciclo FOR sul vettore dei corsi per visualizzare quelli a scelta
	 * utilizzato da un metodo definito nella classe Corso chiamato isAscelta()
	 * @return
	 */
	
	public Corso[] getCorsiAScelta() {

		ArrayList<Corso> corsiAScelta = new ArrayList<Corso>();
		Iterator<Corso> itr = this.corsi.iterator();
		while(itr.hasNext()) {
			Corso corso = itr.next();
			if(corso.isAscelta())
				corsiAScelta.add(corso);
		}
		return (Corso[]) corsiAScelta.toArray();
	}

	
	public int getMinCfu() {
		return this.minCfu;
	}

	public int getCfuObbligatori() {
		int cfu  = 0;
		Iterator<Corso> itr = this.corsi.iterator();
		while(itr.hasNext()) {
			Corso corso = itr.next();
			if(!corso.isAscelta())
				cfu = cfu + corso.getCfu();
		}		
		return cfu;
	}

}
