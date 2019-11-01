
public class pianoDiStuidi {
	private final int matricola;
	private Corso[] corsiAsceltaSelezionati;
	private final Curriculum curriculum;
	
	public pianoDiStuidi(int matricola, Curriculum curriculum){
		this.matricola = matricola;
		this.curriculum = curriculum;
	}
	
	public void addCorsoAScelta(Corso corso){
		// aggiunge corso all'attributi corsiAscelta
		//ma prima è necessario effettuare un controllo
		//il corso passato è presente tra curr.ascelta e non è presente in vorsiAscletelezionati
		//Nessuna sovrapposizione di orari
		boolean nonSopvrapposto = this.corsoSovrapposto(corso);
		//presenza posti disppnibili
		boolean disponibile = corso.isDisponibile();
		
		
		//POST CONDIZIONE 
		/* 1. */
		corso.assegnaPosto(); // invocazione fuori astrazione, valutare i contenitori 
		// 2. aggiungere corso a corsiAsceltaSelezionati
		
	}
	
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

	public void removeCorsoAScelta(Corso corso){
		// rimuove corso all'attributi corsiAscelta
		
	}

	public Corso[] getCorsiASceltaSelezionabili() {
		//
		return this.curriculum.getCorsiAScelta();
	}
	
	//persistenza del piano di studi
	public void salva() {
		this.controlloConsistenza();
		
		// query di salvataggio o scrittura su file 
		
	}

	private void controlloConsistenza() {
		// TODO Auto-generated method stub
		
	}
}
