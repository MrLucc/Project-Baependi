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
	private @NotNull float precoDoProduto;
	private @NotBlank String descricaoDoProduto;
	private @NotBlank String autoreDoProduto;
	private @NotBlank @Size(min = 1) String tipoDeProduto;
	
	@ManyToOne
	@JoinColumn(name = "categoriaProdutos_id")
	@JsonIgnoreProperties({"categoriaProdutos"})
	private Categoria codigoCategoria;
	
	@ManyToOne
	@JoinColumn(name = "comprador_id")
	@JsonIgnoreProperties({"listaDeCompradores"})
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
		return precoDoProduto;
	}

	public void setPrecoDoProduto(float precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}

	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}

	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}

	public String getAutoreDoProduto() {
		return autoreDoProduto;
	}

	public void setAutoreDoProduto(String autoreDoProduto) {
		this.autoreDoProduto = autoreDoProduto;
	}

	public String getTipoDeProduto() {
		return tipoDeProduto;
	}

	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
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
