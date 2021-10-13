import { Component, OnInit } from '@angular/core';
import { Produtos } from '../models/Produtos';

@Component({
  selector: 'app-todosprodutos',
  templateUrl: './todosprodutos.component.html',
  styleUrls: ['./todosprodutos.component.css']
})
export class TodosprodutosComponent implements OnInit {

  produto: Produtos = new Produtos()
  listaProduto: Produtos[]


  constructor() { }

  ngOnInit(): void {
  }

}
