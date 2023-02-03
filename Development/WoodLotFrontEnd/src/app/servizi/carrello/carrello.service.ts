import { Injectable } from '@angular/core';
import {ProdottoCarrello} from "../../entita/prodottoCarrello/prodotto-carrello";
//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class CarrelloService {

  constructor() { }

  // restituisce il carrello di un utente
  public getCarrello(){
    return [

      new ProdottoCarrello(3, "castagno", false, 90)
    ]
  }
}

