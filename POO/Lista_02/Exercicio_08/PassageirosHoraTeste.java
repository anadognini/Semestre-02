package estacao;

public class PassageirosHoraTeste {

	public static void main(String[] args) {
		PassageirosHora ph = new PassageirosHora();
		
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		ph.adiciona(10, 9, 14);
		
		System.out.println(ph.quantosPassageiros(9, 10));
	}

}
