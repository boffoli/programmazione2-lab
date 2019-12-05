/**
 * <p>Title: Cfu</p>
 * <p>Description: classe dedicata ai CFU di un corso utile per verificare se i crediti inseriti dal gestore 
 *    			   del programma, rientrano all'interno del range di valori ammissibili   </p>
 * <p>Company: Dipartimento di Informatica, Universita degli studi di Bari</p>
 * <p>Class description: Cfu </p>
 * Cfu per gli studenti di Programmazione 2
 * @author Eleonora Totaro
 * @version 1.0
 */
public class Cfu {
	private int value;
	private final static int MIN_CREDITI = 6;
	private final static int MAX_CREDITI = 12;
	
	/**
	 * Costruttore
	 * @param crediti
	 */
	public Cfu (int crediti) {
		if ((crediti >= MIN_CREDITI) && (crediti <= MAX_CREDITI)){
			value = crediti;
		} else {
			System.out.println ("Valore crediti fuori intervallo (" + MIN_CREDITI + "-" + MAX_CREDITI +")");
		}
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
}


