package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Produto;
import com.br.larissa.crudvendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto gravarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoId(Integer id){
        return produtoRepository.findById(id);
    }

    public Optional<Produto> atualizaProdutoId(Integer id){
        return produtoRepository.findById(id);
    }

    public void deletarProdutoId(Optional<Produto> produto){
        produtoRepository.delete(produto.get());
    }
}
