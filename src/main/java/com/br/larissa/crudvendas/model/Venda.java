package com.br.larissa.crudvendas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "VENDA")
@Table(name = "VENDA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
