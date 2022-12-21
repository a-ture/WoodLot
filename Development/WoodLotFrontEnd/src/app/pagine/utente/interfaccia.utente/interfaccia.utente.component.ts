import {Component, OnInit} from '@angular/core';
import {UtenteService} from "../../../servizi/utente/utente.service";
import {ProdottoOrdine} from "../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-interfaccia-utente',
  templateUrl: './interfaccia.utente.component.html',
  styleUrls: ['./interfaccia.utente.component.scss']
})


export class InterfacciaUtenteComponent implements OnInit {

  public utente
  public listaNomi = ["Alberi", "Regali", "- Anidride Carbonica"]
  public listaNumeri



  constructor(private serviceUtente: UtenteService) {
    this.utente = serviceUtente.getUtente()
    this.listaNumeri = serviceUtente.getStatisticheUtente()

  }

  //restituisce tutti gli alberi di un utente
  public getAlberiUtente() {
    let alberi = new Array<ProdottoOrdine>()
    this.utente.listaOrdini.forEach(e => {
      e.listaProdottiOrdine.forEach(i => {
        alberi.push(i)
      })
    })
    return alberi
  }


  ngOnInit(): void {
  }

}
