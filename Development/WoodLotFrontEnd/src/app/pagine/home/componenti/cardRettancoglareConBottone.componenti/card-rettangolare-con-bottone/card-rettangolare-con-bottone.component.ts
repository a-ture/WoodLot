import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-rettangolare-con-bottone',
  styleUrls: ['./card-rettangolare-con-bottone.component.scss'],
  template: `
      <div class="card text-center h-100 "
           style="width:14rem;background-color:white">
        <img src="{{sourceimage}}" class="card-img" width="206px" height="206px"/>
        <div class="card-body">
          <p class="card-title fw-bold">{{titolo}}</p>
          <p>{{descrizione}}</p>
          <button class="btn btn-rounded" style="background-color:#5E7250; color:white">{{titolo}}</button>
        </div>
      </div>
  `
})
export class CardRettangolareConBottoneComponent implements OnInit {

  @Input()
  public titolo !: String

  @Input()
  public descrizione !: String

  @Input ()
  public  sourceimage !: String

  constructor() { }

  ngOnInit(): void {
  }

}
