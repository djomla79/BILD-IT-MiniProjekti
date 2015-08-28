package sedmica5;

import java.util.ArrayList;

import java.util.Scanner;

public class Hangman {

	private static Scanner input;

	public static void main(String[] args) {
		/*
		 Write a hangman game that randomly generates a word and
		 prompts the user to guess one letter at a time, as shown in the sample run.
		 Each letter in the word is displayed as an asterisk.
		 When the user makes a correct guess, the actual letter is then displayed.
		 When the user finishes a word, display the number of misses
		 and ask the user whether to continue to play with another word.
		 */
		
		startGame();   // pozivanje metode za pocetak igre
		
	}
	/** Metoda za pocetak igre */
	public static void startGame() {
		
		input = new Scanner(System.in);
		
		String [] rijeci = {"pocetak", "program", "telefon", "svjetlost", "genije", "dobrota", "skromnost", "svemir", "svjesnost",
				            "kreator", "budizam", "pravoslavlje", "islam", "avion", "prijatelj", "klasika", "muzika", "buntovnik",};
		
		ArrayList <Character> slova = new ArrayList<>();
		ArrayList <Character> rec = new ArrayList<>();
		
		int zivoti = 10;
		String pokusaj = null, rijec = "";
		char [] rijec1 = null;
		char slovo;
		/* Ubacivanje nasumicne rijeci iz niza rijeci u string rijec */
		for(int i=0; i<rijeci.length; i++) {
			rijec = rijeci[(int)(Math.random()*rijeci.length)];
		}
		/* Ubacivanje stringa rijec u niz karaktera rijec1,
		 * niz kar. rijec2 punimo kar. '*' i ubacujemo u listu rec */
		for(int j=0; j<rijec.length(); j++) {
			rijec1 = rijec.toCharArray();
			char rijec2[] = new char[rijec1.length];
			rijec2[j] = '*';
			rec.add(rijec2[j]);
		}
		
		System.out.println("Trazena rijec: ");
		
		int duzina = rijec.length();
		/* Ispis rijeci karakterima '*' */
		for(int k=0; k<duzina; k++) {
			System.out.print("*");
		}
		
		int preostalaSlova = duzina;
		
		while(preostalaSlova > 0 && zivoti > 0) {          // petlja radi dok se uslovi ne ispune
			
			System.out.print("\nUnesite slovo ili rijec: ");
			pokusaj = input.next();                        // unos rijeci ili slova
			
			if(pokusaj.length() > 1) {                     // ako unos ima vise od 1 slova
				if(pokusaj.equals(rijec)) {                // i ako unos odgovara rijeci koju pogadjamo
					System.out.println("Pogodak!\nCestitamo, pobijedili ste!"); // ispis pobjede
					System.out.println("Trazena rijec je: " + rijec);           // i trazene rijeci
					break;                                                      // prekid rada petlje
				} else {                                   // a ako unos ne odgovara rijeci koju pogadjamo
					System.out.println("Promasaj! Zao nam je, izgubili ste");   // ispis poraza
					break;                                                      // prekid rada petlje
				}
			} else {                                       // ako je unos samo jedno slovo
			
				slovo = pokusaj.charAt(0);                 // kar. slovo postaje to uneseno slovo

			if((rijec.indexOf(slovo)) < 0) {               // ako uneseno slovo nije u trazenoj rijeci
				                                           // ispis poruke
					System.out.println("\nSlovo " + slovo + " nije u trazenoj rijeci.\nIzgubili ste zivot!");
					zivoti--;                              // brojac zivota se smanjuje za jedan
					System.out.println("Imate jos " + zivoti + " zivot(a)."); // ispis poruke preostalih zivota
				
			} else {                                       // ako uneseno slovo jeste u trazenoj rijeci
				 if(slova.contains(slovo)) {               // i ako je slovo vec unoseno, ispis poruke
					System.out.println("Vec ste pokusali sa ovim slovom!");
				 } else {                                  // a ako slovo nije vec unoseno
					 
					 for(int l=0; l<rijec1.length; l++) {  // za sve karaktere iz unesene rijeci niza kar. rijec1
						 if(rijec1[l] == slovo) {          // ako karakter iz niza rijec1 odgovara unesenom slovu
							 rec.set(l, rijec1[l]);        // u listu rec setujemo taj karakter na toj poziciji
							 slova.add(slovo);             // uneseno slovo ubacujemo u listu slova
							 preostalaSlova--;             // brojac preostalih slova smanjujemo za jedan
						}
					} 
					 for(Character a: rec) {               // za sve karaktere iz liste rec
							System.out.print(a);           // ispis svih u konzolu
					 } 
				System.out.println("\nPogodak!");
				}
			}
			}
			
		}
		/* Ako brojac zivota dodje do 0, ispis poraza */
		if(zivoti == 0) {
			System.out.println("\nZao nam je, izgubili ste");
		}
		/* Ako brojac preostalih slova u rijeci dodje do 0, ispis pobjede */
		if(preostalaSlova == 0) {
			System.out.println("\nCestitamo, pobijedili ste!");
			System.out.println("Trazena rijec je: " + rijec);
		}
		/* Poruka za igraca, da li zeli da nastavi sa igrom ili da izadje iz programa */
		System.out.print("\nDa li zelite da pogadjate jos jednu rijec? \nUnesite (da - ne): ");
		String daNe = input.next().toUpperCase();
		if(daNe.matches("DA")) {
			System.out.println();
			startGame();
		} else {
			System.out.println("Igra je zavrsena!");
			System.exit(1);
		}
	}
}
