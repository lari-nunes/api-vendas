package com.br.larissa.crudvendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity(name = "PRODUTO_VENDA")
@Table(name = "PRODUTO_VENDA")
public class ProdutoVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto_venda")
    private Integer id_produto_venda;

    @Column(name = "qt_produto")
    private Integer qt_produto;

    @Column(name = "vl_total")
    private Double vl_total;

    @Column(name = "vl_unitario")
    private Double vl_unitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Venda venda;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Produto produto;

    public ProdutoVenda() {
    }

    public Integer getId_produto_venda() {
        return id_produto_venda;
    }

    public void setId_produto_venda(Integer id_produto_venda) {
        this.id_produto_venda = id_produto_venda;
    }

    public Integer getQt_produto() {
        return qt_produto;
    }

    public void setQt_produto(Integer qt_produto) {
        this.qt_produto = qt_produto;
    }

    public Double getVl_total() {
        return vl_total;
    }

    public void setVl_total(Double vl_total) {
        this.vl_total = vl_total;
    }

    public Double getVl_unitario() {
        return vl_unitario;
    }

    public void setVl_unitario(Double vl_unitario) {
        this.vl_unitario = vl_unitario;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
