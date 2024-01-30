//package com.br.larissa.crudvendas.controller;
//
//import com.br.larissa.crudvendas.model.Produto;
//import com.br.larissa.crudvendas.repository.ProdutoRepository;
//import com.br.larissa.crudvendas.service.ProdutoService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/produto")
//public class ProdutoController {
//
//    @Autowired
//    private ProdutoService produtoService;
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    @PostMapping
//    public ResponseEntity postProduto(@RequestBody @Valid ProdutoRequestDTO body){
//        Produto newProduct = new Produto(body);
//        Produto savedProduct = this.produtoRepository.save(newProduct);
//        return ResponseEntity.ok(savedProduct);
//    }
//
//    @GetMapping
//    public ResponseEntity getAllProduct(){
//        List<ProdutoResponseDTO> productList = this.produtoRepository.findAll().stream().map(ProdutoResponseDTO::new).toList();
//        return ResponseEntity.ok(productList);
//    }
//
////    @GetMapping("/{id}")
////    public ResponseEntity<Object> listarProdutosId(@PathVariable(value = "id") Integer id) {
////        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutoId(id));
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<Object> atualizarProdutoId(@PathVariable(value = "id") Integer id, @RequestBody Produto produto) {
////        try {
////            Optional<Produto> produto1 = produtoService.atualizaProdutoId(id);
////
////            if (produto1.isEmpty()) {
////                return ResponseEntity.status(HttpStatus.OK).body("Produto não encontrado!");
////            }
////
////            Produto produto2 = produto1.get();
////            produto2.setNm_produto(produto.getNm_produto());
////            produto2.setCategoria(produto.getCategoria());
////            produto2.setDt_validade(produto.getDt_validade());
////            produto2.setVl_preco(produto.getVl_preco());
////
////            Produto produtoAtualizado = produtoService.gravarProduto(produto2);
////            return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
////        }
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Object> deletarProdutoId(@PathVariable(value = "id") Integer id) {
////
////        Optional<Produto> produto = produtoService.buscarProdutoId(id);
////        if (produto.isEmpty()) {
////            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
////        }
////
////        produtoService.deletarProdutoId(produto);
////
////        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
////    }
//}
