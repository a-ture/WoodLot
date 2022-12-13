import {Albero} from "../albero/albero";
import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Ordine {
  public prodottoOrdineList : ProdottoOrdine[]
  public codice : number
  public prezzo : number
  public dataAcquisto : Date

  constructor(codice:number, prodottoOrdineList:ProdottoOrdine[], prezzo:number, dataAcquisto:Date) {
    this.codice = codice
    this.prezzo = prezzo
    this.prodottoOrdineList = prodottoOrdineList
    this.dataAcquisto = dataAcquisto
  }

}
