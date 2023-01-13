import { Component, OnInit } from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-card-descrizione-prodotto',
  styleUrls: ['./card-descrizione-prodotto.component.scss'],
  template: `
    <c-card class="text-center" style="background-color: #C4D89F">
      <c-card-body class="mx-4">
        <h5 cCardTitle>Descrizione</h5>
        <p cCardText>
          {{albero.descrizione}}
        </p>
      </c-card-body>
    </c-card>
  `
})
export class CardDescrizioneProdottoComponent implements OnInit {

  public albero

  constructor(private serviceProdotto: ProdottoService) {
    this.albero = serviceProdotto.getProdottoInformazioni("castagno");
  }

  ngOnInit(): void {
  }

}
