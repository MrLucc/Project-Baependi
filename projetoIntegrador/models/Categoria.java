package com.baependi.projetoIntegrador.models;

import javax.persistence.*;
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
	@JoinColumn(name = "categoriaProduto_id")
	@JsonIgnoreProperties({"categoriaProduto"})
	private Produtos codigoProduto;

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

}
