import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-tonda-con-testo',
  styleUrls: ['./card-tonda-con-testo.component.scss'],
  template: `
    <div>
        <c-avatar size="xl" src="{{sourceimage}}" style="background-color:{{colore}}"></c-avatar>

        <h5 class="mt-2">{{numero}}</h5>
        <p>{{testo}}</p>
    </div>
  `
})
export class CardTondaConTestoComponent implements OnInit {

  @Input()
  public sourceimage!:String

  @Input()
  public numero!:String

  @Input()
  public testo!:String

  @Input()
  public colore!:String

  constructor() { }

  ngOnInit(): void {
  }

}
