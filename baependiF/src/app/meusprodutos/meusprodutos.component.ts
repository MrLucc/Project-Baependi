import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produtos } from '../models/Produtos';
import { Usuario } from '../models/Usuario';
import { AutService } from '../service/aut.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-meusprodutos',
  templateUrl: './meusprodutos.component.html',
  styleUrls: ['./meusprodutos.component.css']
})
export class MeusprodutosComponent implements OnInit {

  usuario: Usuario = new Usuario
  produtos: Produtos = new Produtos
  listaDeProdutos: Produtos[]
  idUser: number



  constructor(
    private auth: AutService,
    private produtosService: ProdutoService,
    private router: Router,
    private routerAtiva: ActivatedRoute
  ) { }

  ngOnInit(){


    this.routerAtiva.snapshot.params['id']
    this.findAllProdutos()

  }



  findAllProdutos() {
    this.produtosService.getAllProdutos().subscribe((resp: Produtos[])=> {
      this.listaDeProdutos = resp
    })
  }


  findByIdProdutos(id: number) {
    this.produtosService.getByIdProdutos(id).subscribe((resp: Produtos)=> {
      this.produtos = resp
    })
  }

  findByIdUser() {
    this.auth.getByIdUser(this.idUser).subscribe((resp: Usuario)=> {
      this.usuario = resp;
    })
  }
}
