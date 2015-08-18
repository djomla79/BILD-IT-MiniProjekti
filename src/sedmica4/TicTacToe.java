package sedmica4;

import java.util.Scanner;

public class TicTacToe {
	
	/*
	 (Game: play a tic-tac-toe game)
	 In a game of tic-tac-toe, two players take turns marking an available
	 cell in a 3 * 3 grid with their respective tokens (either X or O).
	 When one player has placed three tokens in a horizontal, vertical, or
	 diagonal row on the grid, the game is over and that player has won.
	 A draw (no winner) occurs when all the cells on the grid have been filled with tokens
	 and neither player has achieved a win. Create a program for playing tic-tac-toe.
	 The program prompts two players to enter an X token and O token alternately.
	 Whenever a token is entered, the program redisplays the board on the
	 console and determines the status of the game (win, draw, or continue).
	 */
	
	public static int brojac = 0;
	private static Scanner input;
	
	/** Main metoda */
	public static void main(String[] args) {
		
		/* Pozivanje metode
		 * za biranje i start igre */
		biranjeIgre();
		
	}
	/** Metoda kojom igrac bira igru
	 * da li igra sa 'X' ili sa 'O' */
	public static void biranjeIgre() {
		
		System.out.print("Izaberi igru sa 'X' ili sa 'O': ");
		
		input = new Scanner(System.in);
		char ch = input.next().charAt(0);
		
		/* Kreiranje objekta Player sa parametrom ch */
		Player one = new Player(ch);   
		char temp = 0;
		/* ako objekat vrijednosti char odgovara
		 * uslovu, karakter temp postaje 'X' */
		if(one.letter == 'O') {
			temp = 'X';
		} else if(one.letter == 'X') {
			temp = 'O';
		} else {
			System.out.println("Pogresan unos!\n");
			biranjeIgre();
		}
		/* Kreiranje objekta Player
		 * sa parametrom char temp */
		Player two = new Player(temp);
		System.out.println("Igrac 1, ti si: '" + one.letter + "'");
		System.out.println("Igrac 2, ti si: '" + two.letter + "'");
		
		/* Ako objekat vrijednosti char odgovara uslovu
		 * poziva se metoda za start igre sa igracem 'X' ili 'O' */
		if(one.letter == 'X') {
			System.out.println();
			startIgreX();
		}
		if(one.letter == 'O') {
			System.out.println();
			startIgreO();
		} 
		
	}
	/** Metoda koja pokrece igru sa 'X' */
	public static void startIgreX() {
		
		int[][] tacke = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		char[][] tabela = new char[3][3];
		boolean isOn = true;
			
		do {
			/* Pozivanje metode igraca 'X' */
			igracX(tacke, tabela);
			
			/* Ako je uslov ispunjen, igrac 'X' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'X' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* Pozivanje metode igraca 'O' */
			igracO(tacke, tabela);
			
			/* Ako je uslov ispunjen, igrac 'O' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'O' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* ako je ukupan broj poteza 9, igra nema pobjednika */
			if(brojac == 9) {
				System.out.println("Nerijeseno!");
				isOn = false;
				System.exit(1);
			}
			
		} while(isOn);                // petlja radi dok se uslov ne ispuni
	}
	/** Metoda koja pokrece igru sa 'O' */
	public static void startIgreO() {
		
		int[][] tacke = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		char[][] tabela = new char[3][3];
		boolean isOn = true;
			
		do {
			/* Pozivanje metode igraca 'O' */
			igracO(tacke, tabela);
			
			/* Ako je uslov ispunjen, igrac 'O' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'O' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* Pozivanje metode igraca 'X' */
			igracX(tacke, tabela);
			
			/* Ako je uslov ispunjen, igrac 'X' je pobjednik */
			if(pobjeda(tabela)) {
				System.out.println("Igrac 'X' je pobjednik!");
				isOn = false;
				System.exit(1);
			}
			/* ako je ukupan broj poteza 9, igra nema pobjednika */
			if(brojac == 9) {
				System.out.println("Nerijeseno!");
				isOn = false;
				System.exit(1);
			}
			
		} while(isOn);                // petlja radi dok se uslov ne ispuni
	}

	/** Metoda igraca 'X' */
	public static void igracX(int[][] tacke, char[][] tabela) {
		
		input = new Scanner(System.in);
		
		System.out.print("Igrac 'X', unos broja reda (0, 1, or 2): ");
		int red = input.nextInt();    // unos reda matrice
		
		System.out.print("Igrac 'X', unos broja kolone (0, 1, or 2): ");
		int kolona = input.nextInt(); // unos kolone matrice
		brojac++;                     // brojac poteza
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				/* Ako je unos isti sa pozicijom tacaka u matrici */
				if(tacke[red][kolona] == tacke[i][j]) {
					/* petlja se 'vrti' dok se unos vrsi u vec unoseni red i kolonu */
					while(tabela[red][kolona] == 'X' || tabela[red][kolona] == 'O') {
						
						System.out.println("Polje je zauzeto. Pokusajte ponovo.");
						System.out.print("Igrac 'X', unos broja reda (0, 1, or 2): ");
						red = input.nextInt();
						
						System.out.print("Igrac 'X', unos broja kolone (0, 1, or 2): ");
						kolona = input.nextInt();
					}
					/* i ako pozicija u matrici nije zauzeta
					 * vrsi se unos znaka X na tu poziciju */
					if(tabela[i][j] != 'X' && tabela[i][j] != 'O') {
						tabela[i][j] = 'X';
					}
				}
			}
		}
		okvir(tabela);                // pozivanje metode za ispis tabele
	}
	/** Metoda igraca 'O' */
	public static void igracO(int[][] tacke, char[][] tabela) {
		
		input = new Scanner(System.in);
		
		System.out.print("Igrac 'O', unos broja reda (0, 1, or 2): ");
		int red = input.nextInt();    // unos reda matrice
		
		System.out.print("Igrac 'O', unos broja kolone (0, 1, or 2): ");
		int kolona = input.nextInt(); // unos kolone matrice
		brojac++;                     // brojac poteza
		
		for(int i=0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				/* Ako je unos isti sa pozicijom tacaka u matrici */
				if(tacke[red][kolona] == tacke[i][j]) {
					/* petlja se 'vrti' dok se unos vrsi u vec unoseni red i kolonu */
					while(tabela[red][kolona] == 'X' || tabela[red][kolona] == 'O') {
						
						System.out.println("Polje je zauzeto. Pokusajte ponovo.");
						System.out.print("Igrac 'O', unos broja reda (0, 1, or 2): ");
						red = input.nextInt();
						
						System.out.print("Igrac 'O', unos broja kolone (0, 1, or 2): ");
						kolona = input.nextInt();
					}
					/* i ako pozicija u matrici nije zauzeta
					 * vrsi se unos znaka O na tu poziciju */
					if(tabela[i][j] != 'X' && tabela[i][j] != 'O') {
						tabela[i][j] = 'O';
					}
				}
			}
		}
		okvir(tabela);                // pozivanje metoda za ispis tabele
	}
	/** Metoda koja provjerava da li je igrac pobjednik ili ne */
	public static boolean pobjeda(char[][] tabela) {
		
		boolean pobjeda = false;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				/* Provjera svih kombinacija za pobjedu, redovi, kolone, dijagonale igrac x */
				if(tabela[i][0] == 'X' && tabela[i][1] == 'X' && tabela[i][2] == 'X' || 
				   tabela[0][i] == 'X' && tabela[1][i] == 'X' && tabela[2][i] == 'X' ||
				   tabela[0][0] == 'X' && tabela[1][1] == 'X' && tabela[2][2] == 'X' ||
				   tabela[0][2] == 'X' && tabela[1][1] == 'X' && tabela[2][0] == 'X') {
				   pobjeda = true;
				   /* Provjera svih kombinacija za pobjedu, redovi, kolone, dijagonale igrac o */
				} else if(tabela[i][0] == 'O' && tabela[i][1] == 'O' && tabela[i][2] == 'O' ||
						  tabela[0][i] == 'O' && tabela[1][i] == 'O' && tabela[2][i] == 'O' ||
						  tabela[0][0] == 'O' && tabela[1][1] == 'O' && tabela[2][2] == 'O' ||
						  tabela[0][2] == 'O' && tabela[1][1] == 'O' && tabela[2][0] == 'O') {
					pobjeda = true;
				} else {
					pobjeda = false;
				}
			}
		}
		/* vraca true ili false, ako je igrac pobijedio ili ne */
		return pobjeda;
	}	
	/** Metoda za ispis okvira tabele */
	public static void okvir(char[][] tabela) {
		
		for(int i=0; i<3; i++) {
			System.out.println(" -------------");
			for(int j=0; j<3; j++) {
				System.out.print(" | ");
				System.out.print(tabela[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println(" -------------");
		System.out.println();
		
	}
	/** Klasa Player */
	static class Player {
		
		public char letter;
		/** Konstruktor Player sa parametrom char */
		Player(char c) {
			/* Ako parametar char odgovara uslovu,
			 * karakter je X ili O, a ako ne karakter je 0 */
			if(Character.toUpperCase(c) == 'X') {
				this.letter = 'X';
			} else if(Character.toUpperCase(c) == 'O') {
				this.letter = 'O';
			} else {
				this.letter = 0;
			}
		}
	}
}