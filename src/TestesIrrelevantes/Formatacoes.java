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
	// TUDO resolver o problema de valor excedendo valor do array
	public void binarioParaString(int mensagem) {
		String binarioFormatado = String.format("%8s", mensagem).replace(' ', '0');
		
		StringBuilder novaMensagem = new StringBuilder();
		
		for(int cont = 0; cont < binarioFormatado.length(); cont += 8) {
			String byteParaString = binarioFormatado.substring(cont, cont + 8);
			int codigo = Integer.parseInt(byteParaString, 2);
			novaMensagem.append((char) codigo);
		}
		System.out.println("Mensagem: " + novaMensagem.toString());
	}
}
