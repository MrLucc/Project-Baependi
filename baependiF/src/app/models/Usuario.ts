import { Produtos } from "./Produtos"

export class Usuario{
  public idUsuario: number
  public nomeUsuario: string
  public cpf: string
  public estado: string
  public cidade: string
  public endereco: string
  public cep: string
  public email: string
  public senha: string
  public foto: string
  public tipoUsuario: string;
  public listaDeProdutos: Produtos[]
}
