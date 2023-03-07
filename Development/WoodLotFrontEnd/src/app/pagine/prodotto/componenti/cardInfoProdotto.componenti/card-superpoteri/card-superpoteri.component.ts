import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../../entita/albero/albero";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-card-superpoteri',
  styleUrls: ['./card-superpoteri.component.scss'],
  template: `
    <c-card class="fs-5 text-center" style="background-color: #C4D89F">
      <c-card-body class="mx-4">
        <h5 cCardTitle class="fs-4 mb-4">I miei superpoteri</h5>
        <div class="row">
          <div class="col-md-4 col-sm-12 m-sm-0">
            <p class="card-text">
              <strong>CO<sub>2</sub>
                Assorbita</strong>
            </p>
          </div>
          <div class="col">
            <ng-container *ngFor="let item of calcolaStelleAnidrideCarbonica()">
              <img *ngIf="item == 'stellaColorata'"
                   src="assets/img/paginaProdotto/rating/Star1.svg" class="mx-1">
              <img *ngIf="item == 'stellaNonColorata'" class="mx-1"
                   src="assets/img/paginaProdotto/rating/Star5.svg">
            </ng-container>
          </div>
        </div>

        <div class="row mt-3">
          <div class="col-md-4 col-sm-12 m-sm-0">
            <p class="card-text">
              <strong>Salvaguardia</strong>
            </p>
          </div>
          <div class="col">
            <ng-container *ngFor="let item of calcolaStelleSalvaguardia()">
              <img *ngIf="item == 'stellaColorata'"
                   src="assets/img/paginaProdotto/rating/Star1.svg" class="mx-1">
              <img *ngIf="item == 'stellaNonColorata'" class="mx-1"
                   src="assets/img/paginaProdotto/rating/Star5.svg">
            </ng-container>
          </div>
        </div>
      </c-card-body>
    </c-card>


  `
})
export class CardSuperpoteriComponent implements OnInit {

  public albero !: Albero

  constructor(private serviceProdotto: ProdottoService, private route: ActivatedRoute) {

  }

  calcolaStelleAnidrideCarbonica() {
    let array = new Array<String>()
    let stelleNonColorate = this.albero?.anidrideCarbonicaAssorbita % 5
    let stelleColorate = 5 - stelleNonColorate
    for (let i = 0; i < stelleColorate; i++) {
      array.push("stellaColorata")
    }
    for (let i = 0; i < stelleNonColorate; i++) {
      array.push("stellaNonColorata")
    }
    return array
  }

  calcolaStelleSalvaguardia() {
    let array = new Array<String>()
    let stelleColorate = this.albero?.salvaguardia
    // @ts-ignore
    let stelleNonColorate = 5 - stelleColorate
    // @ts-ignore
    for (let i = 0; i < stelleColorate; i++) {
      array.push("stellaColorata")
    }
    for (let i = 0; i < stelleNonColorate; i++) {
      array.push("stellaNonColorata")
    }
    return array
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
