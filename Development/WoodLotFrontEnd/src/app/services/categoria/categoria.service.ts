import { Injectable } from '@angular/core';
import {Categoria} from "../../entities/categoria/categoria";

@Injectable({
  providedIn: 'root'
})
//TODO collegamento con il back-end
export class CategoriaService {

  constructor() { }

  public getCategoie(){
    return[
      new Categoria("categoria1", "descrizione"),
      new Categoria("categoria2", "descrizione"),
      new Categoria("categoria3", "descrizione"),
      new Categoria("categoria4", "descrizione"),
      new Categoria("categoria5", "descrizione")
    ]
  }

}
