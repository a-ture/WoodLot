import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-testo-con-icona',
  styleUrls: ['./card-testo-con-icona.component.scss'],
  template: `
    <div class="card mb-3" style="width: 25rem; height: 15rem; background-color:#F4EBC7">
      <div class="text-center mt-3 ">
      <c-avatar size="md"  style="background-color:white"><i class="{{sourceimage}} text-{{colore}}"></i></c-avatar>
      </div>
      <div class="card-body">
        <h5 class="card-title">{{titolo}}</h5>
        <p class="card-text">{{testo}}</p>
      </div>
    </div>
  `
})
export class CardTestoConIconaComponent implements OnInit {

  @Input()
  public sourceimage!: String

  @Input()
  public titolo!: String

  @Input()
  public testo!: String

  @Input()
  public colore!: String

  constructor() { }

  ngOnInit(): void {
  }

}
