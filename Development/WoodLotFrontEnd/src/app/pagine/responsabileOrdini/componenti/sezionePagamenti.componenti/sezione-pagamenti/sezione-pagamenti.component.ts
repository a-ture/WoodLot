import {Component, OnInit} from '@angular/core';
import {ProdottoOrdineService} from "../../../../../servizi/prodottoOrdine/prodotto-ordine.service";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-sezione-pagamenti',
  templateUrl: './sezione-pagamenti.component.html',
  styleUrls: ['./sezione-pagamenti.component.scss']
})
export class SezionePagamentiComponent implements OnInit {

  public listaProdotti!: ProdottoOrdine[]

  constructor(private serviceProdottoOrdine: ProdottoOrdineService) {
    serviceProdottoOrdine.getProdottiDaRevisionare().subscribe((data) => {
      this.listaProdotti = data
    })
  }

  ngOnInit(): void {
  }

  handleCambiamento(){
    this.serviceProdottoOrdine.getProdottiDaRevisionare().subscribe((data) => {
      this.listaProdotti = data
    })
  }
}
