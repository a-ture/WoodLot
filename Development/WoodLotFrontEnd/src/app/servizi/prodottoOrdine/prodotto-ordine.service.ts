import {Injectable} from '@angular/core';
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";

@Injectable({
  providedIn: 'root'
})
export class ProdottoOrdineService {

  constructor() {
  }

  // restituisce tutti i prodotti ordine che devono essere revisionati dal responsabile ordine
  getProdottiDaRevisionare() {
    return [

    ]
  }
}
