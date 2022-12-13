import {Ordine} from "../ordine/ordine";

export class Utente {
  public nome : String
  public cognome : String
  public ordiniList : Ordine[]

  constructor(nome:String, cognome:String, ordiniList:Ordine[]) {
    this.nome = nome
    this.cognome = cognome
    this.ordiniList = ordiniList
  }
}
