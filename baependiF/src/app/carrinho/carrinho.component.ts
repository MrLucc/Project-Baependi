import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import {  Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']

})
export class CarrinhoComponent implements OnInit {

  constructor(
    private router:Router
  ) { }

  ngOnInit(): void {
    if(environment.token == ""){
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'Precisa estar logado para usar o carinho',
        showConfirmButton: false,
        timer: 3000
      })
      this.router.navigate(["/inicio"])
    }
  }

}
