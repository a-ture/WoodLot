import { Injectable } from '@angular/core';
import {Orso} from "../entity/Orso";

@Injectable({
  providedIn: 'root'
})
export class OrsoService {

  private orsi:Orso[]

  constructor() {
    this.orsi =
      [
        new Orso(4,"Raffaella"),

        new Orso(6, "Elpidio")

      ]
  }

  public getOrsi(): Orso[]{
    return this.orsi;
  }
}
