package sedmica3;

public class Craps {

	public static void main(String[] args) {
		/*
		 (Game: craps) Craps is a popular dice game played in casinos. Write a program
		 to play a variation of the game, as follows:
		 Roll two dice. Each die has six faces representing values 1, 2, …, and 6, respectively.
		 Check the sum of the two dice. If the sum is 2, 3, or 12 (called craps), you lose;
		 if the sum is 7 or 11 (called natural), you win;
		 if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is established.
		 Continue to roll the dice until either a 7 or the same point value is rolled.
		 If 7 is rolled, you lose. Otherwise, you win.
		 */
		
		int dice1 = (int)(Math.random()*6+1);
		int dice2 = (int)(Math.random()*6+1);
		
		int suma;
		                                             // ispis bacanja i sume bacanja
		System.out.println("Vase bacanje: " + dice1 + " i " + dice2 + " = " + (suma = bacanje(dice1, dice2)));
		
		if(suma == 2 || suma == 3 || suma == 12) {   // ako je suma jedan od ovih brojeva
			System.out.println("Zao nam je, izgubili ste!"); // igra je gotova, poraz
		}
		if(suma == 7 || suma == 11) {                // ako je suma jedan od ovih brojeva
			System.out.println("Cestitamo, pobijedili ste!");// igra je gotova, pobjeda
		}
		
		rezultat(suma);                              // pozivanje metode
		
	}
	/** Metoda koja prima argument, sumu bacanja i vraca pobjednika */
	public static int rezultat(int suma) {
		
		if(suma == 4) {                             // ako je suma ovaj broj
			System.out.println("Rezultat za pobjedu: " + suma); // ispis potrebnog rezultata za pobjedu
			igra(suma);                             // pozivanje metode koja vraca pobjednika za unesenu sumu
		}
		if(suma == 5) {                             // itd. za svaki uslov
			System.out.println("Rezultat za pobjedu: " + suma);
			igra(suma);
		}
		if(suma == 6) {
			System.out.println("Rezultat za pobjedu: " + suma);
			igra(suma);
		}
		if(suma == 8) {
			System.out.println("Rezultat za pobjedu: " + suma);
			igra(suma);
		}
		if(suma == 9) {
			System.out.println("Rezultat za pobjedu: " + suma);
			igra(suma);
		}
		if(suma == 10) {
			System.out.println("Rezultat za pobjedu: " + suma);
			igra(suma);
		}
		return suma;
	}
	/** Metoda koja prima ukupnu sumu bacanja i vraca boolean vrijednost */
	public static boolean igra(int suma) {
		
		int igra;
		boolean isOn = true;
		
		while(isOn) {            // dok se uslov ne ispuni petlja se 'vrti'
			
			int dice1 = (int)(Math.random()*6+1);
			int dice2 = (int)(Math.random()*6+1);
			                     // ispis ponovnog bacanja i ukupne sume bacanja
			System.out.println("Vase bacanje: " + dice1 + " i " + dice2 + " = " + (igra = bacanje(dice1, dice2)));
			
			if(igra == suma) {   // ako je ponovo dobijena suma bacanja ista sa ukupnom sumom, primljenim argumentom
				System.out.println("Cestitamo, pobijedili ste!"); // ispis pobjede
				isOn = false;                                     // prekid rada petlje
			}
			if(igra == 7) {      // ako je ponovo dobijena suma ista sa brojem iz uslova
				System.out.println("Zao nam je, izgubili ste!");  // ispis poraza
				isOn = false;                                     // prekid rada petlje
			}
		}
		return isOn;             // vracanje boolean vrijednosti, pobjeda ili poraz
	}
	/** Metoda koja prima dva argumenta, integera i vraca njihovu sumu */
	public static int bacanje(int dice1, int dice2) {
		
		int suma = dice1 + dice2; // suma dva unesena integera
		
		return suma;              // vracanje sume
	}
}
