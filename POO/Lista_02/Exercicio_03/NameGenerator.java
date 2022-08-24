import java.util.Scanner;

public class NameGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] entrada = new String[3];
		
		System.out.println("Informe seu nome completo: ");
		entrada[0] = scanner.nextLine();
		
		System.out.println("Informe o sobrenome de solteira da sua mãe: ");
		entrada[1] = scanner.nextLine();
		
		System.out.println("Informe a cidade onde você nasceu: ");
		entrada[2] = scanner.nextLine();
		
		System.out.println(generateStarWarsName(entrada));
		
		scanner.close();		
	}
	
	public static String generateStarWarsName(String[] entrada) {
		String[] nomeCompleto = entrada[0].split(" ");
		String sobrenomeMae = entrada[1];
		String cidade = entrada[2];
		
		String primeiroNome = nomeCompleto[0];
		String sobrenome = nomeCompleto[nomeCompleto.length - 1];
		
		String nomeStarWars = sobrenome.substring(0, 3) 
				+ primeiroNome.substring(0, 2).toLowerCase();
		
		String sobrenomeStarWars = sobrenomeMae.substring(0, 2) 
				+ cidade.substring(0, 3).toLowerCase();
		
		return nomeStarWars + " " + sobrenomeStarWars;
	}
}

/* 
 * entrada[0] = “João Aparecido da Silva”
 * entrada[1] = “Dores”
 * entrada[2] = “Blumenau 
 * gerada → Siljo Doblu
 **/
