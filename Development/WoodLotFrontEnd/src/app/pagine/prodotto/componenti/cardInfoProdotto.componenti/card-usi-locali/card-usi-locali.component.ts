import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {UsoLocaleService} from "../../../../../servizi/usoLocale/uso-locale.service";

@Component({
  selector: 'app-card-usi-locali',
  styleUrls: ['./card-usi-locali.component.scss'],
  template: `
    <c-card class="fs-5 text-center" style="background-color: #C4D89F">
      <c-card-body class="mx-4">
        <h5 cCardTitle class="fs-4 mb-4">Usi locali <i
          class="fa-solid fa-circle-info" [cModalToggle]="scrollableLongContentModal.id"></i></h5>
        <div class="row d-flex justify-content-center">

          <ul class="d-grid list-unstyled" *ngFor="let item of albero.usiLocali">
            <li class="d-flex gap-4"><img
              class="text-muted flex-shrink-0 rounded-circle" width="98"
              height="98"
              src="assets/img/paginaProdotto/usiLocali/{{item.nome}}.png">
              <div>
                <h6 class="mb-0">{{item.nome}}</h6>
                <p class="fw-lighter fs-6">{{item.descrizione}}</p>
              </div>
            </li>
          </ul>
        </div>
      </c-card-body>
    </c-card>

    <c-modal #scrollableLongContentModal id="scrollableLongContentModal" scrollable>
      <c-modal-header>
        <h5 cModalTitle>Usi Locali</h5>
        <button [cModalToggle]="scrollableLongContentModal.id" cButtonClose></button>
      </c-modal-header>
      <c-modal-body>
        <ng-container *ngTemplateOutlet="longContent"></ng-container>
      </c-modal-body>
      <c-modal-footer>
        <button [cModalToggle]="scrollableLongContentModal.id" cButton color="primary">Ho capito!</button>
      </c-modal-footer>
    </c-modal>

    <ng-template #longContent>
      <ul class="d-grid list-unstyled my-5" *ngFor="let item of usiLocali">
        <li class="d-flex gap-4"><img
          class="text-muted flex-shrink-0 rounded-circle" width="98"
          height="98"
          src="assets/img/paginaProdotto/usiLocali/{{item.nome}}.png">
          <div>
            <h6 class="mb-0">{{item.nome}}</h6>
            <p class="fw-lighter fs-6">{{item.descrizione}}</p>
          </div>
        </li>
      </ul>


    </ng-template>
  `
})
export class CardUsiLocaliComponent implements OnInit {

  public albero;
  public usiLocali;

  constructor(private serviceProdotto: ProdottoService, private serviceUsiLocali: UsoLocaleService) {
    this.albero = serviceProdotto.getProdottoInformazioni("castagno");
    this.usiLocali = serviceUsiLocali.getUsiLocali()
  }

  ngOnInit(): void {
  }


}
