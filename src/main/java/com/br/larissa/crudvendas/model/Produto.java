package com.br.larissa.crudvendas.model;

import com.br.larissa.crudvendas.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
