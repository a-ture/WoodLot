import {Injectable} from '@angular/core';
import {Contadino} from "../../entita/contadino/contadino";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";

@Injectable({
  providedIn: 'root'
})
export class ContadinoService {

  constructor() {
  }

  // restituisce un contadino
  public getContadino() {
    return new Contadino("Briciola", "Bricioloso")
  }

  public getAlberiContadino() {
    return [
      new ProdottoOrdine(13.00, 3, 45, new Date(), "fiore",
        "castagno", "Coordinate Geografiche", 45),
      new ProdottoOrdine(13.00, 3, 45, new Date(), "frutto",
        "castagno", "Coordinate Geografiche", 45),
      new ProdottoOrdine(13.00, 3, 45, new Date(), "fiore",
        "castagno", "Coordinate Geografiche", 45),
      new ProdottoOrdine(13.00, 4, 45, new Date(), "bocciolo", "mandorlo",
        "Coordinate Geografiche", 59),
      new ProdottoOrdine(13.00, 34, 45,
        new Date(), "piantato", "castagno", "Coordinate Geografiche",
        59),
      new ProdottoOrdine(13.00, 34, 45,
        new Date(), "dormineza", "mandorlo", "Coordinate Geografiche", 59)
    ]
  }
}
