import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-card-albero-list',
  templateUrl: './card-albero-list.component.html',
  styleUrls: ['./card-albero-list.component.scss']
})
export class CardAlberoListComponent implements OnInit {

  @Input()
  public listaAlberi !: ProdottoOrdine[]

  public getDescrizioneCard(position: number) {
    let prodotto = this.listaAlberi[position];
    if (prodotto.stato == "NonAssegnato")
      prodotto.stato = 'Non Assegnato'
    let descrizione = [prodotto.stato];
    if (prodotto.contadino && prodotto.contadino.coordinateGeografiche) {
      descrizione.push(prodotto.contadino.coordinateGeografiche)
    }
    if (prodotto.descrizione) {
      descrizione.push(prodotto.descrizione)
    }
    if (prodotto.stato == 'Frutto') {
      descrizione.push(prodotto.frutta + " kg")
    }
    return descrizione.filter(x => x !== undefined);
  }

  public getNomiCard(position: number) {
    let prodotto = this.listaAlberi[position];

    let descrizione = ['Stato'];

    if (prodotto.contadino && prodotto.contadino.coordinateGeografiche) {
      descrizione.push("Dove è piantato")
    }
    if (prodotto.descrizione) {
      descrizione.push("Descrizione")
    }
    if (prodotto.stato == 'Frutto') {
      descrizione.push("Frutta raccolta")
    }
    return descrizione.filter(x => x !== undefined);
  }

  public getSourceImage(position: number) {
    let p = this.listaAlberi[position];
    if (p.stato == 'Non Assegnato' || p.stato == 'Assegnato') {
      return 'assets/img/alberi/' + p.nomeAlbero.toLowerCase() + '/catalogo.webp'
    } else {
      return 'assets/img/alberiUtente/' + p?.contadino?.id + '/' + p?.id + '.jpeg'
    }

  }

  constructor() {

  }

  ngOnInit(): void {

  }
}
