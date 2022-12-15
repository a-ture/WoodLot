import { Injectable } from '@angular/core';
import {Paese} from "../../entita/paese/paese";
//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class PaeseService {

  constructor() { }

  //restituisce tutti i paesi presenti nel DB
  public getPaesi(){
    return [
      new Paese("Italia", "descrizione"),
      new Paese("Argentina", "descrizione"),
      new Paese("Perù", "descrizione"),
      new Paese("Guatemala", "descrizione")
    ]
  }
}
