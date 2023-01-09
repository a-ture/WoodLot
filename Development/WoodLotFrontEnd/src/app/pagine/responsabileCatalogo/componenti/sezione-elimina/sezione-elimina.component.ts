import {Component, Input, OnInit} from '@angular/core';
import {Albero} from "../../../../entita/albero/albero";

@Component({
  selector: 'app-sezione-elimina',
  templateUrl: './sezione-elimina.component.html',
  styleUrls: ['./sezione-elimina.component.scss']
})
export class SezioneEliminaComponent implements OnInit {
  @Input()
  public listaAlberi !: Albero[]

  public listaNomi = [
    "Prezzo", "Paese"
  ]

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.png"

  constructor() {
  }

  public getDescrizioneCard(position: number) {
    let prodotto = this.listaAlberi[position]
    return [prodotto.prezzo + "", prodotto.paese?.nome+""]
  }

  ngOnInit(): void {
  }

}
