
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");

		Banco banco = new Banco("Banco OO");

		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		banco.abrirConta(cc);
		banco.abrirConta(poupanca);

		// deposito na conta corrente
		Conta contaCorrente = banco.buscarConta(cc.getNumero());
		contaCorrente.depositar(100);

		// transferencia realizada via Banco
		banco.transferirEntreContas(cc.getNumero(), poupanca.getNumero(), 100);

		// imprimir extratos
		System.out.println();
		System.out.println("Extratos no banco: " + banco.getNome());
		System.out.println();
		Conta c1 = banco.buscarConta(cc.getNumero());
		Conta c2 = banco.buscarConta(poupanca.getNumero());
		c1.imprimirExtrato();
		System.out.println();
		c2.imprimirExtrato();
	}

}
