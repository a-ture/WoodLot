import {Component, Input, OnInit} from '@angular/core';
import {Foresta} from "../../../../../entita/foresta/foresta";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-card-foresta-list',
  templateUrl: './card-foresta-list.component.html',
  styleUrls: ['./card-foresta-list.component.scss']
})
export class CardForestaListComponent implements OnInit {

  @Input()
  public listaAlberi!: ProdottoOrdine[]

  @Input()
  public listaAlberiForesta !: Foresta[]

  @Input()
  public tipo !: String

  public listaSourceImage = [
    "assets/img/profiloUtente/foreste/foresta.jpeg",
    "assets/img/profiloUtente/foreste/foresta1.png"
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
