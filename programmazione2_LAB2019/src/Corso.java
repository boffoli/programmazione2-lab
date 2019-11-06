/**
 * <p>Title: Corso</p>
 * <p>Description: classe dedicata a un corso presente in un Curriculum che uno studente potr� seguire </p>
 * <p>Company: Dipartimento di Informatica, Universit� degli studi di Bari</p>
 * <p>Class description: Corso </p>
 * Corso per gli studenti di Programmazione 2
 * @author Eleonora Totaro
 * @version 1.0
 */


//applicare ereditariet�  a causa degli elementi specifici di corsoAscelta
public class Corso implements Comparable{
	private String nome;
	private boolean aScelta; 
	private Cfu cfu;
	private int livello;
	private int semestre; // valori ammessi 1 o 2
	private final int postiMax;
	private int postiDisponibili;
	
	
	private Orario[] orari;
	
	
	/**
	 * Costruttore
	 * @param nome
	 * @param aScelta
	 * @param cfu
	 * @param livello
	 * @param postiMax
	 * @param orari
	 * @param semestre
	 */
	public Corso (String nome, boolean aScelta,int cfu, int livello, int postiMax, Orario[] orari, int semestre) {
		this.nome = nome;
		this.cfu = new Cfu(cfu);
		this.livello = livello;
		this.aScelta = aScelta;
		this.postiMax = postiMax;
		this.postiDisponibili = postiMax;
		this.orari = orari;
		this.semestre = semestre;// fare controllo 
	}
	
	/**
	 * Questo metodo serve per indicare se il corso preso in questione sia facoltativo o obbligatorio
	 * @return aScelta
	 */
	boolean isAscelta(){
		return aScelta;
	}


	/**
	 * Questo metodo serve per verificare la disponibilit� di posti liberi all'interno di un corso
	 * @return disponibile
	 */
	public boolean isDisponibile() {
		boolean disponibile;
		if(this.postiDisponibili>0){
			disponibile = true;
		}else{
			disponibile = false;
		}
		return disponibile;
		
	}
	
	/**
	 * Questo metodo viene invocato in aiuto a un altro metodo presente nella classe piano di studi 
	 * chiamato corsoSovrapposto per verificare se quando lo studente aggiunge un nuovo corso al
	 * suo piano di studio, gli orari di quest'ultimo non si sovrappongano con gli orari di un altro
	 * corso gi� inserito all'interno del proprio piano di studi
	 * 
	 * @param corso
	 * @return conflitto
	 */

	public boolean verificaConflitto(Corso corso) {
		boolean conflitto = false;
		if (this.semestre == corso.semestre){
			int i = 0;
			int j = 0;
			
			while(!conflitto && i < this.orari.length){
				while(!conflitto && j< corso.orari.length){	
					if(this.orari[i].verificaConflitto(corso.orari[j])){
						conflitto = true;
						j++;
					}
					i++;
					j = 0;
				}
			}
		}
		
		
		
		return conflitto;
	}
	
	/**
	 * Il metodo assegnaPosto serve a diminuire i posti disponibili all'interno di un corso
	 *  una volta che lo studente lo prende come
	 * corso da inserire nel proprio piano di studi 
	 * @return ok
	 */

	public boolean assegnaPosto() {
		boolean ok = true;
		if(this.postiDisponibili > 0 ){
			this.postiDisponibili--;
		}else {
			ok = false;
		}
		return ok;
	}

	@Override
	public int compareTo(Object o) {
			return this.nome.compareTo(((Corso)o).nome);
	}
	
	public boolean equals(Object o) {
		return this.nome.equals(((Corso)o).nome);
	}
	
	public int hashCode() {
		return this.nome.hashCode();
	}
}


	
