import {Component, Input, OnInit} from '@angular/core';


@Component({
  selector: 'app-benvenuto',
  templateUrl: './benvenuto.component.html',
  styleUrls: ['./benvenuto.component.scss']
})
export class BenvenutoComponent implements OnInit {

  @Input()
  public listaNomi !: String[]

  @Input()
  public listaNumeri !: String[]

  @Input()
  public nome !: String

  @Input()
  public cognome !: String

  constructor() {}

  ngOnInit(): void {
  }

}
