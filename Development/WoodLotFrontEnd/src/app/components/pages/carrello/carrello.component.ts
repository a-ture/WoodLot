import { Component, OnInit } from '@angular/core';
import {CarrelloService} from "../../../services/carrello /carrello.service";

@Component({
  selector: 'app-carrello',
  templateUrl: './carrello.component.html',
  styleUrls: ['./carrello.component.scss']
})
export class CarrelloComponent implements OnInit {


  public urlBase= "assets/img/alberi/"
  public endBase = "/catalogo.png"

  public listProdotti

  constructor(private serviceCarrelloProdotto:CarrelloService) {
    this.listProdotti = serviceCarrelloProdotto.getCarrello()
  }

  public getTotalePezzi(){
    let conta = 0
    this.listProdotti.forEach( e => {
      conta += e.quantita
    })
    return conta
  }

  public getTotale(){
    let conta = 0
    this.listProdotti.forEach( e => {
      conta += (e.prezzo*e.quantita)
    })
    return conta
  }

  public getTasse(){
    return (this.getTotale()*22)/100
  }

  ngOnInit(): void {
  }

}
