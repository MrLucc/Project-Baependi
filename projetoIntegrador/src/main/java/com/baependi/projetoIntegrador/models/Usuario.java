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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
	private @NotBlank String nomeUsuario;
	private @NotBlank @Email String email;
	private @NotBlank @Size(min = 6, max = 10) String senha;

	@OneToMany(mappedBy = "comprador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "comprador" })
	private List<Categoria> listaDeItens = new ArrayList<>();

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nomeUsuario;
	}

	public void setNome(String nome) {
		this.nomeUsuario = nome;
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public List<Categoria> getListaDeItens() {
		return listaDeItens;
	}

	public void setListaDeItens(List<Categoria> listaDeItens) {
		this.listaDeItens = listaDeItens;
	}

}
