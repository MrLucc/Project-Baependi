package com.baependi.projetoIntegrador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baependi.projetoIntegrador.models.Categoria;
import com.baependi.projetoIntegrador.repository.RepositorioCategoria;


@Service
public class ServiceCategoria {

	@Autowired
	RepositorioCategoria repositorioC;
	

	public Optional<Categoria> alterarCategoria(Categoria alterarCategoria) {
		return repositorioC.findById(alterarCategoria.getIdCategoria()).map(categoriaExistente -> {
			categoriaExistente.setTipoProduto(alterarCategoria.getTipoProduto());
			return Optional.ofNullable(repositorioC.save(alterarCategoria));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
