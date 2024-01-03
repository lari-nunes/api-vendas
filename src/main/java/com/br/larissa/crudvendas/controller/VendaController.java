package com.br.larissa.crudvendas.controller;

import com.br.larissa.crudvendas.model.Venda;
import com.br.larissa.crudvendas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Object> gravarVenda(@RequestBody Venda venda){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.gravarVenda(venda));
    }

    @GetMapping
    public ResponseEntity<List<Venda>> listarVendas(){
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.listarVendas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarVendasId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.buscarVendaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVendaId(@PathVariable(value = "id") Integer id, @RequestBody Venda venda) {
        try {
            Venda vendaAtualizada = vendaService.atualizarVendaId(id)
                    .orElseThrow(() -> new RuntimeException("Venda não encontrada!"));

            vendaAtualizada.setDt_venda(venda.getDt_venda());
            vendaAtualizada.setPessoa(venda.getPessoa());

            return ResponseEntity.status(HttpStatus.OK).body(vendaService.gravarVenda(vendaAtualizada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVendaId(@PathVariable(value = "id") Integer id) {

        Optional<Venda> venda = vendaService.buscarVendaId(id);
        if (venda.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Venda não localizada!");
        }

        vendaService.deletarVenda(venda);

        return ResponseEntity.status(HttpStatus.OK).body("Venda deletada com sucesso!");
    }
}
