import {Utente} from "../utente/utente";
import {Albero} from "../albero/albero";
import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Foresta {

  public nome: String
  public proprietario: Utente
  public alberi: Array<ProdottoOrdine>
  public tipologia: String


  constructor(nome: String, proprietario: Utente, alberi: Array<ProdottoOrdine>, tipologia: String) {
    this.nome = nome
    this.proprietario = proprietario
    this.alberi = alberi
    this.tipologia = tipologia

  }
}
