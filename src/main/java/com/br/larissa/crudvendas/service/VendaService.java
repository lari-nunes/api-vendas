package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Venda;
import com.br.larissa.crudvendas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda gravarVenda(Venda venda){
        return vendaRepository.save(venda);
    }

    public List<Venda> listarVendas(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarVendaId(Integer id){
        return vendaRepository.findById(id);
    }

    public Optional<Venda> atualizarVendaId(Integer id){
        return vendaRepository.findById(id);
    }

    public void deletarVenda(Optional<Venda> venda){
        vendaRepository.delete(venda.get());
    }
}
