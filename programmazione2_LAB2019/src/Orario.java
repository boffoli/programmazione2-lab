/**
 * <p>Title: Orario</p>
 * <p>Description: classe dedicata alla gestione degli orari di un corso contenete l'ora inizio di un corso, l'ora di fine e il girno della settimana</p>
 * <p>Company: Dipartimento di Informatica, Universit� degli studi di Bari</p>
 * <p>Class description: Orario </p>
 * Orari per gli studenti di Programmazione 2
 * @author Eleonora Totaro
 * @version 1.0
 */
public class Orario {
	private String oraInizio;
	private String oraFine;
	private String giornoSettimana;
	
	/**
	 * Costruttore
	 * @param oraInizio
	 * @param oraFine
	 * @param giornoSettimana
	 */
	public Orario (String oraInizio, String oraFine, String giornoSettimana){
		if(controlloOra(oraInizio) && controlloOra(oraFine) && controlloGiorno(giornoSettimana)){
			this.oraInizio = oraInizio;
			this.oraFine = oraFine;
			this.giornoSettimana = giornoSettimana;
			}
		else System.out.println("orario o giorno in formato errato");
		}

	/**
	 * Il metodo controlloGiorno viene utilizzare per effettuare controlli sul giorno della settimana durante l'assegnazione del giorno
	 * all'interno del costruttore
	 * @param giornoSettimana2
	 * @return
	 */
	private boolean controlloGiorno(String giornoSettimana2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/**
	 * Il metodo controlloOra viene utilizzato per effettuare controlli sull'ora durante la sua assegnazione all'interno del costruttore
	 * @param oraInizio2
	 * @return
	 */
	private boolean controlloOra(String oraInizio2) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Il metodo verificaConflitto viene utilizzato per effettuare la verifica tra gli orari dei corsi presenti nel piano di studi di uno studente
	 * al momento dell'aggiunta di un nuovo corso. Viene verificato se l'orario di inizio di un corso non sia precedente all'orario di fine di un
	 * altro corso gi� presente in quel giorno o se l'ora di fine di un corso non sia successiva all'ora di inizio di un corso gi� presente per quel giorno
	 * @param orario
	 * @return conflitto
	 */
	public boolean verificaConflitto(Orario orario) {
		// interi per THIS ora inizio
		String[] soi1 = this.oraInizio.split(":");
		int oi1 = Integer.parseInt(soi1[0]);
		int mi1 = Integer.parseInt(soi1[1]);
		
		// interi per THIS ora fine
		String[] sof1 = this.oraFine.split(":");
		int of1 = Integer.parseInt(soi1[0]);
		int mf1 = Integer.parseInt(soi1[1]);
		
		// interi per PRM ora inizio
		String[] soi2 = orario.oraInizio.split(":");
		int oi2 = Integer.parseInt(soi2[0]);
		int mi2 = Integer.parseInt(soi2[1]);
		
		// interi per PRM ora fine
		String[] sof2 = orario.oraFine.split(":");
		int of2 = Integer.parseInt(soi2[0]);
		int mf2 = Integer.parseInt(soi2[1]);
		 
		// valuto conflitto
		boolean conflitto = false;
		if (this.giornoSettimana.equals(orario.giornoSettimana)){
			if(of1 > oi2 || of2 > oi1){ 
				conflitto = true;
			}
		return conflitto;
	
		}
		


		return true;
	}
		
	}
	
	
