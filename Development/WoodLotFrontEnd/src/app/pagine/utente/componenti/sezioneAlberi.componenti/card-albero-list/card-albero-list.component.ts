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
    "Stato"
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

  public getDescrizioneCard(position: number) {
    let prodotto = this.listaAlberi[position];
    if (prodotto.stato == "NonAssegnato")
      prodotto.stato = 'Non Assegnato'

    let descrizione = [prodotto.stato];

    if (prodotto.contadino && prodotto.contadino.coordinateGeografiche) {
      descrizione.push(prodotto.contadino.coordinateGeografiche);
      this.listaNomi.push("Dove è piantato:")
    }

    return descrizione.filter(x => x !== undefined);
  }

  constructor() {}

  ngOnInit(): void {
  }

}
