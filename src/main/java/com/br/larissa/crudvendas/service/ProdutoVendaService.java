package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Produto;
import com.br.larissa.crudvendas.model.ProdutoVenda;
import com.br.larissa.crudvendas.repository.ProdutoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoVendaService {

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    public ProdutoVenda gravarProdutoVenda(ProdutoVenda produtoVenda){
        calcularValorTotal(produtoVenda);
        return produtoVendaRepository.save(produtoVenda);
    }

    private void calcularValorTotal(ProdutoVenda produtoVenda) {
        Produto produto = produtoVenda.getProduto();
        Double preco = produtoVenda.getVl_total();  // Access the correct attribute

        produtoVenda.setVl_total(produtoVenda.getQt_produto() * preco);
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
