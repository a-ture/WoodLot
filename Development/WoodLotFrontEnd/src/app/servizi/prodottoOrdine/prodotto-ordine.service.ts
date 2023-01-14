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
      new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "mandorlo",
        "Perù", 4),
      new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4),
      new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "pesco",
        "Perù", 4)
    ]
  }
}
