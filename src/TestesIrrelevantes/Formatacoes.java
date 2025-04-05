package TestesIrrelevantes;
public class Formatacoes {

	public void stringParaUnicode(String mensagem) {
		System.out.println("\"" + mensagem + "\" em UNICODE");
		for(int cont = 0; cont < mensagem.length(); cont++) {
			System.out.print(mensagem.charAt(cont) + "[" + mensagem.codePointAt(cont) + "] ");
		}
	}
	
	private int[] retornarUnicodes(String mensagem) {
		
		int[] unicodes = new int[mensagem.length()];
		for(int cont = 0; cont < mensagem.length(); cont++) {
			unicodes[cont] = mensagem.charAt(cont);
		}
		
		return unicodes;
	}
	
	
	public void unicodeParaString(String mensagem) {
		
		int[] unicodes = new int[mensagem.length()];
		for(int cont = 0; cont < mensagem.length(); cont++) {
			unicodes[cont] = retornarUnicodes(mensagem)[cont];
		}
		
		System.out.print("\"");
		for(int cont = 0; cont < mensagem.length(); cont++) {
			System.out.print("["+mensagem.codePointAt(cont) + "]");
		}
		System.out.println("\"");
		
		System.out.print("\nPara String: ");
		char[] palavras = new char[mensagem.length()];
		for(int cont = 0; cont < mensagem.length(); cont++) {
			palavras = Character.toChars(unicodes[cont]);
			System.out.print(palavras);
		}
	}
	
	public void unicodeParaBinario(String mensagem) {
		
		String[] binarios = transfomarEmBinario(mensagem);
		
		System.out.println("\"" + mensagem + "\" em BINARIO: ");
		for(int cont = 0; cont < mensagem.length(); cont++) {
			System.out.print("[" + binarios[cont] + "] ");
		}
	}
	
	private String[] transfomarEmBinario(String mensagem) {
		int[] unicodes = retornarUnicodes(mensagem);
		String[] binarios = new String[mensagem.length()];
		
		// Passando de unicode para binario
		for(int cont = 0; cont < mensagem.length(); cont++) {
			binarios[cont] = Integer.toBinaryString(unicodes[cont]);
		}
		return binarios;
	}
	
	public void binarioParaString(String mensagem) {
		String mensagemBinaria = "";
		String[] binarios = transfomarEmBinario(mensagem);
		for(int cont = 0; cont < mensagem.length(); cont++) {
			mensagemBinaria+=binarios[cont];
		}
		char[] binForString = new char[mensagemBinaria.length()];
		
		for(int bin = 0, cont = 0; bin < mensagemBinaria.length(); bin += 8, cont++) {
			String byteString = mensagemBinaria.substring(bin, bin + 8);
			int unicode = Integer.parseInt(byteString, 2);
			binForString[cont] = (char) unicode;
		}
		System.out.println("Texto: ");
		for(int cont = 0; cont < binForString.length; cont++) {
			System.out.print(binForString[cont]);
		}
	}
	

}
