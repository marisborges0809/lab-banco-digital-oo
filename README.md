# Lab - Banco Digital (OO)

Este projeto simula um cenário bancário para demonstrar a aplicação prática dos pilares da **Programação Orientada a Objetos (POO)** em Java. O projeto foi iniciado como uma estrutura base e concluído com a implementação completa das regras de negócio, histórico de transações e tratamento de exceções.

## 🚀 Funcionalidades Concluídas
- **Gerenciamento de Contas:** Suporte a Conta Corrente e Conta Poupança.
- **Operações Bancárias:** Fluxos completos de Depósito, Saque e Transferência entre contas.
- **Histórico de Transações:** Registro detalhado de movimentações com timestamp e tipo de operação.
- **Tratamento de Erros:** Exceção customizada para controle de saldo insuficiente.

---

## 🧠 Conceitos de POO Aplicados

O desenvolvimento do sistema priorizou as boas práticas de orientação a objetos, estruturado da seguinte forma:

* **Abstração:** Modelagem das entidades do domínio bancário (`Conta`, `Banco`, `Movimentacao`) focando apenas nas propriedades fundamentais para o negócio.
* **Encapsulamento:** Proteção dos dados sensíveis (como saldo e histórico) utilizando modificadores de acesso privados e expondo apenas os métodos necessários (`sacar`, `depositar`, `transferir`).
* **Herança:** Reutilização e extensão de código com a classe base `Conta` sendo herdada pelas classes derivadas `ContaCorrente` e `ContaPoupanca`.
* **Polimorfismo:** Tratamento genérico das contas na classe `Banco`, permitindo transações entre diferentes tipos de contas de forma transparente.

---

## 📂 Estrutura do Projeto

O código-fonte está localizado no diretório `src/` e está organizado com as seguintes classes principais:

* `Main.java`: Classe executável contendo a demonstração dos fluxos.
* `Conta.java`, `ContaCorrente.java`, `ContaPoupanca.java`: Modelos e regras das contas.
* `Banco.java`: Gerencia a lista de contas e executa transferências.
* `Movimentacao.java`, `TipoMovimentacao.java`: Entidades responsáveis pelo histórico de transações.
* `SaldoInsuficienteException.java`: Exceção de domínio para operações inválidas.

---

## 🛠️ Pré-requisitos

* Java JDK 11 ou superior configurado no ambiente.

### Como Compilar

Abra o terminal na raiz do projeto e execute:
```bash
javac src/*.java -d bin
