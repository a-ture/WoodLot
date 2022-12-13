import {Component, Input, OnInit} from '@angular/core';
import {ProdottoCarrello} from "../../../entita/prodottoCarrello/prodotto-carrello";

@Component({
  selector: 'app-prodotto-carrello',
  templateUrl: './prodotto.carrello.component.html',
  styleUrls: ['./prodotto.carrello.component.scss']
})
export class ProdottoCarrelloComponent implements OnInit {

  @Input()
  public sourceImage !: String

  @Input()
  public prodottoCarrello !: ProdottoCarrello

  constructor() { }

  ngOnInit(): void {
  }

  public getPrezzoTotale(){
    return this.prodottoCarrello.quantita * this.prodottoCarrello.prezzo
  }

}
