import { Categoria } from "./Categoria"
import { Usuario } from "./Usuario"

export class Produtos {
  public idProduto: number
  public nomeProduto: string
  public precoProduto: string
  public descricaoProduto: string
  public autoreProduto: string
  public tipoMaterial: string
  public artesanal: string
  public codigoCategoria: Categoria
  public comprador: Usuario
  public fotoProduto: string
}
