package com.br.larissa.crudvendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
@Data
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @Column(name = "nm_produto")
    private String nm_produto;

    @Column(name = "dt_validade")
    private LocalDate dt_validade;

    @Column(name = "vl_preco")
    private Double vl_preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    @JsonIgnoreProperties({"hibernateLazyInitializer"}) //  ignora propriedades específicas durante a serialização, como a classe Categoria
    private Categoria categoria;

    public Produto() {
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getNm_produto() {
        return nm_produto;
    }

    public void setNm_produto(String nm_produto) {
        this.nm_produto = nm_produto;
    }

    public LocalDate getDt_validade() {
        return dt_validade;
    }

    public void setDt_validade(LocalDate dt_validade) {
        this.dt_validade = dt_validade;
    }

    public Double getVl_preco() {
        return vl_preco;
    }

    public void setVl_preco(Double vl_preco) {
        this.vl_preco = vl_preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
