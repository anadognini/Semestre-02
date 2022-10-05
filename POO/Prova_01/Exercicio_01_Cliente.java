package conta;

public class Cliente {
	// Atributos
	private String codigo;
	private String nome;
	private HashMap<String, Conta> contas = new HashMap<>();

	// Construtor
	public Cliente(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	// Getters e setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos
	public Conta criarConta() {
		novaConta = new Conta();
		contas.add(novaConta);

		return novaConta;
	}

	public void depositar(Conta conta, double valorDeposito) {
		double novoSaldo = conta.getSaldo() + valorDeposito;
		conta.setSaldo(novoSaldo);
	}

	public void sacar(double valor) {
	}

	public void realizarSaqueEspecial(Conta conta, double valorEspecial) {
		if (valorEspecial == conta.getSaldo()) {
			conta.setSaldo(0);
		}
	}

	public void transferir(Conta conta1, Conta conta2, double valorTransferido) {
		double novoSaldoConta1 = conta1.getSaldo() - valorTransferido;
		conta1.setSaldo(novoSaldoConta1);

		double novoSaldoConta2 = conta2.getSaldo() + valorTransferido;
		conta2.setSaldo(novoSaldoConta2);
	}

	public void getSaldo(Conta conta) {
		System.out.println("O saldo da conta " + conta.getNumero() + " é: R$ " + conta.getSaldo());
	}

	public void getSaldo() {
		double saldo = 0;

		if (contas != null) {
			for (Conta conta : contas) {
				saldo += conta.getSaldo();
			}

			System.out.println("O saldo total do cliente " + this.nome + " é: R$ " + saldo);
		}
	}
}