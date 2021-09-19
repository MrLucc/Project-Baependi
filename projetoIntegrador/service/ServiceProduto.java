package com.baependi.projetoIntegrador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baependi.projetoIntegrador.models.Produtos;
import com.baependi.projetoIntegrador.repository.RepositorioProdutos;

@Service
public class ServiceProduto {

	@Autowired
	private RepositorioProdutos repositoryP;

	/**
	 * Metódo usado para alterar um produto. O mesmo retorna um Optional com os
	 * atributos de produto, caso correto ou um Optional.empty() caso alguma
	 * informação digitada não exista.
	 * 
	 * @param produtoParaAlterar com os atributos de produto
	 * @return Optional com as informações do produto alteradas
	 * @since 1.5
	 * @author Equipe 6
	 */

	public Optional<Produtos> alterarProduto(Produtos produtoParaAlterar) {
		return repositoryP.findById(produtoParaAlterar.getIdProduto()).map(produtoExistente -> {
			produtoExistente.setNomeDoProduto(produtoParaAlterar.getNomeDoProduto());
			produtoExistente.setPrecoDoProduto(produtoParaAlterar.getPrecoDoProduto());
			produtoExistente.setDescricaoDoProduto(produtoParaAlterar.getDescricaoDoProduto());
			produtoExistente.setAutoreDoProduto(produtoParaAlterar.getAutoreDoProduto());
			produtoExistente.setTipoDeProduto(produtoParaAlterar.getTipoDeProduto());
			return Optional.ofNullable(repositoryP.save(produtoExistente));
		}).orElseGet(() -> {
			return Optional.empty();// Caso alguma informação do produto não exista.
		});
	}

}
