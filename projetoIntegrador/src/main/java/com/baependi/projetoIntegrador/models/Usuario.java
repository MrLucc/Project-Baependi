package com.baependi.projetoIntegrador.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @NotBlank String nomeUsuario;
	private @NotBlank @Email String email;
	private @NotBlank @Size(min = 6, max = 10) String senha;

	/*@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "usuario_id_usuario")
	private List<Produtos> produtos = new ArrayList<>();


	@ManyToOne
	@JoinColumn(name = "categoria_id_categoria")
	private Categoria categoria;*/

}
