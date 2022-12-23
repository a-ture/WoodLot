import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-foto-con-testo',
  styleUrls: ['./foto-con-testo.component.scss'],
  template:`
    <div class="row mb-5 d-flex justified-content-center">
      <div class="{{class}}" >
        <h2>{{titolo}}</h2>
        <p class="lead">{{descrizione}}</p>
      </div>
      <div class="col-md-5">
        <img src="{{sourceImage}}"
             class="img-fluid m-auto">
      </div>
    </div>
  `
})
export class FotoConTestoComponent implements OnInit {

  @Input()
  public sourceImage !: String

  @Input()
  public descrizione !: String

  @Input()
  public titolo !: String

  @Input()
  public class !: String

  constructor() { }

  ngOnInit(): void {
  }

}
