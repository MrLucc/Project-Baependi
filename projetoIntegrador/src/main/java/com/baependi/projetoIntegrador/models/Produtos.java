package com.baependi.projetoIntegrador.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_produtos")

public class Produtos {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;
	private @NotBlank @Size(min = 3, max = 255) String nomeDoProduto;
	private @NotNull float precoProduto;
	private @NotBlank String descricaoProduto;
	private @NotBlank String autoreProduto;

	@ManyToOne
	@JoinColumn(name = "categoriaProdutos_id")
	@JsonIgnoreProperties({ "categoriaProdutos" })
	private Categoria codigoCategoria;

	@ManyToOne
	@JoinColumn(name = "comprador_id")
	@JsonIgnoreProperties({ "listaDeProdutos" })
	private Usuario comprador;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public float getPrecoDoProduto() {
		return precoProduto;
	}

	public void setPrecoDoProduto(float precoDoProduto) {
		this.precoProduto = precoDoProduto;
	}

	public String getDescricaoDoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoProduto = descricaoDoProduto;
	}

	public String getAutoreDoProduto() {
		return autoreProduto;
	}

	public void setAutoreDoProduto(String autoreDoProduto) {
		this.autoreProduto = autoreDoProduto;
	}

	public Categoria getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Categoria codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

}
