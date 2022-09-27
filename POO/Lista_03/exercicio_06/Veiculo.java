package lista_03.exercicio_06;

import java.time.LocalDate;

public class Veiculo {
	// Atributos
	private String placa;
	private String modelo;
	private LocalDate dataAquis;

	// Getters e setters
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getDataAquis() {
		return dataAquis;
	}

	public void setDataAquis(LocalDate dataAquis) {
		this.dataAquis = dataAquis;
	}

	// Métodos
	public float getIndiceSucateamento() {

	}

	public float getCustoMedioManutencao() {
	}

	public void comparaCom(Veiculo veiculo) {

	}

	public void addManutencao(Manutencao manutencao) {

	}

	public int getTotalTempoParado() {}
	
	public int getQtdVezesServico(String seila) {
		
	}
}
