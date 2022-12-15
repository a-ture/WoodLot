import {Component, Input, OnInit} from '@angular/core';
import {Albero} from "../../../entita/albero/albero";

@Component({
  selector: 'app-card-prodotto',
  styleUrls: ['./card-prodotto.component.scss'],
  template:`
    <div class="card text-center rounded col rounded-5" style="width: 18rem;">
      <img src="{{sourceimage}}" class="card-img-top"/>
      <div class="card-body">
        <h5 class="card-title">{{albero.nome}}</h5>
        <p class="card-text"><strong>CO<sub>2</sub></strong>: -{{albero.co2}} kg</p>
      </div>
      <ul class="list-group list-group-light list-group-small">
        <li class="list-group-item px-4"><strong>Prezzo:</strong> {{albero.prezzo}} €</li>
      </ul>
      <div class="card-body">
        <a href="#" class="btn btn-rounded" style="background-color:#5E7250; color:white">Scopri di più!</a>
      </div>
    </div>
  `
})
export class CardProdottoComponent implements OnInit {

  @Input()
  public albero!:Albero

  @Input()
  public sourceimage!:String

  constructor() { }

  ngOnInit(): void {
  }

}
