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
  public listaNomi = ["Alberi", "- Anidride Carbonica"]
  public listaNumeri !: string[]


  constructor(private serviceUtente: UtenteService) {
    this.utente = serviceUtente.getUtente()
    if (this.utente.id)
      serviceUtente.getStatisticheUtente(this.utente.id).subscribe((data: string[]) => {
        this.listaNumeri = data
      })
    console.log(this.utente.listaOrdini)
  }

  //restituisce tutti gli alberi di un utente
  public getAlberiUtente() {
    let alberi = new Array<ProdottoOrdine>()
    this.utente?.listaOrdini?.forEach(e => {
      e.prodottiOrdine?.forEach(i => {
        alberi.push(i)
      })
    })
    return alberi
  }


  ngOnInit(): void {
  }

}
