package sedmica4;

import java.util.Scanner;

public class ConnectFour {

	private static int brojac;
	private static Scanner input;
	
	public static void main(String[] args) {
		/*
		 Connect four is a two-player board game in which the players alternately
		 drop colored disks into a seven-column, six-row vertically suspended grid.
		 The objective of the game is to connect four same-colored disks in a row, a
		 column, or a diagonal before your opponent can do likewise.
		 The program prompts two players to drop a red or yellow disk alternately.
		 In the preceding figure, the red disk is shown in a dark color and the yellow in a light color.
		 Whenever a disk is dropped, the program redisplays the board on the console and determines the 
		 status of the game (win, draw, or continue).
		 */
		
		System.out.println("//// Connect Four ////\n");
		/* Pozivanje metode
		 * za biranje i start igre */
		biranjeIgre();
		
	}
	/** Metoda kojom igrac bira igru
	 * da li igra sa 'R' ili sa 'Y' */
	public static void biranjeIgre() {
		
		System.out.println("---Izaberite igru---");
		System.out.print("Unesite 'R' ili 'Y': ");
		
		input = new Scanner(System.in);
		char i = input.next().charAt(0);
		
		/* Kreiranje objekta Igrac sa parametrom i */
		Igrac prvi = new Igrac(i);   
		char zamjena = 0;
		/* ako objekat vrijednosti char odgovara
		 * uslovu, karakter zamjena postaje 'R' */
		if(prvi.igrac == 'Y') {
			zamjena = 'R';
		} else if(prvi.igrac == 'R') {
			zamjena = 'Y';
		} else {
			System.out.println("Pogresan unos!\n");
			biranjeIgre();
		}
		/* Kreiranje objekta Igrac
		 * sa parametrom char zamjena */
		Igrac drugi = new Igrac(zamjena);
		System.out.println("\nIgrac 1, ti si: '" + prvi.igrac + "'");
		System.out.println("Igrac 2, ti si: '" + drugi.igrac + "'");
		
		/* Ako objekat vrijednosti char odgovara uslovu
		 * poziva se metoda za start igre sa igracem 'R' ili 'Y' */
		if(prvi.igrac == 'R') {
			System.out.println();
			startIgreR();
		}
		if(prvi.igrac == 'Y') {
			System.out.println();
			startIgreY();
		} 
		
	}
	/** Metoda koja pokrece igru sa 'R' */
	public static void startIgreR() {
		
		char[][] tabela = new char[6][7];
		boolean isOn = true;
			
		do {
			/* Pozivanje metode igraca 'R' */
			igracR(tabela);
			
			/* Ako je uslov ispunjen, igrac 'R' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'R' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* Pozivanje metode igraca 'Y' */
			igracY(tabela);
			
			/* Ako je uslov ispunjen, igrac 'Y' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'Y' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* ako je ukupan broj poteza 42, igra nema pobjednika */
			if(brojac == 42) {
				System.out.println("Nerijeseno!");
				isOn = false;
				System.exit(1);
			}
			
		} while(isOn);                        // petlja radi dok se uslov ne ispuni
	}
	/** Metoda koja pokrece igru sa 'Y' */
	public static void startIgreY() {
	
		char[][] tabela = new char[6][7];
		boolean isOn = true;
			
		do {
			/* Pozivanje metode igraca 'Y' */
			igracY(tabela);
			
			/* Ako je uslov ispunjen, igrac 'Y' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'Y' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* Pozivanje metode igraca 'R' */
			igracR(tabela);
			
			/* Ako je uslov ispunjen, igrac 'R' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'R' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* ako je ukupan broj poteza 42, igra nema pobjednika */
			if(brojac == 42) {
				System.out.println("Nerijeseno!");
				isOn = false;
				System.exit(1);
			}
			
		} while(isOn);                        // petlja radi dok se uslov ne ispuni
	}
	/** Metoda igraca 'R' */
	public static void igracR(char[][] tabela) {
		
		input = new Scanner(System.in);
		
		boolean isOn = true;
		
		System.out.print("Igrac 'R', unesite broj kolone (0-6): ");
		int kolona = input.nextInt();         // unos kolone matrice
		brojac++;                             // brojac poteza
		
		while(isOn) {                         // petlja radi dok se uslov ne ispuni
			for(int i=0; i<6; i++) {
				/* Ako u tabeli sa unesenom kolonom nema karaktera 'R' i 'Y'
				 * na tu poziciju unesi karakter 'R', i tako za sve uslove */
				if(tabela[5][kolona] != 'R' && tabela[5][kolona] != 'Y') {
					tabela[5][kolona] = 'R';
					isOn = false;             // uslov je ispunjen, prekid rada petlje, itd za sve uslove
					break;
				}
				if(tabela[4][kolona] != 'R' && tabela[4][kolona] != 'Y') {
					tabela[4][kolona] = 'R';
					isOn = false;
					break;
				}
				if(tabela[3][kolona] != 'R' && tabela[3][kolona] != 'Y') {
					tabela[3][kolona] = 'R';
					isOn = false;
					break;
				}
				if(tabela[2][kolona] != 'R' && tabela[2][kolona] != 'Y') {
					tabela[2][kolona] = 'R';
					isOn = false;
					break;
				}
				if(tabela[1][kolona] != 'R' && tabela[1][kolona] != 'Y') {
					tabela[1][kolona] = 'R';
					isOn = false;
					break;
				}
				if(tabela[0][kolona] != 'R' && tabela[0][kolona] != 'Y') {
					tabela[0][kolona] = 'R';
					isOn = false;
					break;
				}
			}
		}
		okvir(tabela);  		              // pozivanje metode za ispis tabele
	}
	/** Metoda igraca 'Y' */
	public static void igracY(char[][] tabela) {
		
		input = new Scanner(System.in);
		
		boolean isOn = true;
		
		System.out.print("Igrac 'Y', unesite broj kolone (0-6): ");
		int kolona = input.nextInt();         // unos kolone matrice
		brojac++;                             // brojac poteza
		
		while(isOn) {
			for(int i=0; i<6; i++) {
				/* Ako u tabeli sa unesenom kolonom nema karaktera 'R' i 'Y'
				 * na tu poziciju unesi karakter 'Y', i tako za sve uslove */
				if(tabela[5][kolona] != 'R' && tabela[5][kolona] != 'Y') {
					tabela[5][kolona] = 'Y';
					isOn = false;             // uslov je ispunjen, prekid rada petlje, itd za sve uslove
					break;
				}
				if(tabela[4][kolona] != 'R' && tabela[4][kolona] != 'Y') {
					tabela[4][kolona] = 'Y';
					isOn = false;
					break;
				}
				if(tabela[3][kolona] != 'R' && tabela[3][kolona] != 'Y') {
					tabela[3][kolona] = 'Y';
					isOn = false;
					break;
				}
				if(tabela[2][kolona] != 'R' && tabela[2][kolona] != 'Y') {
					tabela[2][kolona] = 'Y';
					isOn = false;
					break;
				}
				if(tabela[1][kolona] != 'R' && tabela[1][kolona] != 'Y') {
					tabela[1][kolona] = 'Y';
					isOn = false;
					break;
				}
				if(tabela[0][kolona] != 'R' && tabela[0][kolona] != 'Y') {
					tabela[0][kolona] = 'Y';
					isOn = false;
					break;
				}
			}
		}
		okvir(tabela);  		              // pozivanje metode za ispis tabele
	}
	/** Metoda koja provjerava da li je igrac pobjednik ili ne */
	public static boolean pobjeda(char[][] tabela) {
		
		boolean pobjeda = false;
		
		/** Provjera za sve pozicije matrice
		 * horizontale, vertikale i dijagonale */
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				 if(tabela[i][j] == 'R' && tabela[i][j+1] == 'R' && tabela[i][j+2] == 'R' && tabela[i][j+3] == 'R' || 
					tabela[i][j] == 'Y' && tabela[i][j+1] == 'Y' && tabela[i][j+2] == 'Y' && tabela[i][j+3] == 'Y') {
					 pobjeda = true;
				}
			}
		}
		for(int j=0; j<7; j++) {
			for(int i=0; i<3; i++) {
				if(tabela[i][j] == 'R' && tabela[i+1][j] == 'R' && tabela[i+2][j] == 'R' && tabela[i+3][j] == 'R' || 
				   tabela[i][j] == 'Y' && tabela[i+1][j] == 'Y' && tabela[i+2][j] == 'Y' && tabela[i+3][j] == 'Y') {
					pobjeda = true;
				}
			}
		}
		for(int i=0; i<4; i++) {
			for (int j=5; j>= 3; j--) {
				if (tabela[j][i] == 'R' && tabela[j-1][i+1] == 'R' && tabela[j-2][i+2] == 'R' && tabela[j-3][i+3] == 'R' ||
					tabela[j][i] == 'Y' && tabela[j-1][i+1] == 'Y' && tabela[j-2][i+2] == 'Y' && tabela[j-3][i+3] == 'Y') {
					pobjeda = true;
				}
			}
		}
		for(int i=5; i>=3; i--) {
			for (int j=5; j>=3; j--) {
				if(tabela[j][i] == 'R' && tabela[j-1][i-1] == 'R' && tabela[j-2][i-2] == 'R' && tabela[j-3][i-3] == 'R' || 
				   tabela[j][i] == 'Y' && tabela[j-1][i-1] == 'Y' && tabela[j-2][i-2] == 'Y' && tabela[j-3][i-3] == 'Y') {
					pobjeda = true;
				}
			}
		}
		return pobjeda;
	}
	/** Metoda za ispis okvira tabele */
	public static void okvir(char[][] tabela) {
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(" | ");
				System.out.print(tabela[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
	/** Klasa Igrac */
	static class Igrac {
		
		public char igrac;
		/** Konstruktor Player sa parametrom char */
		Igrac(char i) {
			/* Ako parametar char odgovara uslovu,
			 * karakter je 'R' ili 'Y', a ako ne karakter je 0 */
			if(Character.toUpperCase(i) == 'R') {
				this.igrac = 'R';
			} else if(Character.toUpperCase(i) == 'Y') {
				this.igrac = 'Y';
			} else {
				this.igrac = 0;
			}
		}
	}
}
