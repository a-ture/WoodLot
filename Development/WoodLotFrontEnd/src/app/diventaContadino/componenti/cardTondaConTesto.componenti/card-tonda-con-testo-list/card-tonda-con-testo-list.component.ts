import { Component, OnInit } from '@angular/core';
import {StatisticheService} from "../../../../servizi/statistiche/statistiche.service";

@Component({
  selector: 'app-card-tonda-con-testo-list',
  templateUrl: './card-tonda-con-testo-list.component.html',
  styleUrls: ['./card-tonda-con-testo-list.component.scss']
})
export class CardTondaConTestoListComponent implements OnInit {

  public listaColori = ["#cddba4", "#bddfd2", "#fbf0a2", "#e8ebfa"]
  public listaNomi = ["Alberi piantati", "Tonnellate di CO2 assorbite","Contadini coinvolti","Paesi"]
  public listaNumeri
  public listaSource = [
    "assets/img/diventaUnContadino/16.svg",
    "assets/img/diventaUnContadino/14.svg",
    "assets/img/diventaUnContadino/15.svg",
    "assets/img/diventaUnContadino/13.svg",
    ]

  constructor(private serviceStatistiche:StatisticheService) {
    this.listaNumeri = serviceStatistiche.getStatistiche()
  }

  ngOnInit(): void {

  }

}
