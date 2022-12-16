import {Component, Input, OnInit} from '@angular/core';
import {Foresta} from "../../../../../entita/foresta/foresta";

@Component({
  selector: 'app-sezione-foreste',
  templateUrl: './sezione-foreste.component.html',
  styleUrls: ['./sezione-foreste.component.scss']
})
export class SezioneForesteComponent implements OnInit {

  @Input()
  public listaForeste !: Foresta[]

  constructor() { }

  ngOnInit(): void {
  }

}
