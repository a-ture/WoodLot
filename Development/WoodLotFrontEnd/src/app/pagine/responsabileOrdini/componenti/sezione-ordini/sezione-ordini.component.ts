import {Component, OnInit} from '@angular/core';
import {OrdineService} from "../../../../servizi/ordine/ordine.service";
import {Ordine} from "../../../../entita/ordine/ordine";

@Component({
  selector: 'app-sezione-ordini',
  templateUrl: './sezione-ordini.component.html',
  styleUrls: ['./sezione-ordini.component.scss']
})
export class SezioneOrdiniComponent implements OnInit {

  public listaOrdini !: Ordine[]

  constructor(private serviceOrdini: OrdineService) {
    serviceOrdini.getOrdini().subscribe(
      (data) => {
        this.listaOrdini = data
      }
    )
  }


  ngOnInit(): void {

  }

}
