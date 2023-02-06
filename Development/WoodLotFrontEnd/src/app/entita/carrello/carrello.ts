import {Utente} from "../utente/utente";
import {ProdottoCarrello} from "../prodottoCarrello/prodotto-carrello";

export class Carrello {
  public id: number
  public utente: Utente
  public prodottiCarrello: Array<ProdottoCarrello>
  public totale: number

  constructor(utente: Utente) {
    this.prodottiCarrello = new Array<ProdottoCarrello>()
    this.totale = 0
    this.utente = utente
    this.id = 0
  }
}
