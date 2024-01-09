package com.br.larissa.crudvendas.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity(name = "CATEGORIA")
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    private String nome;

    public Categoria() {
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}