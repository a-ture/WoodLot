import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {BeneficioService} from "../../../../../servizi/beneficio/beneficio.service";
import {Albero} from "../../../../../entita/albero/albero";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-card-benefici',
  styleUrls: ['./card-benefici.component.scss'],
  template: `
    <c-card class="fs-5 text-center" style="background-color: #C4D89F">
      <c-card-body class="mx-4">
        <h5 cCardTitle class="fs-4 mb-4">Benefici <i
          class="fa-solid fa-circle-info" [cModalToggle]="scrollableLongContentModal.id"></i></h5>
        <div class="row d-flex justify-content-center mt-3">
          <ul class="list-group list-group-horizontal-sm d-flex justify-content-center">
            <li class="list-group-item" *ngFor="let item of albero.benefici"><img
              class="text-muted flex-shrink-0 rounded-circle" width="68"
              height="68"
              src="assets/img/paginaProdotto/benefici/{{getSourceImage(item.nome)}}">
              <div>
                <h6 class="mb-0">{{item.nome}}</h6>
              </div>
            </li>
          </ul>
        </div>
      </c-card-body>
    </c-card>

    <c-modal #scrollableLongContentModal id="benefici" scrollable>
      <c-modal-header>
        <h5 cModalTitle>Benefici</h5>
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
      <ul class="d-grid list-unstyled my-5" *ngFor="let item of benefici">
        <li class="d-flex gap-4"><img
          class="text-muted flex-shrink-0 rounded-circle" width="68"
          height="68"
          src="assets/img/paginaProdotto/benefici/{{getSourceImage(item.nome)}}">
          <div>
            <h6 class="mb-0">{{item.nome}}</h6>
            <p class="fw-lighter">{{item.descrizione}}</p>
          </div>
        </li>
      </ul>
    </ng-template>

  `
})
export class CardBeneficiComponent implements OnInit {

  public albero !: Albero;
  public benefici;

  constructor(private serviceProdotto: ProdottoService, private serviceBenefici: BeneficioService, private route: ActivatedRoute) {
    this.benefici = serviceBenefici.getBenefici()
  }

  getSourceImage(nomeBenificio: String) {
    if (nomeBenificio == "Sicurezza alimentare")
      return "apple.svg"
    else if (nomeBenificio == "Sviluppo economico")
      return "money.svg"
    else if (nomeBenificio == "Assorbimento di anidride carbonica")
      return "cloud.svg"
    return "plant.svg"
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
