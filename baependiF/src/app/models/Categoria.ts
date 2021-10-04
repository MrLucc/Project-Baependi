import { Produtos } from "./Produtos"

export class Categoria {
  public idCategoria: number
  public tipoProduto: string
  public artesanal: boolean
  public tipoMaterial: string
  public categoriaProdutos: Produtos[]
}
