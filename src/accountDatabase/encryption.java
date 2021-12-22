package accountDatabase;

public class encryption {
	int shift = 7;
	int secondShift = 15;
	boolean sub = false;
	/*
	 * This method will take the inputted string and run it through the created encryption model
	 */
	public String encrypt(String a) {
		sub = false;
		String encrypted = "";
		for (int i = 0; i < a.length(); i++) {
			if (i%2 == 0) {
				encrypted += letterToNumber(a.charAt(i), shift);
			}
			else {
				encrypted += letterToNumber(a.charAt(i), secondShift);
			}
		}
		return encrypted;
	}
	/*
	 * This method will take the given string and decrypt it based on the encryption model
	 */
	public String decrypt(String a) {
		sub = true;
		String decrypted = "";
		for (int i = 0; i < a.length(); i++) {
			if (i%2 == 0) {
			decrypted += letterToNumber(a.charAt(i), shift);
			}
			else {
				decrypted += letterToNumber(a.charAt(i), secondShift);
			}
		}
		return decrypted;
	}
	/*
	 * This method is used as part of the encryption and decrpytion model and will assign a number to the given letter based on the given shift.The sub variable is used to keep track if the program should restart from 1 or go to 26. Since the encrpytion model is based on
	 * a shift/caeser cipher the sub variable will let the program know that once the counter gets to 0 or 27 that it instead needs to treat them as 26 or 1 respectively since its rotating through he alphabet.
	 */
	private String numberToLetter(int a, int shift) {
		if (sub) {
			for (int i = 0; i < shift; i++) {
				a++;
				if (a == 27) {
					a = 1;
				}
			}
		}
		else {
			for (int i = 0; i < shift; i++) {
				a--;
				if (a == 0) {
					a = 26;
				}
			}
		}
		switch (a) {
		case 1: return "a";
		case 2: return "b";
		case 3: return "c";
		case 4: return "d";
		case 5: return "e";
		case 6: return "f";
		case 7: return "g";
		case 8: return "h";
		case 9: return "i";
		case 10: return "j";
		case 11: return "k";
		case 12: return "l";
		case 13: return "m";
		case 14: return "n";
		case 15: return "o";
		case 16: return "p";
		case 17: return "q";
		case 18: return "r";
		case 19: return "s";
		case 20: return "t";
		case 21: return "u";
		case 22: return "v";
		case 23: return "w";
		case 24: return "x";
		case 25: return "y";
		case 26: return "z";
		}
		return null;
	}
	/*
	 * This method will take the given letter and turn it into a number to prepare to be shifted
	 */
	private String letterToNumber(char a, int shift) {
		String b = Character.toString(a);
		b = b.toLowerCase();
		a = b.charAt(0);
		//letter
		switch (a) {
		case 'a': return numberToLetter(1, shift);
		case 'b': return numberToLetter(2, shift);
		case 'c': return numberToLetter(3, shift);
		case 'd': return numberToLetter(4, shift);
		case 'e': return numberToLetter(5, shift);
		case 'f': return numberToLetter(6, shift);
		case 'g': return numberToLetter(7, shift);
		case 'h': return numberToLetter(8, shift);
		case 'i': return numberToLetter(9, shift);
		case 'j': return numberToLetter(10, shift);
		case 'k': return numberToLetter(11, shift);
		case 'l': return numberToLetter(12, shift);
		case 'm': return numberToLetter(13, shift);
		case 'n': return numberToLetter(14, shift);
		case 'o': return numberToLetter(15, shift);
		case 'p': return numberToLetter(16, shift);
		case 'q': return numberToLetter(17, shift);
		case 'r': return numberToLetter(18, shift);
		case 's': return numberToLetter(19, shift);
		case 't': return numberToLetter(20, shift);
		case 'u': return numberToLetter(21, shift);
		case 'v': return numberToLetter(22, shift);
		case 'w': return numberToLetter(23, shift);
		case 'x': return numberToLetter(24, shift);
		case 'y': return numberToLetter(25, shift);
		case 'z': return numberToLetter(26, shift);
		}
		return specialCharacter(a);
	}
	/*
	 * This method is used to figure out what each special character maps to
	 */
	private String specialCharacter(char a) {
		switch(a) {
		case '0': return "`";
		case '1': return "â";//ascii 131;
		case '2': return "é";//ascii 130;
		case '3': return "ù";//ascii 151
		case '4': return "ü";//ascii 129
		case '5': return "Ç";//ascii 128
		case '6': return "û";//ascii 150
		case '7': return "~";//ascii 126
		case '8': return "ï";//ascii 139
		case '9': return "è";//ascii 138
		case '!': return "ä";//ascii 132
		case '@': return "/";
		case '#': return "-";
		case '$': return "+";
		case '%': return "à";//ascii 133
		case '^': return "å";//ascii 134 
		case '&': return "ç";//ascii 135
		case '*': return "ê";//ascii 136
		case '(': return "ë";//ascii 137
		case ')': return "î";//ascii 140
		case 'â': return "1";//ascii 131;
		case 'é': return "2";//ascii 130;
		case 'ù': return "2";//ascii 151
		case 'ü': return "4";//ascii 129
		case 'Ç': return "5";//ascii 128
		case 'û': return "6";//ascii 150
		case '~': return "7";//ascii 126
		case 'ï': return "8";//ascii 139
		case 'è': return "9";//ascii 138
		case 'ä': return "!";
		case '/': return "@";
		case '-': return "#";
		case '+': return "$";
		case 'à': return "%";
		case 'å': return "^";
		case 'ç': return "&";
		case 'ê': return "*";
		case 'ë': return "(";
		case 'î': return ")";
		case '=': return "_";
		case '_': return "=";
		case '.': return ";";
		case '?': return "<";
		case '`': return "0";
		case ';': return ".";
		}
		return null;
	}
}
