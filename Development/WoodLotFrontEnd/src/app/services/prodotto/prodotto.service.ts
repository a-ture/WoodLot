import { Injectable } from '@angular/core';
import {Albero} from "../../entities/albero/albero";

@Injectable({
  providedIn: 'root'
})
export class ProdottoService {

  constructor() {}

  public getProdotto(){
    return [
      new Albero(13.00, 34, "castagno"),
      new Albero(12.00, 434, "mandorlo"),
      new Albero(34.00, 434, "melograno"),
      new Albero(12.50, 43, "vite"),
    ]
  }
}
