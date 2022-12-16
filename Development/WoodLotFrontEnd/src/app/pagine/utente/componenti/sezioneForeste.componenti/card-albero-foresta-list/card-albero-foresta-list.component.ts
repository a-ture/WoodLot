import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";
import {Albero} from "../../../../../entita/albero/albero";

@Component({
  selector: 'app-card-albero-foresta-list',
  templateUrl: './card-albero-foresta-list.component.html',
  styleUrls: ['./card-albero-foresta-list.component.scss']
})
export class CardAlberoForestaListComponent implements OnInit {

  @Input()
  public listaAlberi !: ProdottoOrdine[]

  public listaNomi = [
    "Stato", "Paese"
  ]

  public listaSourceImage = [
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg"
  ]

  public getDescrizioneCard(position : number){
    let prodotto = this.listaAlberi[position]
    return [prodotto.stato, prodotto.coordinateGeografiche]
  }

  constructor() { }

  ngOnInit(): void {
  }

}
