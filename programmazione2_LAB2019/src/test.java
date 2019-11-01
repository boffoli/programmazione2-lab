/**
 * <p>Title: Test</p>
 * <p>Description: classe in cui è presente il main del programma</p>
 * <p>Company: Dipartimento di Informatica, Università degli studi di Bari</p>
 * <p>Class description: test </p>
 * Test per gli studenti di Programmazione 2
 * @author Eleonora Totaro
 * @version 1.0
 */
public class test {

	public static void main(String[] args) {
		
		Corso c1 = new Corso("Programmazione2", true, 9, 2, 0, null, 0);
		Corso c2 = new Corso("Mobile", true, 6, 3, 0, null, 0);
		Corso c3 = new Corso("Analisi", true, 9, 1, 0, null, 0);
		Corso[] corsi = new Corso[3];
		corsi[0] = c1;
		corsi[1] = c2;
		corsi[2] = c3;
		Curriculum curr = new Curriculum ("ITPS", 70 ,corsi);
		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//piano di studi e aggiunta di un corso a scelta
		//......
		
		pianoDiStudio ps = new pianoDiStudio(0001, curr);
		//................................
		Corso[] corsiAscelta = ps.getCorsiASceltaSelezionabili();
		Corso c = new Corso("Programmazione2", true, 9, 2, 0, null, 0); //corso a scelta
		
		//................................
	    ps.addCorsoAScelta(c);
		
	    // salvataggio su db/file del piano di studi 
	    ps.salva();
	}

}
