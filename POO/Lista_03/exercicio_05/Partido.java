package exercicio_05;

import java.util.ArrayList;

public class Partido {
	// Atributos
	private int numero;
	private String nome;
	private ArrayList<Vereador> vereadores = new ArrayList<>(); // Ligações de 0 para muitos não precisam de getters e setters pois não serão utilizadas fora da classe

	// Construtor
	public Partido() {}

	// Getters e setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if (numero > 9 && numero < 100) {
			this.numero = numero;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Vereador> getVereadores() {
		return vereadores;
	}

	// Métodos
	public int getTotalProjApres() {
		int total = 0;

		for (Vereador vereador : vereadores) {
			total += vereador.getQtdProjApres();
		}

		return total;
	}

	public int getTotalProjetosAprov() {
		int total = 0;

		for (Vereador vereador : vereadores) {
			total += vereador.getQtdProjAprov();
		}

		return total;
	}

	public double getMediaDesempenho() {
		double soma = 0.0;

		for (Vereador vereador : vereadores) {
			soma += vereador.getDesempenho();
		}

		return (soma / vereadores.size());
	}

	public Vereador getVereadorMenorDesempenho() {
		if (vereadores.isEmpty()) {
			return null;
		}

		Vereador piorVereador = vereadores.get(0);
		double menorDesempenho = piorVereador.getDesempenho();

		for (Vereador vereador : vereadores) {
			if (vereador.getDesempenho() < menorDesempenho) {
				piorVereador = vereador;
				menorDesempenho = vereador.getDesempenho();
			}
		}

		return piorVereador;
	}

	public void addVereador(Vereador vereador) {
		this.vereadores.add(vereador);
		vereador.setPartido(this);
	}

	public int getTotalVereadores() {
		return vereadores.size();
	}

	public ArrayList<Vereador> getVereadoresAcima(double linhaDeCorte) {
		ArrayList<Vereador> vereadoresAcima = new ArrayList<>();
		
		for (Vereador vereador : vereadores) {
			if (vereador.getDesempenho() > linhaDeCorte) {
				vereadoresAcima.add(vereador);
			}
		}
		
		return vereadoresAcima;
	}
}

/*  */