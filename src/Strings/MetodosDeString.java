package Strings;

public class MetodosDeString {
	
	public void mostrarCharAt(String string) {
		for(int cont = 0; cont < string.length(); cont++) {
			System.out.printf("Na posição %d temos a letra: %c%n", cont, string.charAt(cont));
		}
	}
	public void mostrarCodePointAt(String string) {
		for(int cont = 0; cont < string.length(); cont++) {
			System.out.printf("Na posição %d temos a letra \"%c\" com unicode: %d%n", cont, string.charAt(cont), string.codePointAt(cont));
		}
	}
	
}
