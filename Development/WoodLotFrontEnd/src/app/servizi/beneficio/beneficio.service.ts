import {Injectable} from '@angular/core';
import {Beneficio} from "../../entita/beneficio/beneficio";

@Injectable({
  providedIn: 'root'
})
export class BeneficioService {

  constructor() {
  }

  // restituisce tutti i benefici presenti nel DB
  public getBenefici() {
    return [
      new Beneficio("Sicurezza alimentare", "descrizione"),
      new Beneficio("Sviluppo economico", "descrizione"),
      new Beneficio("Assorbimento di anidride carbonica", "descrizione"),
      new Beneficio("Protezione ambientale", "descrizione"),
    ]
  }
}
