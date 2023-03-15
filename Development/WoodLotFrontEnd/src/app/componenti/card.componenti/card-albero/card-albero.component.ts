import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-albero',
  styleUrls: ['./card-albero.component.scss'],
  template: `
    <c-card class="mb-3" id="{{titolo}}}">
      <img cCardImg="top" src="{{sourceImage}}" style="max-height: 300px;">
      <c-card-body>
        <h5 cCardTitle>{{titolo}}</h5>
        <p cCardText *ngFor="let item of listaNomi; index as i">
          <b>{{listaNomi[i]}}</b>: {{listaDescrizioni[i]}}
        </p>
      </c-card-body>
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
