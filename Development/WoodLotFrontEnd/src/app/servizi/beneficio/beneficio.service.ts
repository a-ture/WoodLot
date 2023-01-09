import { Injectable } from '@angular/core';
import {Beneficio} from "../../entita/beneficio/beneficio";

@Injectable({
  providedIn: 'root'
})
export class BeneficioService {

  constructor() { }

  // restituisce tutti i benefici presenti nel DB
  public getBenefici(){
    return[
      new Beneficio("beneficio1", "descrizione"),
      new Beneficio("beneficio2", "descrizione"),
      new Beneficio("beneficio3", "descrizione"),
      new Beneficio("beneficio4", "descrizione"),
      new Beneficio("beneficio5", "descrizione")
    ]
  }
}
