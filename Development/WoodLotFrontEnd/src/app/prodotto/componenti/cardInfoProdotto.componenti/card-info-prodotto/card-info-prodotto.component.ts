import { Component, OnInit } from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-card-info-prodotto',
  templateUrl: './card-info-prodotto.component.html',
  styleUrls: ['./card-info-prodotto.component.scss']
})
export class CardInfoProdottoComponent implements OnInit {

  public albero

  constructor(private serviceProdotto: ProdottoService) {
    this.albero = serviceProdotto.getProdottoInformazioni("castagno");
  }

  ngOnInit(): void {
  }

}
