package exercicio_05;

public class Vereador {
	// Atributos
	private String nome;
	private Partido partido;
	private int qtdProjApres, qtdProjAprov;

	// Construtor
	public Vereador(String nome, int qtdProjApres, int qtdProjAprov) {
		this.setNome(nome);
		this.setQtdProjApres(qtdProjApres);
		this.setQtdProjAprov(qtdProjAprov);
	}

	// Getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	// Métodos
	public int getQtdProjApres() {
		return qtdProjApres;
	}

	public void setQtdProjApres(int qtdProjApres) {
		if (qtdProjApres >= 0) {
			this.qtdProjApres = qtdProjApres;
		}
	}

	public int getQtdProjAprov() {
		return qtdProjAprov;
	}

	public void setQtdProjAprov(int qtdProjAprov) {
		if (qtdProjAprov >= 0) {
			this.qtdProjAprov = qtdProjAprov;
		}
	}

	public double getDesempenho() {
		if (this.qtdProjApres == 0) {
			return 0;
		}
		
		return (this.qtdProjAprov / this.qtdProjApres) * this.getIndiceTrabalho();
	}

	public double getIndiceTrabalho() {
		if (this.qtdProjApres > 17) {
			return 1.22;
		}
		
		if (this.qtdProjApres > 10) {
			return 1.08;
		}
		
		if (this.qtdProjApres > 5) {
			return 1.0;
		}
		
		if (this.qtdProjApres > 0) {
			return 0.8;
		}
		
		return 0;
	}
}
