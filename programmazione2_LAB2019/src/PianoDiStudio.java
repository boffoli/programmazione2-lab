import java.util.Iterator;
import java.util.TreeSet;

/**
 * <p>Title: Piano di studio</p>
 * <p>Description: classe dedicata al piano di studi di uno studente contente la matricla dello studente, i corsi
 * 				   a scelta selezionati, il curriculm ai cui lo studente si vuole iscrivere e i metodi relativi alla
 * 				   gestione dei corsi</p>
 * <p>Company: Dipartimento di Informatica, Universita degli studi di Bari</p>
 * <p>Class description: pianoDiStudio </p>
 * Piano di studio per gli studenti di Programmazione 2
 * @author Eleonora Totaro
 * @version 1.0
 */
public class PianoDiStudio {
	private final int matricola;
	private TreeSet<Corso> corsiAsceltaSelezionati = new TreeSet<Corso>();
	private final Curriculum curriculum;
	private int cfuCorrenti = 0;
	
	/**
	 * Costruttore
	 * @param matricola
	 * @param curriculum
	 */
	public PianoDiStudio(int matricola, Curriculum curriculum){
		this.matricola = matricola;
		this.curriculum = curriculum;
		this.cfuCorrenti = curriculum.getCfuObbligatori();// crediti corsi obbligatori del CURR
	}
	
	/**
	 * Il metodo addCorsoAScelta() serve per aggiungere un nuovo corso a scelta all'interno del vettore contenente
	 * i corsi a scelta di uno studente. Prima di aggiungere un nuovo corso importante fare dei controlli. Punto
	 * primo dobbiamo verificare che il corso selezionato sia presente tra quelli a scelta del curriculm selezionato 
	 * dallo studente, punto secondo dobbiamo verificare se il corso che si vuole aggiungere non sia gia stato 
	 * selezionato in passato, punto terzo dobbiamo verificare se il corso che si vuole aggiungere non abbia orari che 
	 * vadano in sovrapposizione con corsi gia selezionati e infine dobbiamo verificare la disponibilita di posti  disposnibili 
	 * per il corso.
	 * Se tutte le condizioni sono verificate allora si puo aggiungere il corso all'intreno del vettori corsi.
	 * @param corso
	 */
	public void addCorsoAScelta(Corso corso){
		//presenza posti disponibili && non sovrapposti
		if(corso.isDisponibile() && this.corsoNonSovrapposto(corso)) {
			corso.assegnaPosto(); // invocazione fuori astrazione, valutare i contenitori 
			this.corsiAsceltaSelezionati.add(corso);
			this.cfuCorrenti = this.cfuCorrenti + corso.getCfu();
		}
	}
	
	/**
	 * Il metodo corsoSovrapposto utilizza un altro metodo presente nella classe Corso, verificaConflitto() per verificare se il corso 
	 * a scelta che si vuole aggiungere alla propria lista dei corsi non abbia orari che vadano a sovrapporsi a orari di un altro corso
	 * gia selezionato in passato.
	 * @param corso
	 * @return nonSovrapposto
	 */
	
	private boolean corsoNonSovrapposto(Corso corso) {
		Iterator<Corso> it = this.corsiAsceltaSelezionati.iterator();
		boolean nonSovrapposto = true;
		while(nonSovrapposto && it.hasNext()){
				if(it.next().verificaConflitto(corso)){
				nonSovrapposto = false;
			}
		}
		return nonSovrapposto;
	}

	/**
	 * Il metodo removeCorsoAScelta viene utilizzato per rimuove un corso a scelta precedentemente aggiunto
	 * @param corso
	 */
	public void removeCorsoAScelta(Corso corso){
		this.corsiAsceltaSelezionati.remove(corso);
		this.cfuCorrenti = this.cfuCorrenti - corso.getCfu();

	}
	
	/**
	 * Il metodo getCorsiAScelraSelezionabili viene utilizzato per mostrare i corsi a scelta ancora selezionabili dall'utente
	 * @return curriculum.getCorsiAScelta()
	 */

	public Corso[] getCorsiASceltaSelezionabili() {
		return this.curriculum.getCorsiAScelta();
	}
	
	/**
	 * Questo metodo valuta il conseguimento di un numero minimo di crediti per lo studente
	 * @param corsi
	 * @return ok
	 */
	public boolean verificaConseguimento(Corso[] corsi){
		boolean ok = false;
		// se this.minCfu  <= del totale dei cfu all'interno di corsi[] allora ok = true
		int totCrediti = 0;
		for(int i = 0; i < corsi.length; i++)
			totCrediti = totCrediti + corsi[i].getCfu();
		
		if (totCrediti >= this.curriculum.getMinCfu())
			ok = true;
		
		return ok;
	}
	
	/**
	 * Il metodo salva su file le impostazioni selezionate dallo studente
	 */
	public void salva() {
		int i = 0;
		if(this.controlloConsistenza())
				i = 0;
		// serializzazione e scrittura su file 
		
	}

	/**
	 * Il metodo controlloConsistenza effettua un controllo affinch� tutte le condizioni sia verificate prima di effettuare un salvataggio
	 */
	boolean controlloConsistenza() {
		// da implementare
		return true;
		
	}
}
