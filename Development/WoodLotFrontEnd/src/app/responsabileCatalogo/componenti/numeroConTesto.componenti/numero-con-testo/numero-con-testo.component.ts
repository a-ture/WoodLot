import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-numero-con-testo',
  styleUrls: ['./numero-con-testo.component.scss'],
  template: `
    <div>
      <h5 class="mt-2">{{numero}}</h5>
      <p>{{testo}}</p>
    </div>
  `
})
export class NumeroConTestoComponent implements OnInit {

  @Input()
  public numero!:String

  @Input()
  public testo!:String

  constructor() { }

  ngOnInit(): void {
  }

}
