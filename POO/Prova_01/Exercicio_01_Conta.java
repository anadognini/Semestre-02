package conta;

import java.time.LocalDate;

public class Conta {
	// Atributos
	private String numero;
	private LocalDate dataAbertura;
	private double saldo;

	// Construtor
	public Conta(String numero) {
		this.saldo;
		this.setDataAbertura(LocalDate.now());
		this.setNumero(numero);
	}

	// Getters e setters
		public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// !!!!!! Cada atributo é problema da classe a qual ele pertence, portanto se saldo é atributo da classe Conta cabe à ela lidar com o estado dele

	// Métodos
	public void sacar(double valor) {
		if (valor > 0 && this.saldo >= valor) {
			this.saldo = this.saldo - valor;
		}
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
		}
	}
}