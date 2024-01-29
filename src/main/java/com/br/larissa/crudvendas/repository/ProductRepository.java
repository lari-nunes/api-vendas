package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

