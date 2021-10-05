import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContatoComponent } from './contato/contato.component';
import { InicioComponent } from './inicio/inicio.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { EntrarComponent } from './entrar/entrar.component';



const routes: Routes = [
  {path:'', redirectTo: 'inicio', pathMatch: 'full'},

  {path:'inicio', component: InicioComponent},
  {path:'contato', component: ContatoComponent},
  {path:'sobre-nos', component: SobreNosComponent},
  {path:'cadastrar', component: CadastrarComponent},
  {path:'entrar', component: EntrarComponent},


  {path: 'menu', component: MenuComponent},
  {path: 'rodape', component: RodapeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
