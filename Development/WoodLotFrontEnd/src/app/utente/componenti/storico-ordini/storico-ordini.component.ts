import {Component, Input, OnInit} from '@angular/core';
import {Ordine} from "../../../entita/ordine/ordine";

@Component({
  selector: 'app-storico-ordini',
  templateUrl: './storico-ordini.component.html',
  styleUrls: ['./storico-ordini.component.scss']
})
export class StoricoOrdiniComponent implements OnInit {

  @Input()
  public listaOrdini !: Ordine[]

  constructor() {}

  ngOnInit(): void {
  }

}
