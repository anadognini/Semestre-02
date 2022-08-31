package estacao;

public class PassageirosHora {
	private int[][][] matriz = new int[12][30][24];

	// Letra a
	public void adiciona(int mes, int dia, int hora) {
		this.matriz[mes - 1][dia - 1][hora]++;
	}

	// Letra b
	public int quantosPassageiros(int dia, int mes) {
		int soma = 0;
		int d = dia - 1;
		int m = mes - 1;

		for (int i = 0; i < matriz[m][d].length; i++) {
			soma += matriz[m][d][i];
		}

		return soma;
	}
	
	// Letra c
	public int mesMenorFluxo() {
		int soma = 0;
		int menorSoma = this.quantosPassageiros(1);
		int mesMenorFluxo = 1;

		for (int mes = 2; mes < 12; mes++) {
			int quantidade = this.quantosPassageiros(mes);

			if (soma < menorSoma) {
				menorSoma = soma;

				mesMenorFluxo = mes;
			}
		}

		return mesMenorFluxo;
	}

	// Letra d
	public int picoTransporte(int mes) {
		int total = 0;
		
		for (int dia = 1; dia <= 30; dia++) {
			total += this.quantosPassageiros(dia, mes);
		}
		
		return total;
	}
}

// https://pt.wikipedia.org/wiki/Modelo_em_tr%C3%AAs_camadas