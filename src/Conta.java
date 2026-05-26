
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	private List<Movimentacao> historico = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		validarValorPositivo(valor);
		if (valor > this.saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para saque");
		}
		this.saldo -= valor;
		this.historico.add(new Movimentacao(TipoMovimentacao.SAQUE, valor, "Saque"));
	}

	@Override
	public void depositar(double valor) {
		validarValorPositivo(valor);
		this.saldo += valor;
		this.historico.add(new Movimentacao(TipoMovimentacao.DEPOSITO, valor, "Deposito"));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		validarValorPositivo(valor);
		if (valor > this.saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para transferencia");
		}
		this.saldo -= valor;
		contaDestino.depositar(valor);
		this.historico.add(new Movimentacao(TipoMovimentacao.TRANSFERENCIA, valor, "Transferencia para conta " + ((Conta) contaDestino).getNumero()));
	}

	private void validarValorPositivo(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor deve ser maior que zero");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Movimentacao> getHistorico() {
		return new ArrayList<>(historico);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public void imprimirExtrato() {
		imprimirInfosComuns();
		System.out.println("-- Historico --");
		for (Movimentacao m : historico) {
			System.out.println(m);
		}
	}
}
