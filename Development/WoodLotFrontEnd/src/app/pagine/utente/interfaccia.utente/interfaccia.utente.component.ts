import { Component, OnInit } from '@angular/core';
import {UtenteService} from "../../../servizi/utente/utente.service";

@Component({
  selector: 'app-interfaccia-utente',
  templateUrl: './interfaccia.utente.component.html',
  styleUrls: ['./interfaccia.utente.component.scss']
})
export class InterfacciaUtenteComponent implements OnInit {

  public utente
  public listaNomi = ["Alberi", "Regali", "CO2"]
  public listaNumeri

  constructor(private serviceUtente:UtenteService) {
    this.utente = serviceUtente.getUtente()
    this.listaNumeri = serviceUtente.getStatisticheUtente()
  }



  ngOnInit(): void {
  }

}
