import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Contadino {

  public nome: String
  public cognome: String
  public listaAlberi: ProdottoOrdine[]
  public id: number

  constructor(nome: String, cognome: String, listaAlberi: ProdottoOrdine[], id: number) {
    this.nome = nome
    this.cognome = cognome
    this.listaAlberi = listaAlberi
    this.id = id
  }
}
