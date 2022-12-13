import { Component, OnInit } from '@angular/core';
import {UtenteService} from "../../../servizi/utente/utente.service";

@Component({
  selector: 'app-benvenuto',
  templateUrl: './benvenuto.component.html',
  styleUrls: ['./benvenuto.component.scss']
})
export class BenvenutoComponent implements OnInit {

  public listaNomi = ["Alberi", "Regali", "CO2"]
  public listaNumeri
  public utente

  constructor(private serviceUtente:UtenteService) {
    this.utente = serviceUtente.getUtente()
    this.listaNumeri = serviceUtente.getStatisticheUtente()
  }

  ngOnInit(): void {
  }

}
