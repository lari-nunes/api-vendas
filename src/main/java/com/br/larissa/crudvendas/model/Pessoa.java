package com.br.larissa.crudvendas.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name= "CLIENTE")
@Table(name = "CLIENTE")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String nm_cliente;

    @Column(name = "nr_telefone")
    private String nr_telefone;

    @Column(name = "nr_ddd")
    private String nr_ddd;

    @Column(name = "ds_endereco")
    private String ds_endereco;

    public Pessoa() {
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getNr_telefone() {
        return nr_telefone;
    }

    public void setNr_telefone(String nr_telefone) {
        this.nr_telefone = nr_telefone;
    }

    public String getNr_ddd() {
        return nr_ddd;
    }

    public void setNr_ddd(String nr_ddd) {
        this.nr_ddd = nr_ddd;
    }

    public   String getDs_endereco() {
        return ds_endereco;
    }

    public void setDs_endereco(String ds_endereco) {
        this.ds_endereco = ds_endereco;
    }
}