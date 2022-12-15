import { Component, OnInit } from '@angular/core';
import {ResponsabileCatalogoService} from "../../../servizi/responsabileCatalogo/responsabile-catalogo.service";
import {StatisticheService} from "../../../servizi/statistiche/statistiche.service";

@Component({
  selector: 'app-interfaccia-responsabile-catalogo',
  templateUrl: './interfaccia.responsabile-catalogo.component.html',
  styleUrls: ['./interfaccia.responsabile-catalogo.component.scss']
})
export class InterfacciaResponsabileCatalogoComponent implements OnInit {

  public responsabileCatalogo
  public listaNumeri
  public listNomi = ["Alberi piantati", "Tonnellate di CO2 assorbite","Contadini coinvolti","Paesi"]

  constructor(private serviceResponsabileCatalogo : ResponsabileCatalogoService, private serviceStatistiche:StatisticheService) {
    this.responsabileCatalogo = serviceResponsabileCatalogo.getResponsabileCatalogo()
    this.listaNumeri = serviceStatistiche.getStatistiche()
  }

  ngOnInit(): void {
  }

}
