import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-card-albero-regalo-list',
  templateUrl: './card-albero-regalo-list.component.html',
  styleUrls: ['./card-albero-regalo-list.component.scss']
})
export class CardAlberoRegaloListComponent implements OnInit {

  @Input()
  public listaAlberi !: ProdottoOrdine[]

  public listaNomi = [
    "Stato", "Dove è piantato", "Destinatario"
  ]

  public listaSourceImage = [
    "assets/img/profiloUtente/alberiUtente/03.jpeg",
    "assets/img/profiloUtente/alberiUtente/03.jpeg"
  ]

  public getDescrizioneCard(position : number){
    let prodotto = this.listaAlberi[position]
    return [prodotto.stato, prodotto.coordinateGeografiche, prodotto.destinatarioRegalo]
  }

  constructor() { }

  ngOnInit(): void {
  }

}
