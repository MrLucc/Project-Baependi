import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import Swal from 'sweetalert2';
import { UsuarioEspelho } from '../models/UsuarioEspelho';
import { AutService } from '../service/aut.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  usuarioEspelho: UsuarioEspelho = new UsuarioEspelho

  constructor(
    private router: Router,
    private auth: AutService       
    ) { }

  ngOnInit() {
  }

  entrar() {
    this.auth.entrar(this.usuarioEspelho).subscribe((resp: UsuarioEspelho)=>{
      this.usuarioEspelho = resp

      environment.token = this.usuarioEspelho.token
      environment.nome = this.usuarioEspelho.nomeUsuario
      environment.foto = this.usuarioEspelho.foto
      environment.id = this.usuarioEspelho.idUsuario

      console.log(environment.token)
      console.log(environment.nome)
      console.log(environment.foto)
      console.log(environment.id)

      this.router.navigate(["/inicio"])
    },erroLocal =>{
      if(erroLocal.status == 400){
        const Toast = Swal.mixin({
        toast: true,
        position: 'center',
        showConfirmButton: false,
        timer: 2700,
        timerProgressBar: true,
        didOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer)
          toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
      })
      Toast.fire({
        icon: 'error',
        title: 'Email ou senha incorretos! Tente um novo login'
        
      })
      }
    })
  }

}
