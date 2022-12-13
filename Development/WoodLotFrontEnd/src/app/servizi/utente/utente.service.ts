import { Injectable } from '@angular/core';
import {Utente} from "../../entita/utente/utente";
import {Ordine} from "../../entita/ordine/ordine";

import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";
// TODO aggiungere collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  constructor() { }

  public getUtente(){
    return new Utente("Mario","Rossi", [
      new Ordine (3, [new ProdottoOrdine(13.00, 34, 45,
        "", new Date(), "fiore"),
        ],233, new Date()),
    ] )
  }

  public getStatisticheUtente(){
    return ["34","45","65"]
  }

}
