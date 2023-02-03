import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {UsoLocaleService} from "../../../../../servizi/usoLocale/uso-locale.service";
import {Albero} from "../../../../../entita/albero/albero";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-card-usi-locali',
  styleUrls: ['./card-usi-locali.component.scss'],
  template: `
    <c-card class="fs-5 text-center" style="background-color: #C4D89F">
      <c-card-body class="mx-4">
        <h5 cCardTitle class="fs-4 mb-4">Usi locali <i
          class="fa-solid fa-circle-info" [cModalToggle]="scrollableLongContentModal.id"></i></h5>
        <div class="row d-flex justify-content-center">
          <ul class="list-group list-group-horizontal-sm d-flex justify-content-center">
            <li class="list-group-item" *ngFor="let item of albero.usiLocali"><img
              class="text-muted flex-shrink-0 rounded-circle" width="98"
              height="98"
              src="assets/img/paginaProdotto/usiLocali/{{item.nome.replace(' ','')}}.png">
              <div>
                <h6 class="mb-0">{{item.nome}}</h6>
              </div>
            </li>
          </ul>
        </div>
      </c-card-body>
    </c-card>

    <c-modal #scrollableLongContentModal id="usiLocali" scrollable>
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
            <p class="fw-lighter">{{item.descrizione}}</p>
          </div>
        </li>
      </ul>
    </ng-template>
  `
})
export class CardUsiLocaliComponent implements OnInit {

  public albero !: Albero;
  public usiLocali;

  constructor(private serviceProdotto: ProdottoService, private serviceUsiLocali: UsoLocaleService,private route: ActivatedRoute) {

    this.usiLocali = serviceUsiLocali.getUsiLocali()
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const nome = params['nomeProdotto'];
      this.serviceProdotto.getProdottoInformazioni(nome).subscribe(data => {
        this.albero = data;
      });
    });
  }


}
