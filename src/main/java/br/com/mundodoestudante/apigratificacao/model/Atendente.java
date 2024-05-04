package br.com.mundodoestudante.apigratificacao.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "atendentes", uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "loja"}))
@Getter
@EqualsAndHashCode(of = "id")
public class Atendente {

    @Getter
    private static List<Atendente> atendentes = new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private ELoja nomeLoja;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Loja loja;
    @Getter
    private List<BigDecimal> vendas = new ArrayList<>(6);
    private BigDecimal totalVendas = BigDecimal.ZERO;
    private BigDecimal gratificacao = BigDecimal.ZERO;
    private BigDecimal bonus = BigDecimal.ZERO;

    public Atendente() {
    }

    public Atendente(String nome, ELoja loja) {
        this.nome = nome;
        this.nomeLoja = loja;
        for (int i = 0; i < 6; i++) {
            this.vendas.add(BigDecimal.ZERO);
        }
        atendentes.add(this);
    }

    public void atribuirLoja(Loja loja) {
        this.loja = loja;
        this.loja.atribuirAtendente(this);
    }

    public void registraGratificacao(BigDecimal valor) {
        this.gratificacao = this.gratificacao.add(valor);
    }

    public void receberBonificacao(BigDecimal bonus) {
        this.bonus = this.bonus.add(bonus);
    }

    public void gravarVendasPrimeiraSemna(String valor) {
        var valorFormatado = formatarValor(valor);
        this.somarValor(0, this.vendas.get(0), new BigDecimal(valorFormatado));
        this.totalVendas = this.totalVendas.add(new BigDecimal(valorFormatado));
    }

    public void gravarVendasSegundaSemana(String valor) {
        var valorFormatado = formatarValor(valor);
        this.somarValor(1, this.vendas.get(1), new BigDecimal(valorFormatado));
        this.totalVendas = this.totalVendas.add(new BigDecimal(valorFormatado));
    }

    public void gravarVendasTerceiraSemana(String valor) {
        var valorFormatado = formatarValor(valor);
        this.somarValor(2, this.vendas.get(2), new BigDecimal(valorFormatado));
        this.totalVendas = this.totalVendas.add(new BigDecimal(valorFormatado));
    }

    public void gravarVendasQuartaSemana(String valor) {
        var valorFormatado = formatarValor(valor);
        this.somarValor(3, this.vendas.get(3), new BigDecimal(valorFormatado));
        this.totalVendas = this.totalVendas.add(new BigDecimal(valorFormatado));
    }

    public void gravarVendasQuintaSemana(String valor) {
        var valorFormatado = formatarValor(valor);
        this.somarValor(4, this.vendas.get(4), new BigDecimal(valorFormatado));
        this.totalVendas = this.totalVendas.add(new BigDecimal(valorFormatado));
    }

    public void gravarVendasSextaSemana(String valor) {
        var valorFormatado = formatarValor(valor);
        this.somarValor(5, this.vendas.get(5), new BigDecimal(valorFormatado));
        this.totalVendas = this.totalVendas.add(new BigDecimal(valorFormatado));
    }

    private String formatarValor(String valor) {
        return valor.replace(",", ".");
    }

    private void somarValor(int indice, BigDecimal valorAtual, BigDecimal novoValor) {
        var valorSomado = valorAtual.add(novoValor);
        this.vendas.set(indice, valorSomado);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.00");
        String vendasFormatadas = df.format(this.totalVendas);
        String gratificacaoFormatada = df.format(this.gratificacao);
        String bonusFormatado = df.format(this.bonus);

        return String.format("%-15s | Vendas: %-10s | Gratificação: %-10s | Bonus: %-10s",
                this.nome, vendasFormatadas, gratificacaoFormatada, bonusFormatado);
    }
}
