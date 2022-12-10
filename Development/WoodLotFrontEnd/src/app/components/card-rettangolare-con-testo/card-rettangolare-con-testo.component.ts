import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-rettangolare-con-testo',
  styleUrls: ['./card-rettangolare-con-testo.component.scss'],
  template: `
    <div class="card" style="width: 18rem; background-color:#94AD6E">
      <img src="{{sourceimage}}" class="card-img-top py-2 px-2"/>
      <div class="card-body">
        <p class="card-text">{{titolo}}</p>
      </div>
    </div>
  `

})
export class CardRettangolareConTestoComponent implements OnInit {

  @Input()
  public sourceimage!:String

  @Input()
  public titolo!:String

  constructor() { }

  ngOnInit(): void {
  }

}
