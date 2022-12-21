import {Ordine} from "../ordine/ordine";


export class Utente {
  public nome: String
  public cognome: String
  public listaOrdini: Ordine[]


  constructor(nome: String, cognome: String, listaOrdini: Ordine[]) {
    this.nome = nome
    this.cognome = cognome
    this.listaOrdini = listaOrdini
  }
}
