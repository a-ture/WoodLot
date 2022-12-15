import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-albero',
  styleUrls: ['./card-albero.component.scss'],
  template: `
    <c-card class="h-100">
      <c-row class="g-0">
        <c-col [md]="4">
          <img [cCardImg] class="img-fluid" src="{{sourceImage}}">
        </c-col>
        <c-card-body cCol [md]="8">
          <h5 cCardTitle class="mb-2">{{titolo}}</h5>
          <p cCardText *ngFor="let item of listaNomi; index as i">
            <b>{{listaNomi[i]}}</b>: {{listaDescrizioni[i]}}
          </p>
        </c-card-body>
      </c-row>
    </c-card>
  `
})
export class CardAlberoComponent implements OnInit {

  @Input()
  public titolo !: String

  @Input()
  public sourceImage !: String

  @Input()
  public listaNomi !: String[]

  @Input()
  public listaDescrizioni !: String[]

  constructor() {
  }

  ngOnInit(): void {
  }

}
