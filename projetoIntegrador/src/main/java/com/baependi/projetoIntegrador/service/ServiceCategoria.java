package com.baependi.projetoIntegrador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baependi.projetoIntegrador.models.Categoria;
import com.baependi.projetoIntegrador.models.Produtos;
import com.baependi.projetoIntegrador.repository.RepositorioCategoria;
import com.baependi.projetoIntegrador.repository.RepositorioProdutos;

@Service
public class ServiceCategoria {

	@Autowired RepositorioCategoria repositorioC;
	@Autowired RepositorioProdutos repositorioP;
	
	public Optional<?> criaCategoria(Categoria novaCategoria){
		Optional<Produtos> objetoCategoria = repositorioP.findById(novaCategoria.getCodigoProduto().getIdProduto());
		return repositorioC.findById(novaCategoria.getIdCategoria()).map(categoriaExistente -> {  
			if(objetoCategoria.isPresent()){
			//novaCategoria.setIdCategoria(categoriaExistente);
				novaCategoria.setCodigoProduto(objetoCategoria.get());
				return Optional.ofNullable(repositorioC.save(novaCategoria));
			}else {
				return Optional.empty();
			}
		}).orElseGet(() ->{
			return Optional.empty();
		});
	}
	
	public Optional<Categoria> alterarCategoria(Categoria alterarCategoria){
		return repositorioC.findById(alterarCategoria.getIdCategoria()).map(categoriaExistente ->{
			categoriaExistente.setTipoProduto(alterarCategoria.getTipoProduto());
			categoriaExistente.setRevendido(alterarCategoria.isRevendido());
			categoriaExistente.setTipoMaterial(alterarCategoria.getTipoMaterial());
			return Optional.ofNullable(repositorioC.save(alterarCategoria));
		}).orElseGet(()->{
			return Optional.empty();
		});
	}
}
 