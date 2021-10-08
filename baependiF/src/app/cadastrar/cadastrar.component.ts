import { AutService } from "./../service/aut.service"
import { Component, OnInit } from '@angular/core';
import { Usuario } from '../models/Usuario';
import { Router } from "@angular/router";

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  usuario: Usuario = new Usuario
  confirmarSenha: string
  tipoUser: string
  confrimarEmail: string

  constructor(
    private AutService: AutService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }

  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value
  }

  tipoUsuario(event: any){
    this.tipoUser = event.target.value
  }

  confirmEmail(event: any) {
    this.confrimarEmail = event.target.value
  }

  test(){
    console.log("usuario" + JSON.stringify(this.usuario))
  }

  cadastrar() {
    

    if(this.usuario.senha != this.confirmarSenha || this.usuario.email != this.confrimarEmail){
      alert("Senha ou email estão incorretos.")

    }else{
      this.AutService.cadastrar(this.usuario).subscribe((resp: Usuario) => {
        this.usuario = resp
        this.router.navigate(["/inicio"])
        alert("Usuário cadastrado com sucesso!")
      })
    }

  }
}
