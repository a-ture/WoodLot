import { Injectable } from '@angular/core';
import {ResponsabileCatalogo} from "../../entita/responsabileCatalogo/responsabile-catalogo";

@Injectable({
  providedIn: 'root'
})
export class ResponsabileCatalogoService {

  constructor() { }

  public getResponsabileCatalogo(){
    return new ResponsabileCatalogo("Mario", "Rossi");
  }
}
