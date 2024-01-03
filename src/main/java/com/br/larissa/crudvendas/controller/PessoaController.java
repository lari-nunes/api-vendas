package com.br.larissa.crudvendas.controller;

import com.br.larissa.crudvendas.model.Pessoa;
import com.br.larissa.crudvendas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private List<Pessoa> pessoas = new ArrayList<>();
    private Long idPessoa = Long.valueOf(1);

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> gravarPessoa(@RequestBody Pessoa pessoa) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.gravarPessoa(pessoa));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listarPessoaId(@PathVariable(value = "id") Integer id) {
        Optional<Pessoa> pessoa = pessoaService.buscarPessoaId(id);
        if(pessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa pessoa não existe.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoaId(@PathVariable(value = "id") Integer id, @RequestBody Pessoa pessoa) {
        try {
            Optional<Pessoa> pessoa1 = pessoaService.atualizarPessoaId(id);

            if (pessoa1.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Pessoa não encontrada!");
            }

            Pessoa pessoa2 = pessoa1.get();
            pessoa2.setNm_cliente(pessoa.getNm_cliente());
            pessoa2.setCpf(pessoa.getCpf());
            pessoa2.setDs_endereco(pessoa.getDs_endereco());
            pessoa2.setNr_ddd(pessoa.getNr_ddd());
            pessoa2.setNr_telefone(pessoa.getNr_telefone());

            Pessoa pessoaAtualizada = pessoaService.gravarPessoa(pessoa2);
            return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPessoa(@PathVariable(value = "id") Integer id) {
        try {
            Optional<Pessoa> pessoa = pessoaService.buscarPessoaId(id);

            if (pessoa.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
            }

            pessoaService.deletarPessoaId(pessoa);

            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }


}