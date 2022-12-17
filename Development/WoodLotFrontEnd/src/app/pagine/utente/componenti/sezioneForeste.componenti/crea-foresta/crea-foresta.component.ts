import {Component, Input, OnInit} from '@angular/core';
import {Albero} from "../../../../../entita/albero/albero";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-crea-foresta',
  templateUrl: './crea-foresta.component.html',
  styleUrls: ['./crea-foresta.component.scss']
})
export class CreaForestaComponent implements OnInit {

  @Input()
  public listaAlberi!: ProdottoOrdine[]

  constructor() {
  }

  ngOnInit(): void {
  }

}
