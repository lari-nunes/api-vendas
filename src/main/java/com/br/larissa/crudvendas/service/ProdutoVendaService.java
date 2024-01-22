package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.exception.PrecoProdutoNuloException;
import com.br.larissa.crudvendas.model.Produto;
import com.br.larissa.crudvendas.model.ProdutoVenda;
import com.br.larissa.crudvendas.repository.ProdutoRepository;
import com.br.larissa.crudvendas.repository.ProdutoVendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
//        } catch (DataIntegrityViolationException e) {
//            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("id_produto")) {
//                throw new RuntimeException("Erro: Já existe um produto com o ID especificado.");
//            } else if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("id_venda")) {
//                throw new RuntimeException("Erro: Já existe uma venda com o ID especificado.");
//            } else {
//                throw e;
//            }
//        }
    }

    public void calcularValorTotal(ProdutoVenda produtoVenda)  {
        if (produtoVenda.getProduto() != null) {
            Optional<Produto> precoProduto = produtoService.buscarProdutoId(produtoVenda.getProduto().getId_produto());
            Produto produto = precoProduto.get();
            Double preco = produto.getVl_preco();
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
