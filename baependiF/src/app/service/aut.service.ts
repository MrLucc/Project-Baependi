import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../models/Usuario';
import { UsuarioEspelho } from '../models/UsuarioEspelho';

@Injectable({
  providedIn: 'root'
})
export class AutService {

  constructor(
    private http: HttpClient
  ) { }

  entrar(usuarioEspelho: UsuarioEspelho): Observable<UsuarioEspelho> {
    return this.http.put<UsuarioEspelho>('https://baependi.herokuapp.com/baependi/usuario/login', usuarioEspelho)
  }

  cadastrar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>('https://baependi.herokuapp.com/baependi/usuario/cadastrar', usuario)
  }

  logado() {
    let ok: boolean = false

    if(environment.token != "") {
      ok = true
    }
    return ok
  }


  nome() {
    let ok: string = environment.nome


    return ok
  }
}
