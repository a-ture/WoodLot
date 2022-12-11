import { Injectable } from '@angular/core';
import {UsoLocale} from "../../entities/usoLocale/uso-locale";
//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class UsoLocaleService {

  constructor() { }

  public getUsiLocali(){
    return[
      new UsoLocale("usoLocale1","desccrizione"),
      new UsoLocale("usoLocale2","desccrizione"),
      new UsoLocale("usoLocale3","desccrizione"),
      new UsoLocale("usoLocale4","desccrizione"),
      new UsoLocale("usoLocale5","desccrizione"),
      new UsoLocale("usoLocale6","desccrizione"),
      new UsoLocale("usoLocale7","desccrizione"),
    ]
  }
}
