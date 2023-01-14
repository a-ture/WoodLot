import {Injectable} from '@angular/core';
import {ResponsabileOrdini} from "../../entita/responsabileOrdini/responsabile-ordini";

@Injectable({
  providedIn: 'root'
})
export class ResponsabileOrdiniService {

  constructor() {
  }

  // restituisce un responsabile ordini
  public getResponsabileOrdini() {
    return new ResponsabileOrdini("Brici", "Ture")
  }

}
