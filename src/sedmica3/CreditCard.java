package sedmica3;

import java.util.Scanner;

public class CreditCard {

	private static Scanner input;
	
	public static void main(String[] args) {
		/*
		 Financial: credit card number validation
		 Write a program that prompts the user
		 to enter a credit card number as a long integer.
		 Display whether the number is valid or invalid.
		 For example, the number 4388576018402626 is invalid,
		 but the number 4388576018410707 is valid.
		 
		 1. Double every second digit from right to left. If doubling of a digit results in a
		 two-digit number, add up the two digits to get a single-digit number.
		 
		 2 * 2 = 4, 2 * 2 = 4, 4 * 2 = 8, 1 * 2 = 2, 6 * 2 = 12 (1 + 2 = 3), 5 * 2 = 10 (1 + 0 = 1),
		 8 * 2 = 16 (1 + 6 = 7), 4 * 2 = 8
		 
		 2. Now add all single-digit numbers from Step 1.
		 4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37
		 
		 3. Add all digits in the odd places from right to left in the card number.
		 6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38
		 
		 4. Sum the results from Step 2 and Step 3.
		 37 + 38 = 75
		 
		 5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise,
		 it is invalid. 
		 */
		input = new Scanner(System.in);
		
		int[] prefix = { 4, 5, 6, 37 };
		
		String[] banke = { "Visa", "Master Card", "Discover", "American Expres" };
		
		System.out.print("Unesite vas broj Kreditne kartice: ");
		
		long broj = input.nextLong();                  // unos broja kartice
		
		if (isValid(broj)) {                           // pozivanje metode za provjeru validnosti unesenog broja, ako je validan
			for (int i = 0; i < prefix.length; i++) {
				if (prefixMatched(broj, prefix[i])) {  // ako prefix kartice odgovara prefixu banke
					System.out.println("Kartica je iz banke: " + banke[i]); // ispis banke u konzolu
				}
			}
		}
		
	}
	/** Metoda koja provjerava validnost unesenog broja */
	public static boolean isValid(long number) {
		
		if(totalSum(number) % 10 == 0) {                          // ako je ukupna suma djeljiva sa 10
			System.out.println("Broj vase kartice je validan.");  // ispis u konzolu
			return true;                                          // vraca true
		} else {                                                  // ako nije
			System.out.println("Broj vase kartice nije validan.");// ispis u konzolu
			return false;                                         // vraca false
		}
		
	}
	/** Metoda koja vraca ukupnu sumu za uneseni broj po formuli */
	public static int totalSum(long number) {
		
		int total = sumOfOddPlace(number) + sumOfDoubleEvenPlace(number);
		
		return total;               // vraca ukupnu sumu svih parnih i neparnih brojeva po formuli
		
	}
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		
		String broj = number + "";
		int num = 0;
		int suma = 0;
		
		for(int i=broj.length()-2; i>=0; i=i-2) {           // za svaki parni broj od pozadi iz stringa
			num = Character.getNumericValue(broj.charAt(i));// broj num postaje taj broj
			suma += getDigit(2*num);                        // i sve dobijene brojeve sabiramo, pozivamo metodu getDigit za svaki broj
		}
		return suma;                                        // vracanje ukupne sume svih brojeva
	}
	/** Return this number if it is a single digit, otherwise,
	* return the sum of the two digits */
	public static int getDigit(int number) {
		
		String n = number + "";
		int suma = 0;
		
		if(n.length() == 1) {         // ako je duzina unesenog broja jednaka 1
			return number;            // vraca se taj broj
		} else {                      // ako je veca od 1
			suma = sumDigits(number); // sabiramo te brojeve pozivajuci metodu sumDigits
			return suma;              // vracanje ukupne sume tog broja
		}
		
	}
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		
		String broj = number + "";
		int num = 0;
		int suma = 0;
		
		for(int i=broj.length()-1; i>=0; i=i-2) {            // za svaki neparni broj odpozadi iz stringa
			num = Character.getNumericValue(broj.charAt(i)); // broj num postaje taj broj i
			suma += getDigit(num);                           // sabiramo sve dobijene brojeve, pozivajuci metodu sumDigits
		}
		return suma;                                         // vracanje ukupne sume svih brojeva
		
	}
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		
		String broj = number + "";
		String prefix = d + "";

		if (prefix.equals(broj.substring(0, prefix.length()))) { // ako je prefix broja isti prefixu unesenog broja
			return true;                                         // vraca true
		} else {                                                 // ako nije
			return false;                                        // vraca false
		}
		
	}
	/** Return the number of digits in d */
	public static int getSize(long d) {
		
		String niz = (int)d + "";  // za uneseni broj
		int duzina = niz.length(); // odredjujemo duzinu tog broj
		
		return duzina;             // vraca duzinu unesenog broja
		
	}
	/** Return the first k number of digits from number. If the
	* number of digits in number is less than k, return number. 
	* nisam koristio ovu metodu u zadatku */
	public static long getPrefix(long number, int k) {
		
		k = getSize(number);
		String broj = number + "";
		
		if(broj.length() < k) {
			return number;
		}
		
		String niz = broj.substring(0, k);
		long num = Long.parseLong(niz);
		
		return num;
		
	}
	/** Return sum of the digits in the number */
	public static int sumDigits(int broj) {
	       
		int suma = 0;
		
		while (broj != 0) {          // dok broj ne dodje do 0, petlja se 'vrti'
			int ostatak = broj % 10; // ostatak postaje zadnja cifra broja
			suma += ostatak;         // povecavamo sumu za zadnju cifru broja 
			broj = broj / 10;        // dobijamo novi broj, manji za jednu cifru
	}
		return suma;                 // vraca ukupnu suma svih cifara u broju
    }
	
}
