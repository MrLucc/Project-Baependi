package com.baependi.projetoIntegrador.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name = "tb_categoria")

public class Categoria {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCategoria;
	private @NotBlank String tipoProduto;
	private boolean revendido;
	private @NotBlank String tipoMaterial;
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

	/*@ManyToOne
	@JoinColumn(name = "produtos_id_produto")
	private Produtos produtos;

	@ManyToOne
	@JoinColumn(name = "usuario_id_usuario")
	private Usuario usuario;*/

	
}
