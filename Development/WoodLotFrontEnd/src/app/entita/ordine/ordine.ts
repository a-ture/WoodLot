import {Albero} from "../albero/albero";
import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Ordine {
  public listaProdottiOrdine : ProdottoOrdine[]
  public codice : number
  public totale : number
  public dataAcquisto : Date

  constructor(codice:number, listaProdottoOrdini:ProdottoOrdine[], totale:number, dataAcquisto:Date) {
    this.codice = codice
    this.totale = totale
    this.listaProdottiOrdine = listaProdottoOrdini
    this.dataAcquisto = dataAcquisto
  }

}
