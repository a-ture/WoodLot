import {Component, Input, OnInit} from '@angular/core';
import {Albero} from "../../../../../entita/albero/albero";

@Component({
  selector: 'app-sezione-elimina',
  templateUrl: './sezione-elimina.component.html',
  styleUrls: ['./sezione-elimina.component.scss']
})
export class SezioneEliminaComponent implements OnInit {

  @Input()
  public listaAlberi !: Albero[]

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.png"

  constructor() {
  }

  ngOnInit(): void {
  }

}
