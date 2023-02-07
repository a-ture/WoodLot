import {Albero} from "../albero/albero";
import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Ordine {
  public prodottiOrdine : Array<ProdottoOrdine>
  public id : number
  public totale : number
  public dataOrdine : Date

  constructor(id:number, listaProdottoOrdini:Array<ProdottoOrdine>, totale:number, dataAcquisto:Date) {
    this.id = id
    this.totale = totale
    this.prodottiOrdine = listaProdottoOrdini
    this.dataOrdine = dataAcquisto
  }

}
