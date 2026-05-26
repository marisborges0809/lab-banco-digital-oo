import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<>();

	public Banco(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return new ArrayList<>(contas);
	}

	public void abrirConta(Conta conta) {
		this.contas.add(conta);
	}

	public Conta buscarConta(int numero) {
		for (Conta c : contas) {
			if (c.getNumero() == numero) return c;
		}
		return null;
	}

	public boolean encerrarConta(int numero) {
		Conta c = buscarConta(numero);
		if (c != null) {
			return contas.remove(c);
		}
		return false;
	}

	public void transferirEntreContas(int numeroOrigem, int numeroDestino, double valor) {
		Conta origem = buscarConta(numeroOrigem);
		Conta destino = buscarConta(numeroDestino);
		if (origem == null || destino == null) {
			throw new IllegalArgumentException("Conta origem ou destino nao encontrada");
		}
		origem.transferir(valor, destino);
	}

	public List<Conta> listarContasDoCliente(Cliente cliente) {
		List<Conta> resultado = new ArrayList<>();
		for (Conta c : contas) {
			if (c.getCliente().equals(cliente)) resultado.add(c);
		}
		return resultado;
	}

}
