import {Utente} from "../utente/utente";
import {Albero} from "../albero/albero";
import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Foresta {
  public nome: String
  public proprietario: Utente
  public alberi: Array<ProdottoOrdine>

  constructor(nome: String, proprietario: Utente, alberi: Array<ProdottoOrdine>) {
    this.nome = nome
    this.proprietario = proprietario
    this.alberi = alberi
  }
}
