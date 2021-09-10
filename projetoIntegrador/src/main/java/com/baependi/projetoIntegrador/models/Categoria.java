package com.baependi.projetoIntegrador.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_categoria")
@Getter
@Setter
public class Categoria {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCategoria;
	private @NotBlank String tipoProduto;
	private boolean revendido;
	private @NotBlank String tipoMaterial;

	/*@ManyToOne
	@JoinColumn(name = "produtos_id_produto")
	private Produtos produtos;

	@ManyToOne
	@JoinColumn(name = "usuario_id_usuario")
	private Usuario usuario;*/

}
