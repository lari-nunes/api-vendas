package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.exception.PrecoProdutoNuloException;
import com.br.larissa.crudvendas.model.Product;
import com.br.larissa.crudvendas.model.ProdutoVenda;

import com.br.larissa.crudvendas.repository.ProdutoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoVendaService {

    private final ProdutoService produtoService;
    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    @Autowired
    public ProdutoVendaService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ProdutoVenda gravarProdutoVenda(ProdutoVenda produtoVenda){
            calcularValorTotal(produtoVenda);
            return produtoVendaRepository.save(produtoVenda);
    }

    public void calcularValorTotal(ProdutoVenda produtoVenda)  {
        if (produtoVenda.getProduto() != null) {
            Optional<Product> precoProduto = produtoService.buscarProdutoId(String.valueOf(produtoVenda.getProduto().getPrice()));
            Product product = precoProduto.get();
            Double preco = Double.valueOf(product.getPrice());
            produtoVenda.setVl_unitario(preco);
            if(preco == null){
                throw new PrecoProdutoNuloException("O preço do produto é null.");
            }
            produtoVenda.setVl_total(produtoVenda.getQt_produto() * preco);
            produtoVenda.getVl_total();
        } else {
            System.out.println("O produto é null.");
        }
    }

    public List<ProdutoVenda> listarProdutoVendas(){
        return produtoVendaRepository.findAll();
    }

    public Optional<ProdutoVenda> buscarProdutoVendaId(Integer id){
        return produtoVendaRepository.findById(id);
    }

    public Optional<ProdutoVenda> atualizarProdutoVendaId(Integer id){
        return produtoVendaRepository.findById(id);
    }

    public void deletarProdutoVenda(Optional<ProdutoVenda> produtoVenda){
        produtoVendaRepository.delete(produtoVenda.get());
    }
}
