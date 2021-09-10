package com.baependi.projetoIntegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baependi.projetoIntegrador.models.Produtos;

@Repository
public interface RepositorioProdutos extends JpaRepository<Produtos, Long> {


	@Query("from Produtos where nomeDoProduto like concat('%',?1,'%')")
	public List<Produtos> buscarPorNomeProduto (String nomdeDoProduto);

	public List <Produtos> findAllByNomeDoProdutoContainingIgnoreCase (String nomeDoProduto);

}
