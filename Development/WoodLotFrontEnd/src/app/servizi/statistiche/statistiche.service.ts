import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
//TODO bisogna effettuare il collegamento con il back-end
export class StatisticheService {

  constructor() {
  }

  // restituisce le statistiche per la pagina diventa un contadino e per il profilo responsabile catalogo
  public getStatistiche() {
    return ["452525", "87678", "452", "4"]
  }

  //restituisce le statistiche per la pagina del contadino
  public getStatischeContadino() {
    return ["45", "56", "33"]
  }
}
