import {Component, OnInit} from '@angular/core';
import {ProdottoOrdineService} from "../../../../../servizi/prodottoOrdine/prodotto-ordine.service";

@Component({
  selector: 'app-sezione-pagamenti',
  templateUrl: './sezione-pagamenti.component.html',
  styleUrls: ['./sezione-pagamenti.component.scss']
})
export class SezionePagamentiComponent implements OnInit {

  public listaProdotti

  constructor(private serviceProdottoOrdine: ProdottoOrdineService) {
    this.listaProdotti = serviceProdottoOrdine.getProdottiDaRevisionare()
  }

  ngOnInit(): void {
  }

}
