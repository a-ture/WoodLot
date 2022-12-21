import {Injectable} from '@angular/core';
import {Utente} from "../../entita/utente/utente";
import {Ordine} from "../../entita/ordine/ordine";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";


// TODO aggiungere collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  constructor() {
  }

  // restituisce un utente
  public getUtente() {
    return new Utente("Mario", "Rossi", [
      new Ordine(3, [new ProdottoOrdine(13.00, 3, 45, new Date(), "fiore",
        "castagno", "Coordinate Geografiche", 45
      ),
        new ProdottoOrdine(13.00, 4, 45, new Date(), "fiore", "mandorlo",
          "Coordinate Geografiche", 59)
      ], 233, new Date()),

      new Ordine(1, [new ProdottoOrdine(13.00, 34, 45,
        new Date(), "fiore", "castagno", "Coordinate Geografiche",
        59),
        new ProdottoOrdine(13.00, 34, 45,
          new Date(), "fiore", "mandorlo", "Coordinate Geografiche", 59)
      ], 233, new Date()),

      new Ordine(2, [new ProdottoOrdine(13.00, 34, 45,
        new Date(), "fiore", "castagno", "Coordinate Geografiche",
        59),
        new ProdottoOrdine(13.00, 34, 45,
          new Date(), "fiore", "mandorlo", "Coordinate Geografiche", 59)
      ], 233, new Date()),

      new Ordine(4, [new ProdottoOrdine(13.00, 34, 45,
        new Date(), "fiore", "castagno", "Coordinate Geografiche",
        59),
        new ProdottoOrdine(13.00, 34, 45,
          new Date(), "fiore", "mandorlo", "Coordinate Geografiche"
          , 59)
      ], 233, new Date()),
    ])
  }


//restituisce le statistiche relative ad un utente
  public getStatisticheUtente() {
    return ["34", "45", "65"]
  }

  //controlla se un utente è loggato, restiuisce l'utente se è presente in sessione, null altrimenti
  public eAttivo() {
    return null
  }
}
