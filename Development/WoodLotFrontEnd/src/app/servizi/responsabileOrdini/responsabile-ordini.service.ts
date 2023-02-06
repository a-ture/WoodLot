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
    let utente !: ResponsabileOrdini
    const storedUtente = sessionStorage.getItem('responsabileOrdini');
    if (storedUtente) {
      utente = JSON.parse(storedUtente);
    }
    return utente;
  }

}
