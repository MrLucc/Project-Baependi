package com.baependi.projetoIntegrador.controller;

import com.baependi.projetoIntegrador.models.Produtos;
import com.baependi.projetoIntegrador.repository.RepositorioProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class ControllerProdutos {
    private @Autowired
    RepositorioProdutos repositorio;

    @GetMapping("/buscarTodos")
    private ResponseEntity<List<Produtos>> GetAll() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    @GetMapping("/BuscarProdutoId/ {idProduto}")
    private ResponseEntity<Produtos> findById(@PathVariable(value = "idProduto") Long idProduto) {
        Optional<Produtos> objetoProduto = repositorio.findById(idProduto);

        if (objetoProduto.isPresent()) {
            return ResponseEntity.status(200).body(objetoProduto.get());
        } else {
            return ResponseEntity.status(204).build();
        }

    }

    @GetMapping("/acharPorNomeProduto/ {nomeProduto}")
    private ResponseEntity<List<Produtos>> acharPorNome(@PathVariable(value = "nomeProduto") String nomeDoProduto) {
        List<Produtos> objetoProduto = repositorio.findAllByNomeDoProdutoContainingIgnoreCase(nomeDoProduto);
        if (objetoProduto.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(201).body(objetoProduto);
        }
    }

    @PostMapping("/salvar")
    private ResponseEntity<Produtos> salvarProduto(@Valid @RequestBody Produtos produtoSalvo) {
        return ResponseEntity.status(201).body(repositorio.save(produtoSalvo));
    }

    @PutMapping("/atualizar")
    private ResponseEntity<Produtos> atualizarProduto(@Valid @RequestBody Produtos produtoAtualizado) {
        return ResponseEntity.status(201).body(repositorio.save(produtoAtualizado));
    }

    @DeleteMapping("/deletar/{idProduto")
    private void deletarProduto(@PathVariable(value = "idProduto") Long idProduto) {
        repositorio.deleteById(idProduto);
    }
}
