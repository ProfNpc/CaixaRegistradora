package belval.caixa;

import java.util.Scanner;

public class MainMapa {
	public static void main(String[] args) {
		
		String os = getSistemaOperacional(args);
		
		System.out.println("Inicio");
		Scanner teclado = new Scanner(System.in);
		
		try {
			
			criarNovaCaixa();
			
			String comando = "";
			char letraComando = ' ';
			do {
				montaMenu();
				comando = teclado.nextLine() + " ";
				letraComando = comando.toUpperCase().charAt(0);
				if ("NSLO".indexOf(letraComando) > -1) {
					if ('N' == letraComando) {
					} else if ('S' == letraComando) {
					} else if ('L' == letraComando) {
					} else if ('O' == letraComando) {
					}
					limparConsole(os);
					System.out.println("Voce ve:");
				}
			} while(letraComando != 'X');
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			teclado.close();
		}
		System.out.println("Fim");
	}
	
	private static void criarNovaCaixa() {
		// TODO Auto-generated method stub
		
	}

	private static void montaMenu() {
		System.out.println("1 - Receber");
		System.out.println("2 - Retirar");
		System.out.println("3 - Nova Caixa");
	}

	private static String getSistemaOperacional(String[] args) {
		String os = System.getProperty("os.name");
		
		if (args.length >= 1 && args[0].toLowerCase().startsWith("os=")) {
			os = args[0].toLowerCase().replace("os=", "");
		}
		//System.out.println(os);
		return os;
	}
	

	
	public static void limparConsole(String os) {
		try {
			//final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				//Runtime.getRuntime().exec("clear");
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	  
	
}