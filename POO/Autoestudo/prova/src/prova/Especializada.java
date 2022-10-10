package prova;

public class Especializada extends Telefone {
    // Atributos
    private int quantidadeOcorrencias;

    // Getters e setters
    public int getQuantidadeOcorrencias() {
        return quantidadeOcorrencias;
    }

    public void setQuantidadeOcorrencias(int quantidadeOcorrencias) {
        this.quantidadeOcorrencias = quantidadeOcorrencias;
    }

    // Métodos
    public double calcularCustoFixoMensal() {
        if (this.quantidadeOcorrencias <= 1000) {
			return 50.00;
		} else if (this.quantidadeOcorrencias <= 5000) {
			return 67.80;
		} else if (this.quantidadeOcorrencias <= 10000) {
			return 98.50;
		} else if (this.quantidadeOcorrencias <= 50000) {
			return 123.90;
		} else {
			return 187.82;
		}
    }
}
