package com.br.larissa.crudvendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "VENDA")
@Table(name = "VENDA")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Integer id_venda;

    @Column(name = "dt_venda")
    private LocalDate dt_venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer"}) //  ignora propriedades específicas durante a serialização, como a classe Pessoa
    private Pessoa pessoa;

    public Venda() {
    }

    public Integer getId_venda() {
        return id_venda;
    }

    public void setId_venda(Integer id_venda) {
        this.id_venda = id_venda;
    }

    public LocalDate getDt_venda() {
        return dt_venda;
    }

    public void setDt_venda(LocalDate dt_venda) {
        this.dt_venda = dt_venda;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
