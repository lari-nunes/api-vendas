package com.br.larissa.crudvendas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "PRODUTO_VENDA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoVenda implements Serializable {

    @EmbeddedId
    private ProdutoVendaId id;

    @Column(name = "qt_produto")
    private Integer qt_produto;

    @Column(name = "vl_total")
    private Double vl_total;

    @Column(name = "vl_unitario")
    private Double vl_unitario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Venda venda;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product produto;
}
