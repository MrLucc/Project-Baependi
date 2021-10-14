import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { Produtos } from '../models/Produtos';
import { Usuario } from '../models/Usuario';
import { AutService } from '../service/aut.service';
import { ProdutoService } from '../service/produto.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  usuario: Usuario = new Usuario
  produto: Produtos = new Produtos
  foto: string
  nomeUsuario: string
  email: string
  nomePessoal: string
  endereco: string
  cidade: string
  estado: string
  cep: string
  userId: number
  confirmarSenha: string
  id : number


  constructor(
    private auth: AutService,
    private router: Router,
    private routerAtivo: ActivatedRoute,
    private produtoService: ProdutoService

  ) { }

  ngOnInit() {


    this.foto = environment.foto
    this.nomeUsuario = environment.nomeUsuario
    this.email = environment.email
    this.nomePessoal = environment.nomePessoal
    this.endereco = environment.endereco
    this.cidade = environment.cidade
    this.estado = environment.estado
    this.cep = environment.cep

    this.userId= this.routerAtivo.snapshot.params['id']
    this.findByIdUser(this.userId)



  }


  findByIdUser(id: number) {
    this.auth.getByIdUser(id).subscribe((resp: Usuario)=> {
      this.usuario = resp

    })
  }


  confirmSenha(event: any) {
    this.confirmarSenha = event.target.value

  }




  atualizar() {



      if(this.usuario.senha != this.confirmarSenha) {
          alert('As senhas estão incorretas!')
      } else {
          this.auth.atualizar(this.usuario).subscribe((resp: Usuario)=> {
            this.usuario = resp
            this.router.navigate(['/inicio'])
            alert('Usuário atualizado, faça o login novamente!')
            environment.token=''
            environment.nomeUsuario=''
            environment.foto=''
            environment.id= 0
            this.router.navigate(['/login'])
          })
      }

}
}
