package com.baependi.projetoIntegrador.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name = "tb_usuario")
public class Usuario {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @NotBlank String nomeUsuario;
	private @NotBlank @Email String email;
	private @NotBlank @Size(min = 6, max = 10) String senha;
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "usuario_id_usuario")
	private List<Produtos> produtos = new ArrayList<>();


	@ManyToOne
	@JoinColumn(name = "categoria_id_categoria")
	private Categoria categoria;*/

	
}
