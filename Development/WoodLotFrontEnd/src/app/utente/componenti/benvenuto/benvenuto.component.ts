import {Component, Input, OnInit} from '@angular/core';
import {UtenteService} from "../../../servizi/utente/utente.service";
import {Utente} from "../../../entita/utente/utente";

@Component({
  selector: 'app-benvenuto',
  templateUrl: './benvenuto.component.html',
  styleUrls: ['./benvenuto.component.scss']
})
export class BenvenutoComponent implements OnInit {

  public listaNomi = ["Alberi", "Regali", "CO2"]
  public listaNumeri

  @Input()
  public utente !: Utente

  constructor(private serviceUtente:UtenteService) {
    this.listaNumeri = serviceUtente.getStatisticheUtente()
  }

  ngOnInit(): void {
  }

}
