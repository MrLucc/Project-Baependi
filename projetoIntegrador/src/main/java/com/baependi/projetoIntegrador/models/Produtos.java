package com.baependi.projetoIntegrador.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;
	// DEFINIR AQUI A FOREIGN KEY FK_CATEGORIA
	// DEFINIR AQUI A FOREIGN KEY FK_USUÁRIO
	private @NotBlank @Size(min = 3, max = 255) String nomeDoProduto;
	private @NotNull float precoDoProduto;
	private @NotBlank String descricaoDoProduto;
	private @NotBlank String autoreDoProduto;
	private @NotBlank @Size(min = 1, max = 75) String tipoDeProduto;

	@OneToMany(mappedBy = "itens", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "itens" })
	private List<Categoria> listaDeCompradores = new ArrayList<>();

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

	public List<Categoria> getListaDeCompradores() {
		return listaDeCompradores;
	}

	public void setListaDeCompradores(List<Categoria> listaDeCompradores) {
		this.listaDeCompradores = listaDeCompradores;
	}

}
