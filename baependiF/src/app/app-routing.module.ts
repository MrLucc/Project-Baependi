import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContatoComponent } from './contato/contato.component';
import { InicioComponent } from './inicio/inicio.component';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { SobreNosComponent } from './sobre-nos/sobre-nos.component';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { EntrarComponent } from './entrar/entrar.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoComponent } from './produto/produto.component';
import { TodosprodutosComponent } from './todosprodutos/todosprodutos.component';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { ODSComponent } from './ods/ods.component';
import { DadosComponent } from './dados/dados.component';
import { InformacoesComponent } from './informacoes/informacoes.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { PerfilComponent } from './perfil/perfil.component';
import { MeusprodutosComponent } from './meusprodutos/meusprodutos.component';



const routes: Routes = [
  {path:'', redirectTo: 'inicio', pathMatch: 'full'},

  {path:'inicio', component: InicioComponent},
  {path:'contato', component: ContatoComponent},
  {path:'sobre-nos', component: SobreNosComponent},
  {path:'cadastrar', component: CadastrarComponent},
  {path:'entrar', component: EntrarComponent},
  {path: 'produto', component: ProdutoComponent},
  {path: 'todosprodutos', component: TodosprodutosComponent },
  {path: 'carrinho', component: CarrinhoComponent},
  {path: 'ods', component: ODSComponent},
  {path: 'dados', component: DadosComponent},
  {path: 'informacoes', component: InformacoesComponent},
  {path: 'perfil', component: PerfilComponent},
  {path: 'meusprodutos', component: MeusprodutosComponent},




  {path: 'menu', component: MenuComponent},
  {path: 'rodape', component: RodapeComponent},
  {path: 'categoria', component: CategoriaComponent},
  {path: 'categoria-edit/:id', component: CategoriaEditComponent},
  {path: 'categoria-delete/:id', component: CategoriaDeleteComponent},
  {path:'produto-edit/:id', component: ProdutoEditComponent},
  {path: 'produto-delete/:id', component: ProdutoDeleteComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
