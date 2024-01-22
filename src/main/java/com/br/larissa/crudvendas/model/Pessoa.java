package com.br.larissa.crudvendas.model;

import com.br.larissa.crudvendas.dto.PessoaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;

@Entity(name= "CLIENTE")
@Table(name = "CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @CPF
    private String cpf;

    @Column(unique = true)
    private String nm_cliente;

    @Column(name = "nr_telefone")
    private String nr_telefone;

    @Column(name = "nr_ddd")
    private String nr_ddd;

    @Column(name = "ds_endereco")
    private String ds_endereco;
}