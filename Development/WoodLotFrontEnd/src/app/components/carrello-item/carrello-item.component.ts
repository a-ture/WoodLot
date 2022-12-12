import {Component, Input, OnInit} from '@angular/core';
import {ProdottoCarrello} from "../../entities/prodottoCarrello/prodotto-carrello";

@Component({
  selector: 'app-carrello-item',
  templateUrl: './carrello-item.component.html',
  styleUrls: ['./carrello-item.component.scss']
})
export class CarrelloItemComponent implements OnInit {

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
