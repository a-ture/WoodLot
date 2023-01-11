import {Injectable} from '@angular/core';
import {Contadino} from "../../entita/contadino/contadino";

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
}
