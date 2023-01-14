import {Component, OnInit} from '@angular/core';
import {OrdineService} from "../../../../servizi/ordine/ordine.service";

@Component({
  selector: 'app-sezione-ordini',
  templateUrl: './sezione-ordini.component.html',
  styleUrls: ['./sezione-ordini.component.scss']
})
export class SezioneOrdiniComponent implements OnInit {

  public listaOrdini

  constructor(private serviceOrdini: OrdineService ) {
    this.listaOrdini = serviceOrdini.getOrdini()
  }


  ngOnInit(): void {

  }

}
