import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";
import {Contadino} from "../../../../../entita/contadino/contadino";

@Component({
  selector: 'app-elenco-contadini',
  templateUrl: './elenco-contadini.component.html',
  styleUrls: ['./elenco-contadini.component.scss']
})
export class ElencoContadiniComponent implements OnInit {

  public listaContadini !: Contadino[]

  constructor(private serviceContadini: ContadinoService) {
    serviceContadini.getContadini().subscribe(
      (data) => {
        this.listaContadini = data
      }
    )
  }

  ngOnInit(): void {
  }

}
