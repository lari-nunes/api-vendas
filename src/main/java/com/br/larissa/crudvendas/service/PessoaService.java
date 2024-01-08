package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Pessoa;
import com.br.larissa.crudvendas.repository.PessoaRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa gravarPessoa(Pessoa pessoa) {
        // Verifica se o CPF já está cadastrado
        if (pessoaRepository.findByCpf(pessoa.getCpf()).isPresent()) {
            throw new RuntimeException("Este CPF já está cadastrado.");
        }

        if (pessoa.getNm_cliente() == null || pessoa.getCpf() == null) {
            throw new IllegalArgumentException("O nome e o CPF não podem ser nulos.");
        }
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