import { Component, OnInit } from '@angular/core';
import {StatisticheService} from "../../../../servizi/statistiche/statistiche.service";
import {ResponsabileCatalogoService} from "../../../../servizi/responsabileCatalogo/responsabile-catalogo.service";

@Component({
  selector: 'app-numero-con-testo-list',
  templateUrl: './numero-con-testo-list.component.html',
  styleUrls: ['./numero-con-testo-list.component.scss']
})
export class NumeroConTestoListComponent implements OnInit {

  public listaNomi = ["Alberi piantati", "Tonnellate di CO2 assorbite","Contadini coinvolti","Paesi"]
  public listaNumeri
  public responsabileCatalogo

  constructor(private serviceStatistiche:StatisticheService, private serviceResponsabileCatalogo:ResponsabileCatalogoService) {
    this.listaNumeri = serviceStatistiche.getStatistiche()
    this.responsabileCatalogo = serviceResponsabileCatalogo.getResponsabileCatalogo()
  }

  ngOnInit(): void {
  }

}
