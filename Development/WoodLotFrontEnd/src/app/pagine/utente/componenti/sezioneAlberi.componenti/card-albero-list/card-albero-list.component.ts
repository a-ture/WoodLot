import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

//TODO sistemare img
@Component({
  selector: 'app-card-albero-list',
  templateUrl: './card-albero-list.component.html',
  styleUrls: ['./card-albero-list.component.scss']
})
export class CardAlberoListComponent implements OnInit {

  @Input()
  public listaAlberi !: ProdottoOrdine[]

  public listaNomi = [
    "Stato", "Dove è piantato"
  ]

  public listaSourceImage = [
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
  ]

  public getDescrizioneCard(position : number){
    let prodotto = this.listaAlberi[position]
    return [prodotto.stato, prodotto.coordinateGeografiche]
  }
  constructor() {}

  ngOnInit(): void {
  }

}
