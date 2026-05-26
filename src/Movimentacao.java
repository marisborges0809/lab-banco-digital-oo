import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Movimentacao {

    private TipoMovimentacao tipo;
    private BigDecimal valor;
    private LocalDateTime data;
    private String descricao;

    public Movimentacao(TipoMovimentacao tipo, BigDecimal valor, String descricao) {
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = LocalDateTime.now();
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
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
        return String.format("%s | %s | %s | %s", data, tipo, valor.setScale(2), descricao == null ? "" : descricao);
    }
}
