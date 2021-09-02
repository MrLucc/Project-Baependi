package com.baependi.projetoIntegrador.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baependi.projetoIntegrador.models.Usuario;
import com.baependi.projetoIntegrador.repository.RepositorioUsuario;

@RestController  
@RequestMapping("/baependi/usuario")
public class ControllerUsuario  {

	private @Autowired RepositorioUsuario repositorio;
	
	@GetMapping("/buscarTodos")
	private ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	@GetMapping("/buscarId/{buscarId}")
	private ResponseEntity<Usuario> getById(@PathVariable(value = "buscarId") Long idUsuario){
		Optional <Usuario> objetoUsuario = repositorio.findById(idUsuario);
				if (objetoUsuario.isPresent()) {
					return ResponseEntity.status(200).body(objetoUsuario.get()); 
				}else {
					return ResponseEntity.status(204).build();
				}
			}
	
	@GetMapping("/buscarNome/{buscarNome}")
	private ResponseEntity<List<Usuario>> getByName(@PathVariable(value = "buscarNome") String nomeUsuario){
		List<Usuario> objetoUsuario = repositorio.buscarNome(nomeUsuario);
	    if (objetoUsuario.isEmpty()) {
	    	return ResponseEntity.status(204).build();
	    }else {
	    	return ResponseEntity.status(200).body(objetoUsuario);
	    }
	}
	@PostMapping("/salvar")
	private ResponseEntity <Usuario> salvarUsuario(@Valid @RequestBody Usuario novoUsuario){
		return ResponseEntity.status(201).body(repositorio.save(novoUsuario));
	}
	@PutMapping("/atualizar")
	private ResponseEntity <Usuario> atualizarUsuario(@Valid @RequestBody Usuario atualizarUsuario){
		return ResponseEntity.status(201).body(repositorio.save(atualizarUsuario));
		
	}
	@DeleteMapping("/deletar/{id}")
	private void deletarUsuario(@PathVariable(value = "id") Long idUsuario) {
		repositorio.deleteById(idUsuario);
	}
}
  