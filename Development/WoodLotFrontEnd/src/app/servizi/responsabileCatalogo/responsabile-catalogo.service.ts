import { Injectable } from '@angular/core';
import {ResponsabileCatalogo} from "../../entita/responsabileCatalogo/responsabile-catalogo";
//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class ResponsabileCatalogoService {

  constructor() { }

  // restituisce un responsabile catalogo
  public getResponsabileCatalogo(){
    return new ResponsabileCatalogo("Mario", "Rossi");
  }
}
