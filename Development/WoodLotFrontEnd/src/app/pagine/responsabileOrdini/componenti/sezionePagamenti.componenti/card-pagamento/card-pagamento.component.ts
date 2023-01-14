import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-card-pagamento',
  templateUrl: './card-pagamento.component.html',
  styleUrls: ['./card-pagamento.component.scss']
})
export class CardPagamentoComponent implements OnInit {

  @Input()
  public prodottoOrdine !: ProdottoOrdine

  @Input()
  public sourceImage !: String

  public visible = false;

  toggleModal() {
    this.visible = !this.visible;
  }

  handleModal(event: any) {
    this.visible = event;
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
