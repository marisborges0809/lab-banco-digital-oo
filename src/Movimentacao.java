import java.time.LocalDateTime;

public class Movimentacao {

    private TipoMovimentacao tipo;
    private double valor;
    private LocalDateTime data;
    private String descricao;

    public Movimentacao(TipoMovimentacao tipo, double valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = LocalDateTime.now();
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %.2f | %s", data, tipo, valor, descricao == null ? "" : descricao);
    }
}
