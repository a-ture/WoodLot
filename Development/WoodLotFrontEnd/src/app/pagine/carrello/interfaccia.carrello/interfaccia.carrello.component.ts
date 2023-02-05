import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../servizi/carrello/carrello.service";

//TODO aggiungere logica pulsanti
@Component({
  selector: 'app-interfaccia-carrello',
  templateUrl: './interfaccia.carrello.component.html',
  styleUrls: ['./interfaccia.carrello.component.scss']
})
export class InterfacciaCarrelloComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"

  public listProdotti

  constructor(private serviceCarrelloProdotto: CarrelloService) {
    this.listProdotti = serviceCarrelloProdotto.getCarrello()
  }


  public getTotale() {
    let conta = 0
    this.listProdotti.forEach(e => {
      conta += e.prezzo
    })
    return conta
  }

  public getTasse() {
    return (this.getTotale() * 22) / 100
  }

  public getTotaleSenzaTasse() {
    return this.getTotale() - this.getTasse()
  }

  ngOnInit(): void {
  }

}
