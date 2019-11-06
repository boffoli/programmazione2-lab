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
public class pianoDiStudio {
	private final int matricola;
	private Corso[] corsiAsceltaSelezionati;
	private final Curriculum curriculum;
	
	/**
	 * Costruttore
	 * @param matricola
	 * @param curriculum
	 */
	public pianoDiStudio(int matricola, Curriculum curriculum){
		this.matricola = matricola;
		this.curriculum = curriculum;
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
		// aggiunge corso all'attributi corsiAscelta
		//ma primanecessario effettuare un controllo
		//il corso passato presente tra curr.ascelta e non presente in corsiAscletelezionati
		//Nessuna sovrapposizione di orari
		boolean nonSopvrapposto = this.corsoSovrapposto(corso);
		//presenza posti disppnibili
		boolean disponibile = corso.isDisponibile();
		
		
		//POST CONDIZIONE 
		/* 1. */
		corso.assegnaPosto(); // invocazione fuori astrazione, valutare i contenitori 
		// 2. aggiungere corso a corsiAsceltaSelezionati
		
	}
	
	/**
	 * Il metodo corsoSovrapposto utilizza un altro metodo presente nella classe Corso, verificaConflitto() per verificare se il corso 
	 * a scelta che si vuole aggiungere alla propria lista dei corsi non abbia orari che vadano a sovrapporsi a orari di un altro corso
	 * gia selezionato in passato.
	 * @param corso
	 * @return nonSovrapposto
	 */
	
	private boolean corsoSovrapposto(Corso corso) {
		int i = 0;
		boolean nonSovrapposto = true;
		while(nonSovrapposto && i < corsiAsceltaSelezionati.length){
				if(corsiAsceltaSelezionati[i].verificaConflitto(corso)){
				nonSovrapposto = false;
				i++;
			}
		}
		return nonSovrapposto;
	}

	/**
	 * Il metodo removeCorsoAScelta viene utilizzato per rimuove un corso a scelta precedentemente aggiunto
	 * @param corso
	 */
	public void removeCorsoAScelta(Corso corso){
		// rimuove corso all'attributi corsiAscelta
		
	}
	
	/**
	 * Il metodo getCorsiAScelraSelezionabili viene utilizzato per mostrare i corsi a scelta ancora selezionabili dall'utente
	 * @return curriculum.getCorsiAScelta()
	 */

	public Corso[] getCorsiASceltaSelezionabili() {
		//
		return this.curriculum.getCorsiAScelta();
	}
	
	
	/**
	 * Il metodo salva utilizza query di salvataggio o scrittura su file per salvare le impostazioni selezionate dallo studente
	 */
	public void salva() {
		this.controlloConsistenza();
		
		// query di salvataggio o scrittura su file 
		
	}

	/**
	 * Il metodo controlloConsistenza effettua un controllo affinch� tutte le condizioni sia verificate prima di effettuare un salvataggio
	 */
	private void controlloConsistenza() {
		// TODO Auto-generated method stub
		
	}
}
