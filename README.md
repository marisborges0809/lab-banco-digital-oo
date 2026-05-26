# Lab - Banco Digital (OO)

Este projeto simula um cenário bancário para demonstrar a aplicação prática dos pilares da **Programação Orientada a Objetos (POO)** em Java. O projeto foi iniciado como uma estrutura base e evoluiu para implementar regras de negócio, histórico de transações e tratamento de exceções.

## Funcionalidades Concluídas
- Gerenciamento de Contas: Conta Corrente e Conta Poupança
- Operações Bancárias: Depósito, Saque e Transferência
- Histórico de Transações com timestamp e tipo
- Exceção customizada para saldo insuficiente

## Conceitos de POO Aplicados
- Abstração (`Conta`, `Banco`, `Movimentacao`)
- Encapsulamento (saldo e histórico privados)
- Herança (`Conta` -> `ContaCorrente` / `ContaPoupanca`)
- Polimorfismo (operações genéricas via `IConta`)

## Estrutura do Projeto
O código-fonte está em `src/` com as classes principais:

- `Main.java` — demonstra fluxos (abertura, depósito, transferência, extratos)
- `Conta.java`, `ContaCorrente.java`, `ContaPoupanca.java`
- `Banco.java`
- `Movimentacao.java`, `TipoMovimentacao.java`
- `SaldoInsuficienteException.java`

## Pré-requisitos

- Java JDK 11 ou superior

## Como Compilar

Abra um terminal na raiz do projeto e execute:

```bash
javac src/*.java -d bin
```

## Como Executar

```bash
java -cp bin Main
```

## Exemplo de Saída

```
Extratos no banco: Banco OO

=== Extrato Conta Corrente ===
Titular: Venilton
Agencia: 1
Numero: 1
Saldo: 0.00
-- Historico --
2026-05-26T03:13:26.990814 | DEPOSITO | 100.00 | Deposito
2026-05-26T03:13:27.022206 | TRANSFERENCIA | 100.00 | Transferencia para conta 2

=== Extrato Conta Poupanca ===
Titular: Venilton
Agencia: 1
Numero: 2
Saldo: 100.00
-- Historico --
2026-05-26T03:13:26.991122 | DEPOSITO | 100.00 | Deposito
```

## Uso de `BigDecimal`

O projeto utiliza `BigDecimal` para operações monetárias. Exemplos de criação de valores:

```java
// partir de long/double fixo
BigDecimal v1 = BigDecimal.valueOf(100);

// partir de String (recomendado para precisão)
BigDecimal v2 = new BigDecimal("1234.56");

// ajustar escala ao imprimir
System.out.println(v2.setScale(2));
```

Ao adicionar valores manualmente no código, prefira `BigDecimal.valueOf(...)` ou `new BigDecimal("...")`.

## Observações e Melhorias Sugeridas

- Precisão monetária tratada com `BigDecimal` (já aplicado no código).
- Separar a lógica de apresentação (prints) da camada de domínio para testes automatizados.
- Adicionar testes unitários (JUnit) e persistência (arquivo/JSON/BD) para produção.

## Entrega (estágio)

O estado atual é adequado para uma entrega de estágio: compila, executa e demonstra abertura de contas, depósitos, transferências e extratos. Inclua este README na submissão.
