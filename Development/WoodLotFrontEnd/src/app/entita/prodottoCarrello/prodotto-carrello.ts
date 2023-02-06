import {Albero} from "../albero/albero";
import {Carrello} from "../carrello/carrello";

export class ProdottoCarrello {
  public albero: Albero
  public id: number


  constructor(albero: Albero, carrello: Carrello) {
    this.id = 0
    this.albero = albero

  }
}
