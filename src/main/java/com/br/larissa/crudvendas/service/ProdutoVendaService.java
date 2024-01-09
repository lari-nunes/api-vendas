package com.br.larissa.crudvendas.service;

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
        return produtoVendaRepository.save(produtoVenda);
    }

    private void calcularValorTotal(ProdutoVenda produtoVenda) {
        if (produtoVenda.getQt_produto() != null && produtoVenda.getVl_unitario() != null) {
            produtoVenda.setVl_total(produtoVenda.getQt_produto() * produtoVenda.getVl_unitario());
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
