import {Injectable} from '@angular/core';
import {Ordine} from "../../entita/ordine/ordine";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";

@Injectable({
  providedIn: 'root'
})
export class OrdineService {

  constructor() {
  }

  // questo metodo restituisce tutti gli ordini presenti nel DB
  public getOrdini() {
    return [
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4),new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4),new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)), new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)), new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)), new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)), new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
      new Ordine(1, [new ProdottoOrdine(3, 3, 34, new Date(), "Assegnato", "castagno",
        "Perù", 4)], 543, new Date(333)),
    ]
  }
}
