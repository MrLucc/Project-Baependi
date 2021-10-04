import { Categoria } from "./Categoria"
import { Usuario } from "./Usuario"

export class Produtos {
  public idProduto: number
  public nomeProduto: string
  public precoProduto: number
  public descricaoProduto: string
  public autoreProduto: string
  public codigoCategoria: Categoria
  public comprador: Usuario
}
