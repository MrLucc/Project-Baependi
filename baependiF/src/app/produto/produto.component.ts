import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../models/Categoria';
import { Produtos } from '../models/Produtos';
import { Usuario } from '../models/Usuario';
import { CategoriaService } from '../service/categoria.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {


    produto: Produtos = new Produtos()
    categoria: Categoria = new Categoria()
    usuario: Usuario = new Usuario
    id: number
    listaCategoria: Categoria[]
    idUser = environment.id
    nomeMaterial: string



    constructor(
      private router:Router,
      private categoriaService: CategoriaService,
      private produtoService: ProdutoService,

      ){}


  ngOnInit(){
    window.scroll(0,0)

    if(environment.token == ""){
      this.router.navigate(["/entrar"])
    }

    this.getAllCategorias()


  }

    getAllCategorias(){
      this.categoriaService.getAllCategoria().subscribe((resp: Categoria[])=>{
          this.listaCategoria = resp
      })
    }

    findByIdCategoria(){
      this.categoriaService.getByIdCategoria(this.id).subscribe((resp: Categoria)=>{
        this.categoria = resp
      })
    }

    findByIdProduto(){
      this.produtoService.getByIdProdutos(this.id).subscribe((resp: Produtos)=>{
        this.produto = resp
      })
    }

    findByNomeTipoMaterial() {
      this.produtoService.getTipoMaterial(this.nomeMaterial).subscribe((resp: Produtos)=> {
        this.produto= resp
      })
    }

    teste(){
      console.log("produto" + JSON.stringify(this.produto))
    }

    test(){
      console.log("categoria" + JSON.stringify(this.categoria))
    }


    cadastrar(){
      this.categoria.idCategoria = this.id
      this.produto.codigoCategoria = this.categoria
      this.produto.tipoMaterial = this.nomeMaterial

      this.usuario.idUsuario = this.idUser

      this.produtoService.postProdutos(this.produto).subscribe((resp: Produtos)=>{
        this.produto = resp
        alert("Produto cadastrado com sucesso!")
        this.produto = new Produtos()
      })
    }

}
