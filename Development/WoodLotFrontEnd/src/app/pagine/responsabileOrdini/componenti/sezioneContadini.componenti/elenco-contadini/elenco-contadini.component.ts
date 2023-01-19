import { Component, OnInit } from '@angular/core';
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";

@Component({
  selector: 'app-elenco-contadini',
  templateUrl: './elenco-contadini.component.html',
  styleUrls: ['./elenco-contadini.component.scss']
})
export class ElencoContadiniComponent implements OnInit {

  public listaContadini

  constructor(private serviceContadini: ContadinoService) {
    this.listaContadini = serviceContadini.getContadini()
  }

  ngOnInit(): void {
  }

}
