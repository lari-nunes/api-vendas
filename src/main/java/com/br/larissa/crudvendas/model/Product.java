package com.br.larissa.crudvendas.model;

import com.br.larissa.crudvendas.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price;
    private LocalDate dt_validade;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Product(ProductRequestDTO data){
        this.price = data.price();
        this.name = data.name();
        this.dt_validade = data.dt_validade();
    }
}