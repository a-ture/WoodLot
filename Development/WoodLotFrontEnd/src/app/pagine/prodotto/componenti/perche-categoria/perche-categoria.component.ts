import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-perche-categoria',
  styleUrls: ['./perche-categoria.component.scss'],
  template: `
    <div class="container d-flex justify-content-center mb-5">
      <c-card class="mb-3" [ngStyle]="{'max-width.px': 1040}">
        <c-row class="g-0 d-flex justify-content-center ">

          <c-card-body cCol [md]="8">
            <h5 cCardTitle class="ms-5 " >Perchè  {{albero.categoria!.nome}}?</h5>
            <p cCardText   class="ms-5">
              {{albero.categoria!.descrizione}}
            </p>
          </c-card-body>
          <c-col [md]="4"  >
            <img [cCardImg] src="assets/img/paginaProdotto/categorie/01.jpg">
          </c-col>
        </c-row>
      </c-card>
    </div>
  `
})
export class PercheCategoriaComponent implements OnInit {

  public albero

  constructor(private serviceProdotto: ProdottoService) {
    this.albero = serviceProdotto.getProdottoInformazioni("castagno");
  }

  ngOnInit(): void {
  }

}
