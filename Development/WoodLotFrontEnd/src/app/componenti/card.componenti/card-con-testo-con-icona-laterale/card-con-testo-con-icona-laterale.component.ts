import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-con-testo-con-icona-laterale',
  styleUrls: ['./card-con-testo-con-icona-laterale.component.scss'],
  template:`
    <div class="col d-flex align-items-start" >
      <i [ngClass]="iclass" ></i>
      <div style="background-color:#F4EBC7">
        <h4 class="fw-bold mb-0">{{titolo}}</h4>
        <p>{{descrizione}}</p>
      </div>
    </div>
  `
})
export class CardConTestoConIconaLateraleComponent implements OnInit {

  @Input()
  public iclass !: String

  @Input()
  public titolo !: String

  @Input()
  public descrizione !: String
  constructor() { }

  ngOnInit(): void {
  }

}
