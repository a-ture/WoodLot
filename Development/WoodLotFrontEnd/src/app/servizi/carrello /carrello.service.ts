import { Injectable } from '@angular/core';
import {ProdottoCarrello} from "../../entita/prodottoCarrello/prodotto-carrello";

@Injectable({
  providedIn: 'root'
})
export class CarrelloService {

  constructor() { }

  public getCarrello(){
    return [
      new ProdottoCarrello(1, "mandorlo", false, 45),
      new ProdottoCarrello(3, "castagno", false, 90)
    ]
  }
}
