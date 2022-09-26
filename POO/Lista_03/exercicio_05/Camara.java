package exercicio_05;

import java.util.ArrayList;
import java.util.List;

public class Camara {
	private ArrayList<Partido> partidos = new ArrayList<>();

	public void addVereador(Vereador vereador, Partido partido) {
		if (vereador != null && partido != null) {
			partido.addVereador(vereador);
		}
	}

	public void addPartido(Partido partido) {
		if (partido != null) {
			this.partidos.add(partido);
		}
	}

	public Vereador getVereadorMenorDesempenho() {
		double menorDesempenho = Double.MAX_VALUE;
		Vereador vereadorMenorDesempenho = null;

		for (Partido partido : partidos) {
			Vereador vereadorMenorDesempenhoPartido = partido.getVereadorMenorDesempenho();

			if (vereadorMenorDesempenhoPartido != null
					&& vereadorMenorDesempenhoPartido.getDesempenho() < menorDesempenho) {

				menorDesempenho = vereadorMenorDesempenhoPartido.getDesempenho();
				vereadorMenorDesempenho = vereadorMenorDesempenhoPartido;
			}
		}

		return vereadorMenorDesempenho;
	}

	public int getTotalProjApres() {
		int total = 0;

		for (Partido partido : partidos) {
			total += partido.getTotalProjApres();
		}

		return total;
	}

	public int getTotalProjetosAprov() {
		int total = 0;

		for (Partido partido : partidos) {
			total += partido.getTotalProjetosAprov();
		}

		return total;
	}

	public Vereador getVereadorComMaisProjetosAprovs() {
		int projetosAprov = 0;
		Vereador vereadorMaisProjAprov = null;

		for (Partido partido : partidos) {
			ArrayList<Vereador> lista = partido.getVereadores();

			for (Vereador vereador : lista) {
				if (vereador.getQtdProjAprov() > projetosAprov) {
					projetosAprov = vereador.getQtdProjAprov();
					vereadorMaisProjAprov = vereador;
				}
			}
		}

		return vereadorMaisProjAprov;
	}

	public int getQtdPartidos() {
		return this.partidos.size();
	}

	public double getDesempenhoMedioCamara() {
		double somaMediaPartidos = 0;

		if (this.getQtdPartidos() == 0) {
			return 0;
		}

		for (Partido partido : partidos) {
			somaMediaPartidos += partido.getMediaDesempenho() * partido.getTotalVereadores();
		}

		return somaMediaPartidos / this.getQtdPartidos();
	}

	public List<Vereador> getVeradoresAcimaMedia() {
		List<Vereador> vereadoresAcimaMediaCamara = new ArrayList<>();
		double mediaCamara = this.getDesempenhoMedioCamara();

		for (Partido partido : this.partidos) {
			ArrayList<Vereador> vereadoresAcimaMediaPartido = partido.getVereadoresAcima(mediaCamara);
			vereadoresAcimaMediaCamara.addAll(vereadoresAcimaMediaPartido);
		}

		return vereadoresAcimaMediaCamara;
	}
}