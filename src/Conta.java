
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	private int agencia;
	private int numero;
	private BigDecimal saldo = BigDecimal.ZERO;
	private Cliente cliente;
	private List<Movimentacao> historico = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(BigDecimal valor) {
		validarValorPositivo(valor);
		if (valor.compareTo(this.saldo) > 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente para saque");
		}
		this.saldo = this.saldo.subtract(valor);
		this.historico.add(new Movimentacao(TipoMovimentacao.SAQUE, valor, "Saque"));
	}

	@Override
	public void depositar(BigDecimal valor) {
		validarValorPositivo(valor);
		this.saldo = this.saldo.add(valor);
		this.historico.add(new Movimentacao(TipoMovimentacao.DEPOSITO, valor, "Deposito"));
	}

	@Override
	public void transferir(BigDecimal valor, IConta contaDestino) {
		validarValorPositivo(valor);
		if (valor.compareTo(this.saldo) > 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente para transferencia");
		}
		this.saldo = this.saldo.subtract(valor);
		contaDestino.depositar(valor);
		this.historico.add(new Movimentacao(TipoMovimentacao.TRANSFERENCIA, valor, "Transferencia para conta " + ((Conta) contaDestino).getNumero()));
	}

	private void validarValorPositivo(BigDecimal valor) {
		if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Valor deve ser maior que zero");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public BigDecimal getSaldo() {
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
		System.out.println(String.format("Saldo: %s", this.saldo.setScale(2)));
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
