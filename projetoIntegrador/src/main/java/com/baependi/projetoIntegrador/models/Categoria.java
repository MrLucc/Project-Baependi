package com.baependi.projetoIntegrador.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")

public class Categoria {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCategoria;
	private @NotBlank String tipoProduto;
	private boolean artesanal;
	private @NotBlank String tipoMaterial;

	@OneToMany(mappedBy = "codigoCategoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "codigoCategoria" })
	private List<Produtos> categoriaProdutos = new ArrayList<>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public boolean isArtesanal() {
		return artesanal;
	}

	public void setArtesanal(boolean artesanal) {
		this.artesanal = artesanal;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public List<Produtos> getCategoriaProdutos() {
		return categoriaProdutos;
	}

	public void setCategoriaProdutos(List<Produtos> categoriaProdutos) {
		this.categoriaProdutos = categoriaProdutos;
	}

}
