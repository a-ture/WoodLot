import {Ordine} from "../ordine/ordine";
import {UtenteRegistrato} from "../utenteRegistrato/utente-registrato";


export class Utente extends UtenteRegistrato {

  public nome: String
  public cognome: String
  public listaOrdini: Ordine[]
  public id ?: number


  constructor(nome: String, cognome: String, listaOrdini: Ordine[], email: String, password: String, id?: number) {
    super(email, password)
    this.nome = nome
    this.cognome = cognome
    this.listaOrdini = listaOrdini
    this.email = email
    this.password = password
    this.id = id
  }
}
