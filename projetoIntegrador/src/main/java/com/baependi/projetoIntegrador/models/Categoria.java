package com.baependi.projetoIntegrador.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCategoria;
	private @NotBlank String tipoProduto;
	private boolean revendido;
	private @NotBlank String tipoMaterial;

	@ManyToOne
	@JoinColumn(name = "id_comprador")
	@JsonIgnoreProperties({ "listaDeItens" })
	private Usuario comprador;

	@ManyToOne
	@JoinColumn(name = "id_itens")
	@JsonIgnoreProperties({ "listaDeCompradores" })
	private Produtos itens;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public boolean isRevendido() {
		return revendido;
	}

	public void setRevendido(boolean revendido) {
		this.revendido = revendido;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

	public Produtos getItens() {
		return itens;
	}

	public void setItens(Produtos itens) {
		this.itens = itens;
	}

}
