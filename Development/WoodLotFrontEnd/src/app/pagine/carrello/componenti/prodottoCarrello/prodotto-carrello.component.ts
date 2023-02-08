import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProdottoCarrello} from "../../../../entita/prodottoCarrello/prodotto-carrello";
import {CarrelloService} from "../../../../servizi/carrello/carrello.service";

//TODO aggiungere collegamento ai bottone
@Component({
  selector: 'app-prodotto-carrello',
  templateUrl: './prodotto-carrello.component.html',
  styleUrls: ['./prodotto-carrello.component.scss']
})
export class ProdottoCarrelloComponent implements OnInit {

  @Input()
  public sourceImage !: String

  @Input()
  public prodottoCarrello !: ProdottoCarrello

  constructor(private serviceCarrello: CarrelloService) {
  }

  @Output()
  productDeletedCart = new EventEmitter<any>();

  ngOnInit(): void {
  }

  public rimuoviProdotto(id: number) {
    const storedCarrello = sessionStorage.getItem('carrello');
    if (storedCarrello != null) {
      let carrello = JSON.parse(storedCarrello)
      sessionStorage.removeItem('carrello')
      this.serviceCarrello.rimuovereProdotto(carrello.id, id).subscribe(
        (data) => {
          carrello = data
          console.log(data)
          sessionStorage.setItem('carrello', JSON.stringify(carrello));
          this.productDeletedCart.emit()
        })
    }
  }
}
