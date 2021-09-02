package com.baependi.projetoIntegrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
