package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Pessoa;
import com.br.larissa.crudvendas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa gravarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaId(Integer id){
        return pessoaRepository.findById(id);
    }

    public Optional<Pessoa> atualizarPessoaId(Integer id){
        return pessoaRepository.findById(id);
    }

    public void deletarPessoaId(Optional<Pessoa> pessoa){
        pessoaRepository.delete(pessoa.get());
    }
}
