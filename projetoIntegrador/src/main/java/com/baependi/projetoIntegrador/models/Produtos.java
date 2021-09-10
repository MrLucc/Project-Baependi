package com.baependi.projetoIntegrador.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
public class Produtos {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;
	private @NotBlank @Size(min = 3, max = 255) String nomeDoProduto;
	private @NotNull float precoDoProduto;
	private @NotBlank String descricaoDoProduto;
	private @NotBlank String autoreDoProduto;
	private @NotBlank @Size(min = 1, max = 75) String tipoDeProduto;

	/*@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "produtos_id_produto")
	private List<Categoria> categorias = new ArrayList<>();*/



}
