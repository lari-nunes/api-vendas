package com.br.larissa.crudvendas.model;

import com.br.larissa.crudvendas.dto.ProdutoDTO;
import com.br.larissa.crudvendas.dto.ProdutoVendaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "PRODUTO_VENDA")
@Table(name = "PRODUTO_VENDA", uniqueConstraints = @UniqueConstraint(columnNames = "id_produto", name = "UK_id_produto"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_produto_venda")
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
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    private Produto produto;

}
